package br.com.proposta.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proposta.api.entities.Veiculo;
import br.com.proposta.api.repositories.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}
