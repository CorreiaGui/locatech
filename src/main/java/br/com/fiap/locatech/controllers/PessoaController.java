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

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

	@Autowired
	private PessoaService service;

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAllPessoas(@RequestParam("size") int size,
			@RequestParam("page") int page) {
		logger.info("Iniciando request | findAllPessoas page: " + page + "Size: " + size);
		var pessoas = service.findAllPessoas(size, page);
		logger.info("Iniciando request | findAllPessoas page: " + page + "Size: " + size);
		return ResponseEntity.ok(pessoas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> findPessoasById(@PathVariable("id") Long id) {
		logger.info("Iniciando request | findPessoasById id: {id}", id);
		var pessoa = service.findPessoaById(id);
		logger.info("Finalizando request | findPessoasById id: %d", id);
		return ResponseEntity.ok(pessoa);
	}

	@PostMapping
	public ResponseEntity<Void> savePessoa(@RequestBody Pessoa pessoa) {
		logger.info("Iniciando request | save Pessoa: " + pessoa.getCpf());
		service.savePessoa(pessoa);
		logger.info("Finalizando request | save Pessoa: " + pessoa.getCpf());
		return status(OK).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updatePessoa(@RequestBody Pessoa pessoa, @PathVariable("id") Long id) {
		logger.info("Iniciando request | update pessoa: " + pessoa.getCpf());
		service.updatePessoa(pessoa, id);
		logger.info("Finalizando request | update pessoa: " + pessoa.getCpf());
		return status(NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable("id") Long id) {
		logger.info("Iniciando request | delete pessoa id: " + id);
		service.deletePessoa(id);
		logger.info("Finalizando request | delete pessoa id:" + id);
		return ok().build();
	}
}
