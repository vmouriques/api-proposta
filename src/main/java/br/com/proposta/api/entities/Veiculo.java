package br.com.proposta.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Veiculo implements Serializable {

    private String modelo;
    private Integer ano;
    private BigDecimal valor;

    public Veiculo() {
        
    }
}
