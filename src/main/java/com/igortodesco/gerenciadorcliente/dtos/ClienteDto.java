package com.igortodesco.gerenciadorcliente.dtos;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import com.igortodesco.gerenciadorcliente.utils.FormatadorCPF;
import com.igortodesco.gerenciadorcliente.utils.FormatadorTelefone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDto {
	
    private static final String REGEX_NOME = "([A-Z]{1}[a-z]+\\s?)+";
    
    private Long id;

	@NotBlank(message = "O nome não pode estar nulo ou em branco!")
	@Size(max = 150, message = "O campo nome não pode ter mais de 150 caracteres")
	@Pattern(regexp = REGEX_NOME, message = "O campo nome aceita somente letras")
	private String nome;
	
	@NotBlank(message = "O CPF não pode estar nulo ou em branco!")
	@CPF
	private String cpf;
	
	@NotBlank(message = "O Email não pode estar nulo ou em branco!")
	private String email;
	
	@NotBlank(message = "A cidade não pode estar nulo ou em branco!")
	@Size(max = 100, message = "O campo cidade não pode ter mais de 100 caracteres")
	@Pattern(regexp = REGEX_NOME, message = "O campo cidade aceita somente letras")
	private String cidade;
	
	@NotBlank(message = "O pais não pode estar nulo ou em branco!")
	@Size(max = 100, message = "O campo pais não pode ter mais de 100 caracteres")
	@Pattern(regexp = REGEX_NOME, message = "O campo pais aceita somente letras")
	private String pais;
	
	@NotBlank(message = "O endereço não pode estar nulo ou em branco!")
	@Size(max = 150, message = "O campo endereço não pode ter mais de 150 caracteres")
	private String endereco; 
	
	@NotBlank(message = "O telefone não pode estar nulo ou em branco!")
	private String telefone;
	
	private LocalDate dataNascimento;
	
	public ClienteDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = FormatadorCPF.formatarCPF(cpf);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = FormatadorTelefone.formatarTelefone(telefone);
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDto other = (ClienteDto) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ClienteDto [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", cidade=" + cidade
				+ ", pais=" + pais + ", endereco=" + endereco + ", telefone=" + telefone + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
	
	
}
