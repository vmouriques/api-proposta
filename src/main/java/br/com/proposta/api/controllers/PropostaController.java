package br.com.proposta.api.controllers;

import br.com.proposta.api.dto.PropostaEntradaDTO;
import br.com.proposta.api.entities.Cliente;
import br.com.proposta.api.entities.Pagamento;
import br.com.proposta.api.entities.Proposta;
import br.com.proposta.api.entities.Veiculo;
import br.com.proposta.api.services.ClienteService;
import br.com.proposta.api.services.PagamentoService;
import br.com.proposta.api.services.PropostaService;
import br.com.proposta.api.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("financiamento/v1/propostas")
public class PropostaController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PropostaService propostaService;

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public void receberProposta(@RequestBody PropostaEntradaDTO propostaDto) {

        // cliente
        Cliente cliente = new Cliente();
        cliente.setNome(propostaDto.getNome());
        cliente.setCpf(propostaDto.getCpf());
        cliente.setEmail(propostaDto.getEmail());
        cliente.setTelefone(propostaDto.getTelefone());
        clienteService.save(cliente);

        // veiculo
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(propostaDto.getModelo());
        veiculo.setAno(propostaDto.getAno());
        veiculo.setValor(propostaDto.getValor());
        veiculoService.save(veiculo);

        Pagamento pagamento = new Pagamento();
        pagamento.setValorFinanciado(propostaDto.getValor());
        pagamentoService.save(pagamento);

        Proposta proposta = new Proposta();
        proposta.setVeiculo(veiculo);
        proposta.setCliente(cliente);
        proposta.setPagamento(pagamento);

        propostaService.save(proposta);
    }

    @GetMapping("/{id_proposta}")
    public void recuperarProposta() {
    }
}
