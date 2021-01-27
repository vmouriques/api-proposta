package br.com.proposta.api.entities;

import br.com.proposta.api.entities.enums.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "dataProposta"})
@Entity
@Table(name = "TB_PROPOSTA")
public class Proposta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoPagamento tipoPagamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private LocalDateTime dataProposta;

    private BigDecimal valorTotal;

    private BigDecimal valorVeiculo;

    private Integer quantidadeParcelas;

    private BigDecimal valorDaParcela;

}
