package br.com.vcampanholi.domain.sessao.service;

import br.com.vcampanholi.api.v1.sessao.model.request.SessaoRequest;
import br.com.vcampanholi.domain.pauta.service.PautaService;
import br.com.vcampanholi.domain.sessao.mapper.SessaoMapper;
import br.com.vcampanholi.domain.sessao.repository.SessaoRepository;
import br.com.vcampanholi.domain.sessao.repository.entity.SessaoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessaoService {

    private PautaService pautaService;

    private SessaoRepository sessaoRepository;

    public SessaoEntity criarSessao(Long pautaId, SessaoRequest sessao) {
        var entity = SessaoMapper.mapToEntity(sessao);
        entity.setPauta(pautaService.buscarPauta(pautaId));
        return sessaoRepository.save(entity);
    }
}