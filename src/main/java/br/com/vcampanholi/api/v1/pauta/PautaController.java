package br.com.vcampanholi.api.v1.pauta;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.domain.pauta.service.PautaService;
import br.com.vcampanholi.exception.GenericException;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("sessao-associado/v1/pauta")
@Api("Serviço para operações na pauta.")
public class PautaController {

    private PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    @ApiOperation(value = "Criar uma nova pauta.", response = PautaResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = PautaResponse.class),
    })
    public ResponseEntity<PautaResponse> criarPauta(@ApiParam(value = "Informações da pauta.", required = true)
                                                    @Valid @RequestBody PautaRequest pautaRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pautaService.criarPauta(pautaRequest));
    }

    @GetMapping("/{pauta_id}")
    @ApiOperation(value = "Buscar uma pauta pelo identificador com votos computados.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = PautaResponse.class),
            @ApiResponse(code = 404, message = "Pauta não encontrada.", response = GenericException.class)
    })
    public ResponseEntity<PautaResponse> buscarPautaComputada(@ApiParam(value = "pauta_id.", required = true)
                                                              @PathVariable("pauta_id") Long pautaId) {
        return ResponseEntity.ok(pautaService.buscarPautaComputada(pautaId));
    }
}