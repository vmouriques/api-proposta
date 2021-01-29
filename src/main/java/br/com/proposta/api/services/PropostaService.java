package br.com.proposta.api.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proposta.api.entities.Proposta;
import br.com.proposta.api.entities.Solicitacao;
import br.com.proposta.api.entities.enums.TipoPagamento;
import br.com.proposta.api.repositories.PropostaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PropostaService {

	private static BigDecimal JUROS_POR_PARCELA = BigDecimal.valueOf(1.2);
	private static Integer QUANTIDADE_PARCELAS = 36;

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

	public Proposta gerarProposta(Solicitacao solicitacao) {
		BigDecimal valorVeiculo = solicitacao.getVeiculo().getValor();
		BigDecimal valorParcela = calculaValorDaParcela(valorVeiculo, QUANTIDADE_PARCELAS, JUROS_POR_PARCELA);
		BigDecimal valorTotal = calculaValorTotalDaProposta(QUANTIDADE_PARCELAS, valorParcela);
		
		Proposta proposta = new Proposta(TipoPagamento.BOLETO, valorTotal, valorVeiculo, QUANTIDADE_PARCELAS,
				valorParcela, JUROS_POR_PARCELA);

		solicitacao.getPropostas().add(proposta);
		repository.save(proposta);
		return proposta;
	}

	public BigDecimal calculaValorDaParcela(BigDecimal valorVeiculo, Integer qtdeParcelas, BigDecimal jurosParcela) {
		BigDecimal valorParcela = valorVeiculo.divide(BigDecimal.valueOf(qtdeParcelas), RoundingMode.HALF_UP);
		BigDecimal multiply = valorParcela.multiply(jurosParcela);
		log.info("valor do veiculo {} quantidade parcelas {}", valorVeiculo, qtdeParcelas);
		log.info("valor da parcela com juros incluído {}, taxa de juros {}", multiply, JUROS_POR_PARCELA);
		return multiply;
	}

	public BigDecimal calculaValorTotalDaProposta(Integer quantidadeParcelas, BigDecimal valorParcela) {
		BigDecimal valorTotalProposta = valorParcela.multiply(BigDecimal.valueOf(quantidadeParcelas));
		log.info("valor total do financiamento {}", valorTotalProposta);
		return valorTotalProposta;
	}

}
