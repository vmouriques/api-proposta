package br.com.proposta.api.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proposta.api.dto.PropostaDto;
import br.com.proposta.api.entities.Proposta;
import br.com.proposta.api.entities.Solicitacao;
import br.com.proposta.api.repositories.PropostaRepository;

@Service
public class PropostaService {

	@Autowired
	private PropostaRepository repository;

	public List<Proposta> findAll() {
		return repository.findAll();
	}

	public Proposta findById(Long id) {
		Optional<Proposta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Proposta não encontrada", null));
	}

	public Proposta save(Proposta proposta) {
		return repository.save(proposta);
	}
	
	public PropostaDto gerarProposta(Solicitacao solicitacao) {
		PropostaDto propostaDto = new PropostaDto();
		propostaDto.setNome(solicitacao.getNomeCliente());
		propostaDto.setQuantidadeParcelas(36);
		propostaDto.setValorParcela(new BigDecimal(500));
		propostaDto.setValorVeiculo(solicitacao.getVeiculo().getValor());
		propostaDto.setValorTotal(new BigDecimal(10000));
		propostaDto.setJurosParcela(new BigDecimal(1.2));
	
		Proposta proposta = propostaDto.fromDto(propostaDto);
		solicitacao.getPropostas().add(proposta);
		
		repository.save(proposta);
		return propostaDto;
	}

}
