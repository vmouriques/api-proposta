package br.com.proposta.api.entities.enums.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.proposta.api.entities.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
