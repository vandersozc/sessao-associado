package br.com.vcampanholi.api.v1.pauta;

import br.com.vcampanholi.api.v1.pauta.facade.PautaFacade;
import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.exception.GenericException;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("sessao-associado/v1/pauta")
@Api("Serviço para operações na pauta.")
@AllArgsConstructor
public class PautaController {

    private PautaFacade pautaFacade;

    @PostMapping
    @ApiOperation(value = "Criar uma nova pauta.", response = PautaResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = PautaResponse.class),
    })
    public PautaResponse criarPauta(@ApiParam(value = "Informações da pauta.", required = true)
                                    @Valid @RequestBody PautaRequest pautaRequest) {
        return pautaFacade.criarPauta(pautaRequest);
    }

    @GetMapping("/{pauta_id}")
    @ApiOperation(value = "Buscar uma pauta pelo identificador.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = PautaResponse.class),
            @ApiResponse(code = 404, message = "Pauta não encontrada.", response = GenericException.class)
    })
    public PautaResponse buscarPauta(@ApiParam(value = "pauta_id.", required = true)
                                     @PathVariable("pauta_id") Long pautaId) {
        return pautaFacade.buscarPauta(pautaId);
    }
}