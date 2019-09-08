package br.com.vcampanholi.domain.sessao.mapper;

import br.com.vcampanholi.api.v1.sessao.model.request.SessaoRequest;
import br.com.vcampanholi.api.v1.sessao.model.response.SessaoResponse;
import br.com.vcampanholi.domain.pauta.mapper.PautaMapper;
import br.com.vcampanholi.domain.sessao.repository.entity.SessaoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoMapper {
    public static SessaoResponse mapToResponse(SessaoEntity sessaoEntity) {
        if (ObjectUtils.isEmpty(sessaoEntity)) return null;
        return SessaoResponse.builder()
                .sessaoId(sessaoEntity.getSessaoId())
                .dataHoraAbertura(sessaoEntity.getDataHoraAbertura())
                .dataHoraEncerramento(sessaoEntity.getDataHoraEncerramento())
                .pauta(PautaMapper.mapToResponse(sessaoEntity.getPauta()))
                .build();
    }

    public static SessaoEntity mapToEntity(SessaoRequest sessaoRequest) {
        if (ObjectUtils.isEmpty(sessaoRequest)) return null;
        return SessaoEntity.builder()
                .dataHoraAbertura(sessaoRequest.getDataHoraAbertura())
                .dataHoraEncerramento(sessaoRequest.getDataHoraAbertura()
                        .plusMinutes(sessaoRequest.getDuracao()))
                .build();
    }
}
