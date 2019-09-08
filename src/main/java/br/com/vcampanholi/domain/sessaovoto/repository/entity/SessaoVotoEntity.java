package br.com.vcampanholi.domain.sessaovoto.repository.entity;

import br.com.vcampanholi.domain.sessao.repository.entity.SessaoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SessaoVotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_SESSAO")
    private SessaoEntity sessao;

    @Column(name = "ASSOCIADO")
    private String cpfAssociado;

    @Column(name = "VOTO")
    private Boolean voto;
}
