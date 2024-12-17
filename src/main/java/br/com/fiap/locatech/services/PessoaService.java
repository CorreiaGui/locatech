package br.com.fiap.locatech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.repositories.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository repository;
	
	public PessoaService(PessoaRepository repo) {
		this.repository = repo;
	}
	
	public List<Pessoa> findAllPessoas(int size, int page) {
		int offset = (page - 1) * size;
		return this.repository.findAll(size, offset);
	}

	public Optional<Pessoa> findPessoaById(Long id) {
		return this.repository.findById(id);
	}

	public void savePessoa(Pessoa pessoa) {
		var save = this.repository.save(pessoa);
		Assert.state(save == 1, "Erro ao salvar a pessoa" + pessoa.getCpf());
	}

	public void updatePessoa(Pessoa pessoa, Long id) {
		var update = this.repository.update(pessoa, id);
		if (update == 0) {
			throw new RuntimeException("Pessoa não encontrada.");
		}
	}

	public void deletePessoa(Long id) {
		var delete = this.repository.delete(id);
		if (delete == 0) {
			throw new RuntimeException("Pessoa não encontrada.");
		}
	}
}
