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

		Veiculo veiculo1 = new Veiculo("Rolls-Royce Ghost ll 6.6 V12 Aut.", 2019, new BigDecimal(2600000));
		Veiculo veiculo2 = new Veiculo("VW Fusca", 1961, new BigDecimal(8000));

		veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2));

		Solicitacao solicitacao1 = new Solicitacao("Vinicius Matos", "vinicius@gmail.com", "581.477.630-77", veiculo1, null);
		Solicitacao solicitacao2 = new Solicitacao("Rafael Claumann", "rafael@gmail.com", "032.092.280-43", veiculo2, null);

		solicitacaoRepository.saveAll(Arrays.asList(solicitacao1, solicitacao2));

	}

}