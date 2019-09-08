package br.com.vcampanholi.api.v1.sessao.model.response;

import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder("id")
public class SessaoResponse {

    @ApiModelProperty(value = "Identificador da sessão", example = "2")
    private Long id;

    @ApiModelProperty(value = "Data/hora de abertura da sessão", example = "2019-09-07T15:34:00.341Z")
    private LocalDateTime dataHoraAbertura;

    @ApiModelProperty(value = "Data/hora de enceramento da sessão", example = "2019-09-07T17:34:00.341Z")
    private LocalDateTime dataHoraEncerramento;

    @ApiModelProperty(value = "Dados da pauta")
    private PautaResponse pauta;
}