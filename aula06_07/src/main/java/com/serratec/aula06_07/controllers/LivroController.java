package com.serratec.aula06_07.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.aula06_07.models.Livro;
import com.serratec.aula06_07.repositories.LivroRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository repository;

    @PostMapping
    public ResponseEntity<Livro> postLivro(@RequestBody @Valid Livro livro) {
        
        return ResponseEntity.status(201).body(repository.save(livro));
    }

    @GetMapping
    public List<Livro> getLivros() {
        return repository.findAll();
    }
}
