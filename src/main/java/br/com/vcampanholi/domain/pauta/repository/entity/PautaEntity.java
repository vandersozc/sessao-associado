package br.com.vcampanholi.domain.pauta.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PautaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long pautaId;

    @Column(name = "ASSUNTO")
    private String assunto;

    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;
}
