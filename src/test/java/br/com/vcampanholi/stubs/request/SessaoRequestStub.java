package br.com.vcampanholi.stubs.request;import br.com.vcampanholi.api.v1.sessao.model.request.SessaoRequest;import java.time.LocalDateTime;import java.time.Month;public class SessaoRequestStub {    public static SessaoRequest sessaoRequest() {        SessaoRequest sessaoRequest = new SessaoRequest();        sessaoRequest.setDataHoraAbertura(LocalDateTime.of(2019, Month.SEPTEMBER, 07, 15, 10));        return sessaoRequest;    }}