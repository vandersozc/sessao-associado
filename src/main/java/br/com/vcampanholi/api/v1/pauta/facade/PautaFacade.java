package br.com.vcampanholi.api.v1.pauta.facade;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.impl.mapper.PautaMapper;
import br.com.vcampanholi.impl.service.PautaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PautaFacade {
    private PautaService pautaService;

    public PautaResponse criarPauta(PautaRequest pautaRequest) {
        return PautaMapper.mapToResponse(pautaService.criarPauta(pautaRequest));
    }

    public PautaResponse buscarPauta(Long pautaId) {
        return PautaMapper.mapToResponse(pautaService.buscarPauta(pautaId));
    }
}