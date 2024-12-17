package br.com.fiap.locatech.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.locatech.entities.Pessoa;

public interface PessoaRepository {
	
	Optional<Pessoa> findById(Long id);
	
	List<Pessoa> findAll(int size, int offSet);

	Integer save(Pessoa pessoa);
	
	Integer update(Pessoa pessoa, Long id);
	
	Integer delete(Long id);
}
