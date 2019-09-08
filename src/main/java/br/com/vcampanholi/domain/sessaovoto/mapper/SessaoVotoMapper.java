package br.com.vcampanholi.domain.sessaovoto.mapper;

import br.com.vcampanholi.api.v1.sessaovoto.model.request.SessaoVotoRequest;
import br.com.vcampanholi.domain.sessaovoto.repository.entity.SessaoVotoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotoMapper {

    public static SessaoVotoEntity mapToEntity(SessaoVotoRequest sessaoVotoRequest) {
        if (ObjectUtils.isEmpty(sessaoVotoRequest)) return null;
        return SessaoVotoEntity.builder()
                .cpfAssociado(sessaoVotoRequest.getCpfAssociado())
                .voto(sessaoVotoRequest.getVoto())
                .build();
    }
}
