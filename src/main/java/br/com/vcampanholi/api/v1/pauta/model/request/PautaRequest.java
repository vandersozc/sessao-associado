package br.com.vcampanholi.api.v1.pauta.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class PautaRequest {

    @NotNull(message = "O assunto da pauta deve ser informado.")
    @ApiModelProperty(value = "Assunto da pauta.", example = "Estratégia dos associados", required = true)
    private String assunto;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}