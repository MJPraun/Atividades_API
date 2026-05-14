package org.serratec.aula03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.serratec.aula03.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}