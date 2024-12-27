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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.services.AluguelService;

@Controller
@RequestMapping("/alugueis")
public class AluguelController {

	private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

	@Autowired
	private AluguelService service;

	@GetMapping
	public ResponseEntity<List<Aluguel>> findAllAlugueis(@RequestParam("size") int size,
			@RequestParam("page") int page) {
		logger.info("Iniciando request | findAllAlugueis page: " + page + "Size: " + size);
		var alugueis = service.findAllAlugueis(size, page);
		logger.info("Iniciando request | findAllAlugueis page: " + page + "Size: " + size);
		return ResponseEntity.ok(alugueis);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Aluguel>> findAluguelById(@PathVariable("id") Long id) {
		logger.info("Iniciando request | findAluguelById id: {id}", id);
		var aluguel = service.findAluguelById(id);
		logger.info("Finalizando request | findAluguelById id: %d", id);
		return ResponseEntity.ok(aluguel);
	}

	@PostMapping
	public ResponseEntity<Void> saveAluguel(@RequestBody AluguelRequestDTO aluguel) {
		logger.info("Iniciando request | save aluguel: ");
		service.saveAluguel(aluguel);
		logger.info("Finalizando request | save aluguel: ");
		return status(OK).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateAluguel(@RequestBody Aluguel aluguel, @PathVariable("id") Long id) {
		logger.info("Iniciando request | update Aluguel: " + aluguel.getId());
		service.updateAluguel(aluguel, id);
		logger.info("Finalizando request | update Aluguel: " + aluguel.getId());
		return status(NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAluguel(@PathVariable("id") Long id) {
		logger.info("Iniciando request | delete Aluguel id: " + id);
		service.deleteAluguel(id);
		logger.info("Finalizando request | delete Aluguel id:" + id);
		return ok().build();
	}
}
