package org.serratec.aula03.controller;

import java.util.List;
import org.serratec.aula03.domain.Produto;
import org.serratec.aula03.exception.RecursoNaoEncontradoException;
import org.serratec.aula03.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Produto" + id + "não encontrado."));
		
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto produto,
			@PathVariable Long id) {
		
		if(!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		produto.setId(id);
		produto = produtoRepository.save(produto);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
