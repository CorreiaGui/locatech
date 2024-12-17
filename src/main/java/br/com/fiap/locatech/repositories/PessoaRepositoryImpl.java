package br.com.fiap.locatech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.fiap.locatech.entities.Pessoa;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {
	
	private JdbcClient jdbcClient;
	
	public PessoaRepositoryImpl(JdbcClient jdbc) {
		this.jdbcClient = jdbc;
	}

	@Override
	public Optional<Pessoa> findById(Long id) {
		return jdbcClient.sql("SELECT * FROM pessoas WHERE id = :id")
				.param("id", id)
				.query(Pessoa.class)
				.optional();
	}

	@Override
	public List<Pessoa> findAll(int size, int offSet) {
		return this.jdbcClient
				.sql("SELECT * FROM pessoas LIMIT :size OFFSET :offSet")
				.param("size", size)
				.param("offSet", offSet)
				.query(Pessoa.class)
				.list();
	}

	@Override
	public Integer save(Pessoa pessoa) {
		return this.jdbcClient.sql("INSERT INTO pessoas "
				+ "(nome, cpf, telefone, email) VALUES"
				+ "(:nome, :cpf, :telefone, :email)")
				.param("nome", pessoa.getNome())
				.param("cpf", pessoa.getCpf())
				.param("telefone", pessoa.getTelefone())
				.param("email", pessoa.getEmail())
				.update();
	}

	@Override
	public Integer update(Pessoa pessoa, Long id) {
		return this.jdbcClient.sql("UPDATE pessoas SET nome= :nome, cpf= :cpf, telefone= :telefone, email= :email")
				.param("nome", pessoa.getNome())
				.param("cpf", pessoa.getCpf())
				.param("telefone", pessoa.getTelefone())
				.param("email", pessoa.getEmail())
				.update();
	}

	@Override
	public Integer delete(Long id) {
		return this.jdbcClient.sql("DELETE FROM pessoas WHERE id= :id")
				.param("id", id)
				.update();
	}

}
