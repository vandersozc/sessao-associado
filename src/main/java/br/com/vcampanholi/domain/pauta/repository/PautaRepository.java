package br.com.vcampanholi.domain.pauta.repository;

import br.com.vcampanholi.domain.pauta.repository.entity.PautaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PautaRepository extends CrudRepository<PautaEntity, Long> {

    List<PautaEntity> findAll();

}
