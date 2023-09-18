package com.igortodesco.gerenciadorcliente.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.igortodesco.gerenciadorcliente.exceptions.cliente.ClienteNaoEncontradoException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ClienteExceptionHandler {

	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<MensagemErro> clienteNaoEncontrado(ClienteNaoEncontradoException e, ServletRequest request) {
		MensagemErro erro = new MensagemErro(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
