package com.serratec.aula06_07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.aula06_07.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {}