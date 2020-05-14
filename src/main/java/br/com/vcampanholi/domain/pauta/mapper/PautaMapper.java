package br.com.vcampanholi.domain.pauta.mapper;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.domain.pauta.repository.entity.PautaEntity;
import org.springframework.util.ObjectUtils;

public class PautaMapper {
    public static PautaResponse mapToResponse(PautaEntity pautaEntity) {
        if (ObjectUtils.isEmpty(pautaEntity)) return null;

        PautaResponse pautaResponse = new PautaResponse();
        pautaResponse.setId(pautaEntity.getId());
        pautaResponse.setAssunto(pautaEntity.getAssunto());
        pautaResponse.setDataCadastro(pautaEntity.getDataCadastro());
        return pautaResponse;

    }

    public static PautaEntity mapToEntity(PautaRequest pautaRequest) {
        if (ObjectUtils.isEmpty(pautaRequest)) return null;

        PautaEntity pautaEntity = new PautaEntity();
        pautaEntity.setAssunto(pautaRequest.getAssunto());
        return pautaEntity;
    }
}
