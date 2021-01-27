package br.com.proposta.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class PropostaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("nome_cliente")
    private String nome;

    @JsonProperty("valor_total")
    private BigDecimal valorTotal;

    @JsonProperty("valor_veiculo")
    private BigDecimal valorVeiculo;

    @JsonProperty("quantidade_de_parcelas")
    private Integer quantidadeParcelas;

    @JsonProperty("valor_por_parcela")
    private BigDecimal valorParcela;

    @JsonProperty("juros_por_parcela")
    private BigDecimal jurosParcela;

}
