package com.clientes.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientes.apirest.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findById(long id);
	Cliente deleteById(long id);
}
