package br.com.vcampanholi.domain.pauta.service;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.domain.pauta.mapper.PautaMapper;
import br.com.vcampanholi.domain.pauta.repository.PautaRepository;
import br.com.vcampanholi.domain.pauta.repository.entity.PautaEntity;
import br.com.vcampanholi.exception.GenericException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PautaService {

    private PautaRepository pautaRepository;

    public PautaEntity criarPauta(PautaRequest pauta) {
        var entity = PautaMapper.mapToEntity(pauta);
        entity.setDataCadastro(LocalDate.now());
        return pautaRepository.save(entity);
    }

    public PautaEntity buscarPauta(Long pautaId) {
        return pautaRepository.findById(pautaId)
                .orElseThrow(() -> new GenericException("Nenhuma pauta encontrada para a consulta.",
                        HttpStatus.NOT_FOUND));
    }
}