package br.com.fiap.locatech.dtos;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record AluguelRequestDTO(
		
		@Schema(description = "Id da pessoa que aluga o veículo")
		@NotNull(message = "O id da pessoa não pode ser nulo")
		Long pessoaId,
		
		@NotNull(message = "O id do veículo não pode ser nulo")
		Long veiculoId,
		
		LocalDate dataInicio,
		
		LocalDate dataFim) {

}
