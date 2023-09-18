package com.igortodesco.gerenciadorcliente.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Cliente.TABLE)
public class Cliente {
	
	protected static final String TABLE = "CLIENTE";
	
	private static final String COLUMN_ID = "CLI_SQ_ID";
	private static final String COLUMN_NOME = "CLI_DS_NOME";
	private static final String COLUMN_EMAIL = "CLI_DS_EMAIL";
	private static final String COLUMN_CPF = "CLI_NR_CPF";
	private static final String COLUMN_CIDADE = "CLI_DS_CIDADE";
	private static final String COLUMN_PAIS = "CLI_DS_PAIS";
	private static final String COLUMN_ENDERECO = "CLI_DS_ENDERECO";
	private static final String COLUMN_TELEFONE = "CLI_NR_TELEFONE";
	private static final String COLUMN_DATA_NASC = "CLI_DT_NASCIMENTO";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long id;
	
	@Column(name = COLUMN_NOME, nullable = false, length = 150)
	private String nome;
	
	@Column(name = COLUMN_CPF, nullable = false)
	private String cpf;
	
	@Column(name = COLUMN_CIDADE, nullable = false)
	private String cidade;
	
	@Column(name = COLUMN_PAIS, nullable = false)
	private String email;
	
	@Column(name = COLUMN_EMAIL, nullable = false)
	private String pais;
	
	@Column(name = COLUMN_ENDERECO, nullable = false)
	private String endereco; 
	
	@Column(name = COLUMN_TELEFONE, nullable = false)
	private String telefone;
	
	@Column(name = COLUMN_DATA_NASC, nullable = false)
	private LocalDate dataNascimento;
	

	public Cliente() {
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
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		this.telefone = telefone;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cidade=" + cidade + ", email=" + email
				+ ", pais=" + pais + ", endereco=" + endereco + ", telefone=" + telefone + ", dataNascimento="
				+ dataNascimento + "]";
	}

	
	
}
