package br.com.proposta.api.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proposta.api.entities.Proposta;
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
	
	
}
