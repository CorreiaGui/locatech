package br.com.fiap.locatech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	private final VeiculoRepository repository;

	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.repository = veiculoRepository;
	}

	public List<Veiculo> findAllVeiculos(int size, int page) {
		int offset = (page - 1) * size;
		return this.repository.findAll(size, offset);
	}

	public Optional<Veiculo> findVeiculoById(Long id) {
		return this.repository.findById(id);
	}

	public void saveVeiculo(Veiculo veiculo) {
		var save = this.repository.save(veiculo);
		Assert.state(save == 1, "Erro ao salvar o veículo " + veiculo.getMarca());
	}

	public void updateVeiculo(Veiculo veiculo, Long id) {
		var update = this.repository.update(veiculo, id);
		if (update == 0) {
			throw new RuntimeException("Veículo não encontrado.");
		}
	}

	public void deleteVeiculo(Long id) {
		var delete = this.repository.delete(id);
		if (delete == 0) {
			throw new RuntimeException("Veículo não encontrado.");
		}
	}
}
