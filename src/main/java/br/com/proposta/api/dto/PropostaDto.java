package br.com.proposta.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.proposta.api.entities.Proposta;
import br.com.proposta.api.entities.enums.TipoPagamento;
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
    
    public Proposta fromDto(PropostaDto propostaDto) {
    	Proposta proposta = new Proposta();
    	proposta.setTipoPagamento(TipoPagamento.BOLETO);
    	proposta.setDataProposta(LocalDateTime.now());
    	proposta.setValorTotal(this.valorTotal);
    	proposta.setValorVeiculo(this.valorVeiculo);
    	proposta.setValorDaParcela(propostaDto.getValorParcela());
    	proposta.setQuantidadeParcelas(propostaDto.getQuantidadeParcelas());
    	proposta.setJurosParcela(propostaDto.getJurosParcela());
    	return proposta;
    }

}
