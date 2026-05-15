package com.serratec.aula06_07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.aula06_07.models.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {}