package br.com.proposta.api.repositories;

import br.com.proposta.api.entities.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}
