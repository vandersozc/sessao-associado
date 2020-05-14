package br.com.vcampanholi.domain.sessao.mapper;

import br.com.vcampanholi.api.v1.sessao.model.request.SessaoRequest;
import br.com.vcampanholi.api.v1.sessao.model.response.SessaoResponse;
import br.com.vcampanholi.domain.pauta.mapper.PautaMapper;
import br.com.vcampanholi.domain.sessao.repository.entity.SessaoEntity;
import org.springframework.util.ObjectUtils;

public class SessaoMapper {
    public static SessaoResponse mapToResponse(SessaoEntity sessaoEntity) {
        if (ObjectUtils.isEmpty(sessaoEntity)) return null;

        SessaoResponse sessaoResponse = new SessaoResponse();
        sessaoResponse.setId(sessaoEntity.getId());
        sessaoResponse.setDataHoraAbertura(sessaoEntity.getDataHoraAbertura());
        sessaoResponse.setDataHoraEncerramento(sessaoEntity.getDataHoraEncerramento());
        sessaoResponse.setPauta(PautaMapper.mapToResponse(sessaoEntity.getPauta()));
        return sessaoResponse;
    }

    public static SessaoEntity mapToEntity(SessaoRequest sessaoRequest) {
        if (ObjectUtils.isEmpty(sessaoRequest)) return null;

        SessaoEntity sessaoEntity = new SessaoEntity();
        sessaoEntity.setDataHoraAbertura(sessaoRequest.getDataHoraAbertura());
        sessaoEntity.setDataHoraEncerramento(sessaoRequest.getDataHoraAbertura()
                .plusMinutes(sessaoRequest.getDuracao()));
        return sessaoEntity;
    }
}
