package br.com.proposta.api.services;

import br.com.proposta.api.entities.Pagamento;
import br.com.proposta.api.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public Pagamento save(Pagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}

}
