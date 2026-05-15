package com.serratec.aula06_07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.aula06_07.models.Editora;
import com.serratec.aula06_07.repositories.EditoraRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository repository;

    @PostMapping
    public ResponseEntity<Editora> criar(@RequestBody @Valid Editora editora) {
        return ResponseEntity.status(201).body(repository.save(editora));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
