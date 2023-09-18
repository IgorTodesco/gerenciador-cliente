package com.igortodesco.gerenciadorcliente.exceptions;

import java.io.Serializable;

public class MensagemErro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private Integer status;
	private String mensagem;
	
	public MensagemErro() {
		super();
	}

	public MensagemErro(Long timestamp, Integer status, String mensagem) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.mensagem = mensagem;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
