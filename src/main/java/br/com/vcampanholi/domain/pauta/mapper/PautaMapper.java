package br.com.vcampanholi.domain.pauta.mapper;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.domain.pauta.repository.entity.PautaEntity;
import org.springframework.util.ObjectUtils;

public class PautaMapper {
    public static PautaResponse mapToResponse(PautaEntity pautaEntity) {
        if (ObjectUtils.isEmpty(pautaEntity)) return null;
        return PautaResponse.builder()
                .pautaId(pautaEntity.getPautaId())
                .assunto(pautaEntity.getAssunto())
                .dataCadastro(pautaEntity.getDataCadastro())
                .build();
    }

    public static PautaEntity mapToEntity(PautaRequest pautaRequest) {
        if (ObjectUtils.isEmpty(pautaRequest)) return null;
        return PautaEntity.builder()
                .assunto(pautaRequest.getAssunto())
                .build();
    }
}
