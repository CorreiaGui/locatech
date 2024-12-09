package br.com.fiap.locatech.entities;

import java.math.BigDecimal;

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
public class Veiculo {

	private Long id;
	
	private String placa;
	
	private String marca;
	
	private String modelo;
	
	private Integer ano;
	
	private String cor;
	
	private BigDecimal valorDiaria;
}
