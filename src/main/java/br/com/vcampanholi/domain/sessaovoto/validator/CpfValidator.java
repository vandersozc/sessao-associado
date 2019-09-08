package br.com.vcampanholi.domain.sessaovoto.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CpfValidator {

    private static final Integer VALOR_RESTO_DIVISAO = 2;
    private static final Integer TAMANHO_CPF = 11;
    private static final Integer DIGITO_MAIOR_CPF = 12;

    public static boolean cpfValido(String cpf) {

        if (ObjectUtils.isEmpty(cpf)
                || !cpf.matches("[0-9]+")
                || cpf.length() != TAMANHO_CPF
                || sequenciaInvalida(cpf)) {
            return false;
        }

        int primeiroResultado;
        int segundoResultado;
        int primeiroDigito;
        int segundoDigito;
        int restoDivisao;
        int digitoCPF;
        String digitosResultado;

        primeiroResultado = segundoResultado = 0;

        for (int caracter = 1; caracter < cpf.length() - 1; caracter++) {
            digitoCPF = Integer.valueOf(cpf.substring(caracter - 1, caracter));
            primeiroResultado = primeiroResultado + (TAMANHO_CPF - caracter) * digitoCPF;
            segundoResultado = segundoResultado + (DIGITO_MAIOR_CPF - caracter) * digitoCPF;
        }

        restoDivisao = (primeiroResultado % TAMANHO_CPF);

        if (restoDivisao < VALOR_RESTO_DIVISAO) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = TAMANHO_CPF - restoDivisao;
        }

        segundoResultado += VALOR_RESTO_DIVISAO * primeiroDigito;

        restoDivisao = (segundoResultado % TAMANHO_CPF);

        if (restoDivisao < VALOR_RESTO_DIVISAO) {
            segundoDigito = 0;
        } else {
            segundoDigito = TAMANHO_CPF - restoDivisao;
        }

        String digitosVerificados = cpf.substring(cpf.length() - VALOR_RESTO_DIVISAO);
        digitosResultado = String.valueOf(primeiroDigito) + segundoDigito;
        return digitosVerificados.equals(digitosResultado);
    }

    private static boolean sequenciaInvalida(String cpf) {
        var sequencias = Arrays.asList("11111111111", "22222222222", "33333333333", "44444444444",
                "55555555555", "66666666666", "77777777777", "88888888888", "99999999999");
        return sequencias.stream()
                .anyMatch(sequencia -> sequencia.equals(cpf));
    }
}


