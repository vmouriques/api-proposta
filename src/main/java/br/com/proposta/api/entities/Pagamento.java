package br.com.proposta.api.entities;

import br.com.proposta.api.entities.enums.TipoPagamento;
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
@Table(name = "TB_PAGAMENTO")
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorEntrada;
    private BigDecimal valorFinanciado;
    private BigDecimal valorTotal;
    private Integer quantidadeParcelas;
    private BigDecimal valorParcela;
    private BigDecimal juros;
    private TipoPagamento tipoPagamento;

}

