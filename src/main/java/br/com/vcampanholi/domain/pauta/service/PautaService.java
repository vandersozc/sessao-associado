package br.com.vcampanholi.domain.pauta.service;

import br.com.vcampanholi.api.v1.pauta.model.request.PautaRequest;
import br.com.vcampanholi.api.v1.pauta.model.response.PautaResponse;
import br.com.vcampanholi.domain.pauta.mapper.PautaMapper;
import br.com.vcampanholi.domain.pauta.repository.PautaRepository;
import br.com.vcampanholi.domain.pauta.repository.entity.PautaEntity;
import br.com.vcampanholi.domain.sessaovoto.repository.SessaoVotoRepository;
import br.com.vcampanholi.exception.GenericException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PautaService {

    private PautaRepository pautaRepository;
    private SessaoVotoRepository sessaoVotoRepository;

    public PautaResponse criarPauta(PautaRequest pauta) {
        var entity = PautaMapper.mapToEntity(pauta);
        entity.setDataCadastro(LocalDate.now());
        return PautaMapper.mapToResponse(pautaRepository.save(entity));
    }

    public PautaResponse buscarPautaComputada(Long pautaId) {
        var pauta = PautaMapper.mapToResponse(buscarPauta(pautaId));
        var sessaoVotos = sessaoVotoRepository.findBySessaoPautaId(pautaId);

        var totalVotosFavor = sessaoVotos.stream()
                .filter(voto -> Boolean.TRUE.equals(voto.getVoto())).count();
        var totalVotosContra = sessaoVotos.stream()
                .filter(voto -> Boolean.FALSE.equals(voto.getVoto())).count();

        pauta.setTotalVotosFavor(totalVotosFavor);
        pauta.setTotalVotosContra(totalVotosContra);
        return pauta;
    }

    public PautaEntity buscarPauta(Long pautaId) {
        return pautaRepository.findById(pautaId)
                .orElseThrow(() -> new GenericException(
                        "Nenhuma pauta encontrada com id: ".concat(pautaId.toString()), HttpStatus.NOT_FOUND));
    }

    public List<Long> buscarIdPautas() {
        return pautaRepository.findAllId();
    }
}