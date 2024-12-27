package br.com.fiap.locatech.controllers;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/veiculos")
@Tag(name = "Veículo | ", description = "Controller para CRUD de veículos")
public class VeiculoController {

	private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

	@Autowired
	private VeiculoService service;

	@Operation(description = "Busca todos os veículos paginados",
			summary = "Busca de veículos",
			responses = {
					@ApiResponse(description = "OK", responseCode = "200")
			})
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAllVeiculos(@RequestParam("size") int size,
			@RequestParam("page") int page) {
		logger.info("Iniciando request | findAllVeiculos page: " + page + "Size: " + size);
		var veiculos = service.findAllVeiculos(size, page);
		logger.info("Iniciando request | findAllVeiculos page: " + page + "Size: " + size);
		return ResponseEntity.ok(veiculos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Veiculo>> findVeiculoById(@PathVariable("id") Long id) {
		logger.info("Iniciando request | findVeiculoById id: {id}", id);
		var veiculo = service.findVeiculoById(id);
		logger.info("Finalizando request | findVeiculoById id: %d", id);
		return ResponseEntity.ok(veiculo);
	}

	@PostMapping
	public ResponseEntity<Void> saveVeiculo(@RequestBody Veiculo veiculo) {
		logger.info("Iniciando request | save veiculo: " + veiculo.getModelo());
		service.saveVeiculo(veiculo);
		logger.info("Finalizando request | save veiculo: " + veiculo.getModelo());
		return status(OK).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateVeiculo(@RequestBody Veiculo veiculo, @PathVariable("id") Long id) {
		logger.info("Iniciando request | update veiculo: " + veiculo.getModelo());
		service.updateVeiculo(veiculo, id);
		logger.info("Finalizando request | update veiculo: " + veiculo.getModelo());
		return status(NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVeiculo(@PathVariable("id") Long id) {
		logger.info("Iniciando request | delete veiculo id: " + id);
		service.deleteVeiculo(id);
		logger.info("Finalizando request | delete veiculo id:" + id);
		return ok().build();
	}
}
