package com.igortodesco.gerenciadorcliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.igortodesco.gerenciadorcliente.convertes.ClienteConverter;
import com.igortodesco.gerenciadorcliente.dtos.ClienteDto;
import com.igortodesco.gerenciadorcliente.entities.Cliente;
import com.igortodesco.gerenciadorcliente.services.ClienteService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ClienteDto salvarCliente(@RequestBody ClienteDto dto) {
		Cliente cliente = ClienteConverter.converterParaEntidade(dto);
		Cliente clienteSalvo = service.salvarCliente(cliente);
		return ClienteConverter.converterParaDTO(clienteSalvo);
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<ClienteDto> buscarTodos(){
		List<Cliente> clientes = service.buscarTodos();
		return ClienteConverter.converterParaListaDTO(clientes);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ClienteDto buscarPorId(@PathVariable("id") Long id){
		Cliente cliente = service.buscarPorId(id);
		return ClienteConverter.converterParaDTO(cliente);
	}
	
	@Transactional
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void alterarCliente(@PathVariable Long id, @RequestBody ClienteDto dto) {
		service.alterarCliente(id, dto);
	}
	
	@Transactional
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void deletarCliente(@PathVariable Long id) {
		service.deletarCliente(id);
	}
	
}
