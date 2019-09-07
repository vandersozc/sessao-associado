package br.com.vcampanholi.api.v1.pauta.facade;

import br.com.vcampanholi.api.v1.pauta.PautaController;
import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.domain.pauta.mapper.PautaMapper;
import br.com.vcampanholi.domain.pauta.service.PautaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
@AllArgsConstructor
public class PautaFacade {
    private PautaService pautaService;

    public PautaResponse criarPauta(PautaRequest pautaRequest) {
        var response = PautaMapper.mapToResponse(pautaService.criarPauta(pautaRequest));
        return linkResponse(response);
    }

    public PautaResponse buscarPauta(Long pautaId) {
        var response = PautaMapper.mapToResponse(pautaService.buscarPauta(pautaId));
        return linkResponse(response);
    }

    private PautaResponse linkResponse(PautaResponse response) {
        response.add(linkTo(PautaController.class)
                .slash(response.getPautaId())
                .withSelfRel());
        return response;
    }
}