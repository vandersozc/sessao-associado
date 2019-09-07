package br.com.vcampanholi.impl.service;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.exception.GenericException;
import br.com.vcampanholi.impl.mapper.PautaMapper;
import br.com.vcampanholi.impl.repository.PautaRepository;
import br.com.vcampanholi.impl.repository.entity.PautaEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PautaService {

    private PautaRepository pautaRepository;

    public PautaEntity criarPauta(PautaRequest pauta) {
        var entity = PautaMapper.mapToCreate(pauta);
        entity.setDataCadastro(LocalDate.now());
        return pautaRepository.save(entity);
    }

    public PautaEntity buscarPauta(Long pautaId) {
        return pautaRepository.findById(pautaId)
                .orElseThrow(() -> new GenericException("Nenhuma pauta encontrada com id: " + pautaId,
                        HttpStatus.NOT_FOUND));
    }
}
