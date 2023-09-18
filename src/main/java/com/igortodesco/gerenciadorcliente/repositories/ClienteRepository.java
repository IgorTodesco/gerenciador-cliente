package com.igortodesco.gerenciadorcliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.igortodesco.gerenciadorcliente.dtos.ClienteDto;
import com.igortodesco.gerenciadorcliente.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Modifying
	@Query(value = "UPDATE Cliente c SET c.nome = :#{#cli.nome}, "
			+ "c.email = :#{#cli.nome}, "
			+ "c.cpf = :#{#cli.cpf}, "
			+ "c.cidade = :#{#cli.cidade}, "
			+ "c.pais = :#{#cli.pais}, "
			+ "c.endereco = :#{#cli.endereco}, "
			+ "c.telefone = :#{#cli.telefone}, "
			+ "c.dataNascimento = :#{#cli.dataNascimento} "
			+ " WHERE c.id = :id")
	void alterar(@Param("id") Long id, @Param("cli") ClienteDto dto);
}
