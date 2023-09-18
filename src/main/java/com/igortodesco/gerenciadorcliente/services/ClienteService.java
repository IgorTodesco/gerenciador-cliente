package com.igortodesco.gerenciadorcliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igortodesco.gerenciadorcliente.dtos.ClienteDto;
import com.igortodesco.gerenciadorcliente.entities.Cliente;
import com.igortodesco.gerenciadorcliente.exceptions.cliente.ClienteNaoEncontradoException;
import com.igortodesco.gerenciadorcliente.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente salvarCliente(Cliente cliente) {	
		return repository.save(cliente);
	}
	
	public List<Cliente> buscarTodos() {
		return repository.findAll(); 
	} 
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> optional = repository.findById(id); 
		return optional.orElseThrow(() -> BuscaClienteErro(id));
	}
	
	public void alterarCliente(Long id, ClienteDto dto) throws ClienteNaoEncontradoException {
		if(repository.findById(id).isEmpty()) {
			throw BuscaClienteErro(id);
		}
		repository.alterar(id, dto);
	}
	
	public void deletarCliente(Long id) {
		repository.deleteById(id);
	}
	
	public ClienteNaoEncontradoException BuscaClienteErro(Long id) {
		return new ClienteNaoEncontradoException("Cliente não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName());
	}
}
