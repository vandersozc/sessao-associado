package br.com.vcampanholi.api.v1.pauta.model.request;

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
    @ApiModelProperty(value = "Assunto da pauta.", example = "Estratégia dos associados", required = true)
    private String assunto;
}
