package br.com.vcampanholi.api.v1.sessao.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SessaoRequest {

    @NotNull(message = "Duração da sessão deve ser informada")
    @ApiModelProperty(value = "Duração da sessão. Valor padrão 1 minuto", example = "30")
    private Integer duracao = 1;

    @NotNull(message = "A data/hora de abertura deve ser informada")
    @ApiModelProperty(value = "Data/hora de abertura da sessão",
            example = "2019-09-07T15:34:00.341Z", required = true)
    private LocalDateTime dataHoraAbertura;

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public LocalDateTime getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(LocalDateTime dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }
}
