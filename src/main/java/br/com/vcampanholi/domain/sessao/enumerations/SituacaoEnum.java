package br.com.vcampanholi.domain.sessao.enumerations;

import lombok.Getter;

@Getter
public enum SituacaoEnum {
    ABERTA,
    ENCERRADA;

    private Integer value;
}