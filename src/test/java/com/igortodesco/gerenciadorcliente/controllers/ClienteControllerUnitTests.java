package com.igortodesco.gerenciadorcliente.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.igortodesco.gerenciadorcliente.convertes.ClienteConverter;
import com.igortodesco.gerenciadorcliente.dtos.ClienteDto;
import com.igortodesco.gerenciadorcliente.entities.Cliente;
import com.igortodesco.gerenciadorcliente.services.ClienteService;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerUnitTests {
	
	@Spy
	@InjectMocks
	private ClienteController controller;
	
	@Mock
	private ClienteService service;
	
	private static ClienteDto clienteDto;
	private static Cliente cliente;
	
	private static Long id;
	
	@BeforeAll
	public static void beforeAll() {
		cliente = geraCliente(1L, "Shiba Inu", "111.111.111-11");
		id = cliente.getId();
	}
	
	@Test
	public void deve_Salvar_Cliente() {
		when(service.salvarCliente(Mockito.any(Cliente.class))).thenReturn(cliente);
		
		ClienteDto esperado = ClienteConverter.converterParaDTO(cliente);
		ClienteDto atual = controller.salvarCliente(esperado);
		
		assertNotNull(atual);	
		assertEquals(esperado, atual);
	}
	
	@Test
	public void deve_Buscar_Por_Id() {
		when(service.buscarPorId(anyLong())).thenReturn(cliente);
		
		ClienteDto esperado = ClienteConverter.converterParaDTO(cliente);
		ClienteDto atual = controller.buscarPorId(id);
		
		assertNotNull(atual);	
		assertEquals(esperado, atual);
	}
	
	@Test
	public void deve_Buscar_Todos() {
		when(service.buscarTodos()).thenReturn(geraClientes());
		
		List<ClienteDto> listaEsperada = ClienteConverter.converterParaListaDTO(geraClientes());
		List<ClienteDto> listaAtual = controller.buscarTodos();
		
		assertNotNull(listaAtual);
		assertFalse(listaAtual.isEmpty());
		assertEquals(listaEsperada.size(), listaAtual.size());
	}
	
	@Test
	public void deve_Alterar_Cliente() {
		doNothing().when(service).alterarCliente(anyLong(), Mockito.any(ClienteDto.class));
		controller.alterarCliente(id, new ClienteDto());
		
		verify(service, times(1)).alterarCliente(id, new ClienteDto());
	}
	
	@Test
	public void deve_Deletar_Cliente() {
		doNothing().when(service).deletarCliente(anyLong());
		controller.deletarCliente(id);
		
		verify(service, times(1)).deletarCliente(id);
	}
	
	private static Cliente geraCliente(Long id, String nome, String cpf){
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setDataNascimento(LocalDate.of(1996, 07, 19));
		cliente.setEndereco("Rua da casa do Shiba Inu");
		cliente.setCidade("Cidade do Shiba Inu");
		cliente.setPais("Pais do Shiba Inu");
		cliente.setTelefone("(11)99999-9999");
		return cliente;
	}
	
	private List<Cliente> geraClientes(){
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(geraCliente(1L, "Shiba Inu", "111.111.111-11"));
		clientes.add(geraCliente(2L, "Shiba Inu Mãe", "222.222.222-22"));
		clientes.add(geraCliente(3L, "Shiba Inu Pai", "333.333.333-33"));
		clientes.add(geraCliente(4L, "Shiba Inu Irmão", "444.444.444-44"));
		return clientes;
	}

	
}
