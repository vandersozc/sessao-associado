package br.com.vcampanholi.domain.sessaovoto.mapper;

import br.com.vcampanholi.api.v1.sessaovoto.model.request.SessaoVotoRequest;
import br.com.vcampanholi.domain.sessaovoto.repository.entity.SessaoVotoEntity;
import org.springframework.util.ObjectUtils;

public class SessaoVotoMapper {

    public static SessaoVotoEntity mapToEntity(SessaoVotoRequest sessaoVotoRequest) {
        if (ObjectUtils.isEmpty(sessaoVotoRequest)) return null;

        SessaoVotoEntity sessaoVotoEntity = new SessaoVotoEntity();
        sessaoVotoEntity.setCpfAssociado(sessaoVotoRequest.getCpfAssociado());
        sessaoVotoEntity.setVoto(sessaoVotoRequest.getVoto());
        return sessaoVotoEntity;
    }
}
