package br.com.fiap.locatech.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@GetMapping
	public String getVeiculos() {
		return "<a>clique aqui</a src=\"google.com\"> ";
	}
}