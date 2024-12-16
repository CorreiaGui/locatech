package br.com.fiap.locatech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.fiap.locatech.entities.Veiculo;

@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository {

	private JdbcClient jdbcClient;
	
	public VeiculoRepositoryImpl(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	@Override
	public Optional<Veiculo> findById(Long id) {
		return this.jdbcClient
				.sql("SELECT * FROM veiculos WHERE id = :id")
				.param("id", id)
				.query(Veiculo.class)
				.optional();
	}

	@Override
	public List<Veiculo> findAll(int size, int offSet) {
		return this.jdbcClient
				.sql("SELECT * FROM veiculos LIMIT :size OFFSET :offSet")
				.param("size", size)
				.param("offSet", offSet)
				.query(Veiculo.class)
				.list();
	}

	@Override
	public Integer save(Veiculo veiculo) {
		return this.jdbcClient.sql("INSERT INTO veiculos "
				+ "(placa, marca, modelo, ano, cor, valor_diaria) VALUES"
				+ "(:placa, :marca, :modelo, :ano, :cor, :valor_diaria)")
				.param("placa", veiculo.getPlaca())
				.param("marca", veiculo.getMarca())
				.param("modelo", veiculo.getModelo())
				.param("ano", veiculo.getAno())
				.param("cor", veiculo.getCor())
				.param("valor_diaria", veiculo.getValorDiaria())
				.update();
	}

	@Override
	public Integer update(Veiculo veiculo, Long id) {
		return this.jdbcClient.sql("UPDATE veiculos SET marca= :marca, modelo= :modelo, placa= :placa, ano= :ano,"
				+ "cor= :cor, valor_diaria= :valor_diaria")
				.param("id", id)
				.param("marca", veiculo.getMarca())
				.param("modelo", veiculo.getModelo())
				.param("placa", veiculo.getPlaca())
				.param("ano", veiculo.getAno())
				.param("cor", veiculo.getCor())
				.param("valor_diaria", veiculo.getValorDiaria())
				.update();
	}

	@Override
	public Integer delete(Long id) {
		return this.jdbcClient.sql("DELETE FROM veiculos WHERE id= :id")
				.param("id", id)
				.update();
	}

}
