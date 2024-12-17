package br.com.fiap.locatech.entities;

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
public class Pessoa {
	
	private Long id;

	private String nome;
	
	private String cpf;
	
	private String telefone;
	
	private String email;
}
