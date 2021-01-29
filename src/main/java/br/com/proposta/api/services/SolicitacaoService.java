package br.com.proposta.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proposta.api.controllers.exceptions.SolicitacaoNaoEncontradaException;
import br.com.proposta.api.entities.Solicitacao;
import br.com.proposta.api.repositories.SolicitacaoRepository;

@Service
public class SolicitacaoService {

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;

	public List<Solicitacao> findAll() {
		return solicitacaoRepository.findAll();
	}

	public Solicitacao findById(Long id) {
		Optional<Solicitacao> obj = solicitacaoRepository.findById(id);
		return obj.orElseThrow(() -> new SolicitacaoNaoEncontradaException(id));
	}

	public Solicitacao save(Solicitacao solicitacao) {
		return solicitacaoRepository.save(solicitacao);
	}

}
