package br.com.proposta.api.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropostaServiceTest {

	private PropostaService propostaService;

	@BeforeEach
	public void setup() {
		propostaService = new PropostaService();
	}

	@Test
	void calcularValorDaParcelaTest() {
		BigDecimal valorVeiculo = BigDecimal.valueOf(8000);
		BigDecimal jurosParcela = BigDecimal.valueOf(1.2);
		Integer qtdeParcelas = 36;

		BigDecimal valorEsperado = valorVeiculo.divide(BigDecimal.valueOf(qtdeParcelas), RoundingMode.HALF_UP)
				.multiply(jurosParcela);
		BigDecimal valorCalculado = propostaService.calculaValorDaParcela(valorVeiculo, qtdeParcelas, jurosParcela);

		assertThat(valorEsperado).isEqualTo(valorCalculado);
	}

	@Test
	void calculaValorTotalDaPropostaTest() {
		Integer qtdeParcelas = 36;
		BigDecimal valorParcela = BigDecimal.valueOf(266.4);

		BigDecimal valorEsperado = BigDecimal.valueOf(266.4).multiply(BigDecimal.valueOf(qtdeParcelas));
		BigDecimal valorCalculado = propostaService.calculaValorTotalDaProposta(qtdeParcelas, valorParcela);

		assertThat(valorEsperado).isEqualTo(valorCalculado);
	}

}
