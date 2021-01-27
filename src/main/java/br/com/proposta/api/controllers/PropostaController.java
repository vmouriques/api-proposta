package br.com.proposta.api.controllers;

import br.com.proposta.api.dto.SolicitacaoDto;
import br.com.proposta.api.services.PropostaService;
import br.com.proposta.api.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("financiamento/v1/solicitacoes")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public String registraSolicitacao(@RequestBody SolicitacaoDto propostaDto) {
        return "not implemented yet";
    }

    @GetMapping("/{id_proposta}/proposta")
    public String gerarProposta(@PathVariable(name = "id_proposta") Long idProposta) {
        return "not implemented yet";
    }
}
