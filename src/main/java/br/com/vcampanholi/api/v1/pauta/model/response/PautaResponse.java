package br.com.vcampanholi.api.v1.pauta.model.response;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class PautaResponse {

    @ApiModelProperty(value = "Identificador da pauta.", example = "1")
    private Long id;

    @ApiModelProperty(value = "Assunto da pauta.", example = "Estratégia dos associados")
    private String assunto;

    @ApiModelProperty(value = "Data de cadastro da pauta.", example = "2019-09-06")
    private LocalDate dataCadastro;

    @ApiModelProperty(value = "Quantidade total de votos favoráveis", example = "10")
    private Long totalVotosFavor = 0L;

    @ApiModelProperty(value = "Quantidade total de votos contrários", example = "2")
    private Long totalVotosContra = 0L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getTotalVotosFavor() {
        return totalVotosFavor;
    }

    public void setTotalVotosFavor(Long totalVotosFavor) {
        this.totalVotosFavor = totalVotosFavor;
    }

    public Long getTotalVotosContra() {
        return totalVotosContra;
    }

    public void setTotalVotosContra(Long totalVotosContra) {
        this.totalVotosContra = totalVotosContra;
    }
}
