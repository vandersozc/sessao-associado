package br.com.vcampanholi.api.v1.sessao.model.response;

import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class SessaoResponse {

    @ApiModelProperty(value = "Identificador da sessão", example = "2")
    private Long id;

    @ApiModelProperty(value = "Data/hora de abertura da sessão", example = "2019-09-07T15:34:00.341Z")
    private LocalDateTime dataHoraAbertura;

    @ApiModelProperty(value = "Data/hora de enceramento da sessão", example = "2019-09-07T17:34:00.341Z")
    private LocalDateTime dataHoraEncerramento;

    @ApiModelProperty(value = "Dados da pauta")
    private PautaResponse pauta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PautaResponse getPauta() {
        return pauta;
    }

    public void setPauta(PautaResponse pauta) {
        this.pauta = pauta;
    }
}