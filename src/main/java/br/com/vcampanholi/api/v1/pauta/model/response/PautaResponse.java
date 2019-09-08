package br.com.vcampanholi.api.v1.pauta.model.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder("id")
public class PautaResponse {

    @ApiModelProperty(value = "Identificador da pauta.", example = "1")
    private Long id;

    @ApiModelProperty(value = "Assunto da pauta.", example = "Estratégia dos associados")
    private String assunto;

    @ApiModelProperty(value = "Data de cadastro da pauta.", example = "2019-09-06")
    private LocalDate dataCadastro;

    @ApiModelProperty(value = "Quantidade total de votos favoráveis", example = "10")
    @Builder.Default
    private Long totalVotosFavor = 0L;

    @ApiModelProperty(value = "Quantidade total de votos contrários", example = "2")
    @Builder.Default
    private Long totalVotosContra = 0L;
}
