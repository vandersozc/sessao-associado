package br.com.vcampanholi.api.v1.pauta.facade;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.impl.mapper.PautaMapper;
import br.com.vcampanholi.impl.service.PautaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PautaFacade {
    private PautaService pautaService;

    public List<PautaResponse> get() {
        return pautaService.get().stream()
                .map(pauta -> PautaResponse.builder()
                        .pautaId(pauta.getPautaId())
                        .dataCadastro(pauta.getDataCadastro())
                        .assunto(pauta.getAssunto())
                        .build()
                ).collect(Collectors.toList());
    }

    public PautaResponse criarPauta(PautaRequest pautaRequest) {
        return PautaMapper.mapToResponse(pautaService.criarPauta(pautaRequest));
    }

    public PautaResponse buscarPauta(Long pautaId) {
        return PautaMapper.mapToResponse(pautaService.buscarPauta(pautaId));
    }
}