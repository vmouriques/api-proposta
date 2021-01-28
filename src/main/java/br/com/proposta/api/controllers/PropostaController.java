package br.com.proposta.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proposta.api.entities.Proposta;
import br.com.proposta.api.services.PropostaService;

@RestController
@RequestMapping("financiamento/v1/propostas")
public class PropostaController {
	
	@Autowired
	private PropostaService propostaService;
	
	@GetMapping
	public ResponseEntity<List<Proposta>> findAll() {
		List<Proposta> list = propostaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id_proposta}")
	public ResponseEntity<Proposta> findById(@PathVariable("id_proposta") Long id) {
		Proposta proposta = propostaService.findById(id);
		return ResponseEntity.ok().body(proposta);
	}
}
