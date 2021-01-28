package br.com.proposta.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotBlank(message = "Nome é obrigatório")
	@JsonProperty("nome_cliente")
	private String nome;
	
	@NotBlank(message = "Email é obrigatório")
	@JsonProperty("email_cliente")
	private String email;
	
	@NotBlank(message = "CPF é obrigatório")
	@JsonProperty("cpf_cliente")
	private String cpf;
	
	@NotBlank(message = "Modelo do veículo é obrigatório")
	@JsonProperty("modelo_veiculo")
	private String modelo;
	
	@NotNull(message = "Ano do veículo é obrigatório")
	@JsonProperty("ano_veiculo")
	private Integer ano;
	
	@NotNull(message = "Valor do veículo é obrigatório")
	@JsonProperty("valor_veiculo")
	private BigDecimal valor;
	
}
