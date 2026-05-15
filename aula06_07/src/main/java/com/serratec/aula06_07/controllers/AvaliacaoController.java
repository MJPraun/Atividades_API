package com.serratec.aula06_07.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.serratec.aula06_07.models.Avaliacao; // Importar Avaliacao
import com.serratec.aula06_07.repositories.AvaliacaoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository repository;

    @PostMapping
    public ResponseEntity<Avaliacao> postAvaliacao(@RequestBody @Valid Avaliacao avaliacao) {
    Avaliacao saved = repository.save(avaliacao);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> getAvaliacoes() {
    List<Avaliacao> lista = repository.findAll();
    return ResponseEntity.ok(lista);
    }
}