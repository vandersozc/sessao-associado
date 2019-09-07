package br.com.vcampanholi.api.v1.pauta.model.request;

import br.com.vcampanholi.impl.enumerations.StatusPautaEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PautaRequest {

    @NotNull(message = "O assunto da pauta deve ser informado.")
    @ApiModelProperty(value = "Assunto da pauta.", example = "Divisão de dividendos entre os sócios", required = true)
    private String assunto;

//    @ApiModelProperty(value = "Status da pauta", allowableValues = "ABERTA | ENCERRADA", required = true)
//    @NotNull(message = "O status da pauta deve ser informado - Valor padrão: ABERTA")
//    @Builder.Default
//    private StatusPautaEnum status = StatusPautaEnum.ABERTA;
}
