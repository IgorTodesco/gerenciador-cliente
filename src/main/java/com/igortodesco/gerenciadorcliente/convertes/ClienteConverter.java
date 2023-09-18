package com.igortodesco.gerenciadorcliente.convertes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igortodesco.gerenciadorcliente.dtos.ClienteDto;
import com.igortodesco.gerenciadorcliente.entities.Cliente;

public class ClienteConverter {
	
	public static ClienteDto converterParaDTO(Cliente cliente) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            String json = mapper.writeValueAsString(cliente);
            return mapper.readValue(json, ClienteDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static Cliente converterParaEntidade (ClienteDto clienteDto) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            String json = mapper.writeValueAsString(clienteDto);
            return mapper.readValue(json, Cliente.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static List<Cliente> converterParaListaEntidade (List<ClienteDto> listClienteDto) {
        List<Cliente> clientes = new ArrayList<>();
        for (ClienteDto dto : listClienteDto) {
			clientes.add(converterParaEntidade(dto));
		}
        return clientes;
    }
	
	public static List<ClienteDto> converterParaListaDTO (List<Cliente> listCliente) {
        List<ClienteDto> clientesDto = new ArrayList<>();
        for (Cliente entidade : listCliente) {
			clientesDto.add(converterParaDTO(entidade));
		}
        return clientesDto;
    }
	
}
