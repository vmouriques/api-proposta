package br.com.proposta.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "cpfCliente"})
@Entity
@Table(name = "TB_SOLICITACAO")
public class Solicitacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private String emailCliente;
    private String cpfCliente;

    @OneToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @OneToMany
    @JoinColumn(name = "id_solicitacao")
    private List<Proposta> propostas;

    public Solicitacao(String nome, String email, String cpf, Veiculo veiculo, Proposta proposta) {
        this.nomeCliente = nome;
        this.emailCliente = email;
        this.cpfCliente = cpf;
        this.veiculo = veiculo;
        this.propostas = new ArrayList<>(Collections.singletonList(proposta));
    }
}
