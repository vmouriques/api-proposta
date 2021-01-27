package br.com.proposta.api.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

}
