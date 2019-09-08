package br.com.vcampanholi.api.v1.sessao.facade;

import br.com.vcampanholi.api.v1.sessao.SessaoController;
import br.com.vcampanholi.api.v1.sessao.model.request.SessaoRequest;
import br.com.vcampanholi.api.v1.sessao.model.response.SessaoResponse;
import br.com.vcampanholi.domain.sessao.mapper.SessaoMapper;
import br.com.vcampanholi.domain.sessao.service.SessaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
@AllArgsConstructor
public class SessaoFacade {
    private SessaoService sessaoService;

    public SessaoResponse criarSessao(Long pautaId, SessaoRequest sessaoRequest) {
        var sessao = sessaoService.criarSessao(pautaId, sessaoRequest);
        var response = SessaoMapper.mapToResponse(sessao);
        return linkResponse(response);
    }

    private SessaoResponse linkResponse(SessaoResponse response) {
        response.add(linkTo(SessaoController.class)
                .slash(response.getPauta().getPautaId())
                .withSelfRel());
        return response;
    }
}