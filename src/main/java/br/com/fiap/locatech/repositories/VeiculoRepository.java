package br.com.fiap.locatech.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.locatech.entities.Veiculo;

public interface VeiculoRepository {

	Optional<Veiculo> findById(Long id);
	
	List<Veiculo> findAll(int size, int offSet);

	Integer save(Veiculo veiculo);
	
	Integer update(Veiculo veiculo, Long id);
	
	Integer delete(Long id);
}
