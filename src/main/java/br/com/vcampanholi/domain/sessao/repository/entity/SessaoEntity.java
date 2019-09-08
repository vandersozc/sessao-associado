package br.com.vcampanholi.domain.sessao.repository.entity;

import br.com.vcampanholi.domain.pauta.repository.entity.PautaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SessaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long sessaoId;

    @ManyToOne
    @JoinColumn(name = "ID_PAUTA")
    private PautaEntity pauta;

    @Column(name = "DATA_HORA_ABERTURA")
    private LocalDateTime dataHoraAbertura;

    @Column(name = "DATA_HORA_ENCERRAMENTO")
    private LocalDateTime dataHoraEncerramento;
}
