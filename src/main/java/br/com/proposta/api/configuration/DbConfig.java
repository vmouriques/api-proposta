package br.com.proposta.api.configuration;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.proposta.api.entities.Solicitacao;
import br.com.proposta.api.entities.Veiculo;
import br.com.proposta.api.repositories.SolicitacaoRepository;
import br.com.proposta.api.repositories.VeiculoRepository;

@Configuration
public class DbConfig implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Veiculo veiculo1 = new Veiculo(null, "Rolls-Royce Ghost ll 6.6 V12 Aut.", 2019, new BigDecimal("50000"));
		Veiculo veiculo2 = new Veiculo(null, "VW Fusca", 1961, new BigDecimal("45000"));

		veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2));

		Solicitacao solicitacao1 = new Solicitacao(null, "Vinicius Matos", "581.477.630-77", "vinicius@gmail.com", veiculo1, null);
		Solicitacao solicitacao2 = new Solicitacao(null, "Rafael Claumann", "032.092.280-43", "rafael@gmail.com", veiculo2, null);

		solicitacaoRepository.saveAll(Arrays.asList(solicitacao1, solicitacao2));

	}

}