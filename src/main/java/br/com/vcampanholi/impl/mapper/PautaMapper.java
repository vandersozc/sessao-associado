package br.com.vcampanholi.impl.mapper;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.impl.model.PautaModel;
import br.com.vcampanholi.impl.repository.entity.PautaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PautaMapper {

    public static PautaResponse mapToResponse(PautaEntity pautaModel) {
        if (ObjectUtils.isEmpty(pautaModel)) return null;
        return PautaResponse.builder()
                .pautaId(pautaModel.getPautaId())
                .assunto(pautaModel.getAssunto())
                .dataCadastro(pautaModel.getDataCadastro())
                .build();
    }

    public static PautaEntity mapToUpdate(Long pautaId, PautaRequest pautaRequest) {
        if (ObjectUtils.isEmpty(pautaRequest)) return null;
        return PautaEntity.builder()
                .pautaId(pautaId)
                .assunto(pautaRequest.getAssunto())
                .build();
    }

    public static PautaEntity mapToCreate(PautaRequest pautaRequest) {
        if (ObjectUtils.isEmpty(pautaRequest)) return null;
        return PautaEntity.builder()
                .assunto(pautaRequest.getAssunto())
                .build();
    }
}
