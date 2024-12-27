package br.com.fiap.locatech.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Aluguel {
	
	@Schema(description = "Id da pessoa que aluga o veículo")
	private Long id;
	
	private Long pessoaId;
	
	private Long veiculoId;

	private String veiculoModelo;

	private String pessoaCpf;
	
	private String pessoaNome;
	
	private LocalDate dataInicio;
	
	private LocalDate dataFim;

	private BigDecimal valorTotal;
	
	public Aluguel(AluguelRequestDTO dto, BigDecimal valor) {
		setPessoaId(dto.pessoaId());
		setVeiculoId(dto.veiculoId());
		setDataInicio(dto.dataInicio());
		setDataFim(dto.dataFim());
		setValorTotal(valor);
	}
}
