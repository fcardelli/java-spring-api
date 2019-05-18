package com.clientes.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.apirest.models.Cliente;
import com.clientes.apirest.repositories.ClienteRepository;

@RestController
@RequestMapping(value="/")
public class ClienteController {
	
	@Autowired 
	ClienteRepository clienteRepository;
		
	@GetMapping("/clientes")
	public List<Cliente> getListaClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente getClientePorId(@PathVariable(value="id") long id) {
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/cliente")
	public Cliente setSalvaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/cliente")
	public void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	 
	@DeleteMapping("/cliente/{id}")
	public void deletaClientePorId(@PathVariable(value="id") long id) {
		clienteRepository.deleteById(id);
	}
}
