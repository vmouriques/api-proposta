package br.com.proposta.api.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_VEICULO")
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private Integer ano;
    private BigDecimal valor;

    public Veiculo(String modelo, Integer ano, BigDecimal valor) {
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }
}

