package br.com.vcampanholi.domain.sessao.repository.entity;

import br.com.vcampanholi.domain.pauta.repository.entity.PautaEntity;
import br.com.vcampanholi.domain.sessao.enumerations.SituacaoEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SessaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PAUTA")
    private PautaEntity pauta;

    @Column(name = "DATA_HORA_ABERTURA")
    private LocalDateTime dataHoraAbertura;

    @Column(name = "DATA_HORA_ENCERRAMENTO")
    private LocalDateTime dataHoraEncerramento;

    @Column(name = "SITUACAO")
    @Enumerated(EnumType.ORDINAL)
    private SituacaoEnum situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PautaEntity getPauta() {
        return pauta;
    }

    public void setPauta(PautaEntity pauta) {
        this.pauta = pauta;
    }

    public LocalDateTime getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(LocalDateTime dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public LocalDateTime getDataHoraEncerramento() {
        return dataHoraEncerramento;
    }

    public void setDataHoraEncerramento(LocalDateTime dataHoraEncerramento) {
        this.dataHoraEncerramento = dataHoraEncerramento;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }
}
