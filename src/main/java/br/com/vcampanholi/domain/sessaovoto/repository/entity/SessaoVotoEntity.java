package br.com.vcampanholi.domain.sessaovoto.repository.entity;

import br.com.vcampanholi.domain.sessao.repository.entity.SessaoEntity;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SessaoEntity getSessao() {
        return sessao;
    }

    public void setSessao(SessaoEntity sessao) {
        this.sessao = sessao;
    }

    public String getCpfAssociado() {
        return cpfAssociado;
    }

    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }

    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }
}
