package br.com.fiap.locatech.services;

import static org.springframework.util.Assert.state;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.repositories.VeiculoRepository;
import br.com.fiap.locatech.repositories.aluguel.AluguelRepository;

@Service
public class AluguelService {
	
	private AluguelRepository repository;
	
	private VeiculoRepository veiculoRepository;

	public AluguelService(AluguelRepository repo, VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
		this.repository = repo;
	}

	public List<Aluguel> findAllAlugueis(int size, int page) {
		int offset = (page - 1) * size;
		return this.repository.findAll(size, offset);
	}

	public Optional<Aluguel> findAluguelById(Long id) {
		return this.repository.findById(id);
	}

	public void saveAluguel(AluguelRequestDTO aluguelDTO) {
		var aluguel = calculaAluguel(aluguelDTO);
		var save = this.repository.save(aluguel);
		state(save == 1, "Erro ao salvar aluguel " + aluguelDTO.pessoaId());
	}

	public void updateAluguel(Aluguel aluguel, Long id) {
		var update = this.repository.update(aluguel, id);
		if (update == 0) {
			throw new RuntimeException("Aluguel não encontrado.");
		}
	}

	public void deleteAluguel(Long id) {
		var delete = this.repository.delete(id);
		if (delete == 0) {
			throw new RuntimeException("Aluguel não encontrado.");
		}
	}
	
	private Aluguel calculaAluguel(AluguelRequestDTO dto) {
		var veiculo = veiculoRepository.findById(dto.veiculoId())
				.orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
		var quantidadeDias = BigDecimal.valueOf(dto.dataFim().getDayOfYear() - dto.dataInicio().getDayOfYear());
		var valor = veiculo.getValorDiaria().multiply(quantidadeDias);
		return new Aluguel(dto, valor);
	}
}
