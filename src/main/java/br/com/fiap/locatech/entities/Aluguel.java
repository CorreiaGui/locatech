package br.com.fiap.locatech.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

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

	private Long id;
	
	private Long pessoaId;
	
	private Long veiculoId;

	private Long veiculoModel;

	private String pessoaCpf;
	
	private String pessoaNome;
	
	private LocalDate dataInicio;
	
	private LocalDate dataFim;

	private BigDecimal valorTotal;
}
