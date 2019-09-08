package br.com.vcampanholi.api.v1.pauta.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@JsonPropertyOrder("id")
@EqualsAndHashCode(callSuper = false)
public class PautaResponse extends ResourceSupport {

    @JsonProperty("id")
    @ApiModelProperty(value = "Identificador da pauta.", example = "1")
    private Long pautaId;

    @ApiModelProperty(value = "Assunto da pauta.", example = "Estratégia dos associados")
    private String assunto;

    @ApiModelProperty(value = "Data de cadastro da pauta.", example = "2019-09-06")
    private LocalDate dataCadastro;
}
