package br.com.vcampanholi.api.v1.pauta.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PautaResponse extends ResourceSupport {

    private Long pautaId;
    private String assunto;
    private LocalDate dataCadastro;
}
