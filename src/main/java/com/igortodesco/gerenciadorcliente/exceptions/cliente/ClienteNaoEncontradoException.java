package com.igortodesco.gerenciadorcliente.exceptions.cliente;

public class ClienteNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	public ClienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
