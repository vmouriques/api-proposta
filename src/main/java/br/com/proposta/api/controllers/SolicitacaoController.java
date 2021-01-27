package br.com.proposta.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proposta.api.dto.PropostaDto;
import br.com.proposta.api.dto.SolicitacaoDto;
import br.com.proposta.api.dto.SolicitacaoRepostaDto;
import br.com.proposta.api.entities.Solicitacao;
import br.com.proposta.api.entities.Veiculo;
import br.com.proposta.api.services.PropostaService;
import br.com.proposta.api.services.SolicitacaoService;
import br.com.proposta.api.services.VeiculoService;

@RestController
@RequestMapping("financiamento/v1/solicitacoes")
public class SolicitacaoController {

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@Autowired
	private PropostaService propostaService;

	@PostMapping
	public ResponseEntity<SolicitacaoRepostaDto> registraSolicitacao(@RequestBody SolicitacaoDto solicitacaoDto) {
		Veiculo veiculo = new Veiculo(solicitacaoDto.getModelo(), solicitacaoDto.getAno(), solicitacaoDto.getValor());
		Solicitacao solicitacao = new Solicitacao(solicitacaoDto.getNome(), solicitacaoDto.getEmail(),
				solicitacaoDto.getCpf(), veiculo, null);

		veiculoService.save(veiculo);
		solicitacaoService.save(solicitacao);
		return ResponseEntity.ok().body(new SolicitacaoRepostaDto(solicitacao));
	}

	@GetMapping("/{id_solicitacao}")
	public ResponseEntity<SolicitacaoRepostaDto> buscarSolicitacao(@PathVariable("id_solicitacao") Long idSolicitacao) {
		Solicitacao solicitacao = solicitacaoService.findById(idSolicitacao);
		return ResponseEntity.ok().body(new SolicitacaoRepostaDto(solicitacao));
	}

	@GetMapping("/{id_solicitacao}/proposta")
	public ResponseEntity<PropostaDto> gerarProposta(@PathVariable("id_solicitacao") Long idSolicitacao) {
		Solicitacao solicitacao = solicitacaoService.findById(idSolicitacao);
		PropostaDto propostaDto = propostaService.gerarProposta(solicitacao);
		return ResponseEntity.ok().body(propostaDto);
	}
}
