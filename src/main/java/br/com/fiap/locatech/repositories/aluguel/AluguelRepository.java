package br.com.fiap.locatech.repositories.aluguel;

import java.util.List;
import java.util.Optional;

import br.com.fiap.locatech.entities.Aluguel;

public interface AluguelRepository {

	Optional<Aluguel> findById(Long id);
	
	List<Aluguel> findAll(int size, int offSet);

	Integer save(Aluguel aluguel);
	
	Integer update(Aluguel aluguel, Long id);
	
	Integer delete(Long id);
}
