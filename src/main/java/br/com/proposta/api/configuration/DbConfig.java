package br.com.proposta.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.proposta.api.repositories.VeiculoRepository;

@Configuration
public class DbConfig implements CommandLineRunner {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        //Solicitacao cli1 = new Solicitacao(null, "Vinicius Matos", "581.477.630-77", "vinicius@gmail.com", "(65) 65404-8485");
        //Veiculo vei1 = new Veiculo(null, "Rolls-Royce Ghost ll 6.6 V12 Aut.", 2019, new BigDecimal("50000"));
        //Solicitacao cli2 = new Solicitacao(null, "Rafael Claumann", "032.092.280-43", "rafael@gmail.com", "(68) 76807-0164");
        //Veiculo vei2 = new Veiculo(null, "VW Fusca", 1961, new BigDecimal("45000"));
        //clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        //veiculoRepository.saveAll(Arrays.asList(vei1, vei2));

    }

}
