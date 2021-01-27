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
public class SolicitacaoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("nome_cliente")
	private String nome;

	@JsonProperty("email_cliente")
	private String email;

	@JsonProperty("cpf_cliente")
	private String cpf;

	@JsonProperty("modelo_veiculo")
	private String modelo;

	@JsonProperty("ano_veiculo")
	private Integer ano;

	@JsonProperty("valor_veiculo")
	private BigDecimal valor;

}
