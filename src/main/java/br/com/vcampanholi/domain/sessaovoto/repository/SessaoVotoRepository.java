package br.com.vcampanholi.domain.sessaovoto.repository;

import br.com.vcampanholi.domain.sessaovoto.repository.entity.SessaoVotoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessaoVotoRepository extends CrudRepository<SessaoVotoEntity, Long> {

    Boolean existsBySessaoIdAndCpfAssociado(Long sessaoId, String cpfAssociado);

    List<SessaoVotoEntity> findBySessaoPautaId(Long pautaId);

}
