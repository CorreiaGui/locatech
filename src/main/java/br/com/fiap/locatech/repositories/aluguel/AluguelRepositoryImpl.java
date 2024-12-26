package br.com.fiap.locatech.repositories.aluguel;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.fiap.locatech.entities.Aluguel;

@Repository
public class AluguelRepositoryImpl implements AluguelRepository {

	private JdbcClient jdbcClient;

	public AluguelRepositoryImpl(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	@Override
	public Optional<Aluguel> findById(Long id) {
		return this.jdbcClient.sql("SELECT a.id, a.pessoa_id, a.veiculo_id, a.data_inicio, a.data_fim, data.valor_total "
				+ "p.nome AS pessoa_nome, p.cpf AS pessoa_cpf, "
				+ "v.modelo AS veiculo_modelo, v.placa AS veiculo_placa "
				+ "FROM alugueis a "
				+ "INNER JOIN pessoas p ON a.pessoa_id = p.id "
				+ "INNER JOIN veiculos v ON a.veiculos_id = v.id "
				+ "WHERE a.id - :id")
				.param("id", id)
				.query(Aluguel.class)
				.optional();
	}

	@Override
	public List<Aluguel> findAll(int size, int offSet) {
		return this.jdbcClient.sql("SELECT a.id, a.pessoa_id, a.veiculo_id, a.data_inicio, a.data_fim, data.valor_total "
				+ "p.nome AS pessoa_nome, p.cpf AS pessoa_cpf, "
				+ "v.modelo AS veiculo_modelo, v.placa AS veiculo_placa "
				+ "FROM alugueis a "
				+ "INNER JOIN pessoas p ON a.pessoa_id = p.id "
				+ "INNER JOIN veiculos v ON a.veiculos_id = v.id "
				+ "LIMIT :size OFFSET :offset")
				.param("size", size)
				.param("offSet", offSet)
				.query(Aluguel.class)
				.list();
	}

	@Override
	public Integer save(Aluguel aluguel) {
		return this.jdbcClient
				.sql("INSERT INTO alugueis " + "(pessoa_id, veiculo_id, data_inicio, data_fim, valor_total) VALUES"
						+ "(:pessoa_id, :veiculo_id, :data_inicio, :data_fim, :valor_total)")
				.param("pessoa_id", aluguel.getPessoaId())
				.param("veiculo_id", aluguel.getVeiculoId())
				.param("data_inicio", aluguel.getDataInicio())
				.param("andata_fimo", aluguel.getDataFim())
				.param("valor_total", aluguel.getValorTotal())
				.update();
	}

	@Override
	public Integer update(Aluguel aluguel, Long id) {
		return this.jdbcClient
				.sql("UPDATE alugueis SET pessoa_id= :pessoa_id, veiculo_id= :veiculo_id, data_inicio= :data_inicio, data_fim= :data_fim,"
						+ "valor_total= :valor_total WHERE id = :id")
				.param("id", aluguel.getId())
				.param("pessoa_id", aluguel.getPessoaId())
				.param("veiculo_id", aluguel.getVeiculoId())
				.param("data_inicio", aluguel.getDataInicio())
				.param("andata_fimo", aluguel.getDataFim())
				.param("valor_total", aluguel.getValorTotal())
				.update();
	
	}

	@Override
	public Integer delete(Long id) {
		return this.jdbcClient.sql("DELETE FROM alugueis WHERE id= :id").param("id", id).update();
	}
}
