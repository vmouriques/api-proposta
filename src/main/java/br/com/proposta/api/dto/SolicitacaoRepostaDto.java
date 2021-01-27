package br.com.proposta.api.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.proposta.api.entities.Proposta;
import br.com.proposta.api.entities.Solicitacao;

public class SolicitacaoRepostaDto {

	@JsonProperty("nome_cliente")
	private String nome;

    @JsonProperty("email_cliente")
    private String email;
    
    @JsonProperty("modelo_veiculo")
    private String modelo;

    @JsonProperty("ano_veiculo")
    private Integer ano;

    @JsonProperty("valor_veiculo")
    private BigDecimal valor;
    
    @JsonProperty("propostas")
    private List<Proposta> propostas;
    
    
    public SolicitacaoRepostaDto(Solicitacao solicitacao) {
    	this.nome = solicitacao.getNomeCliente();
    	this.email = solicitacao.getEmailCliente();
    	this.modelo = solicitacao.getVeiculo().getModelo();
    	this.ano = solicitacao.getVeiculo().getAno();
    	this.valor = solicitacao.getVeiculo().getValor();
    	this.propostas = solicitacao.getPropostas();
    }
    
}
