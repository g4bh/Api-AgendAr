package com.agendAr.api.agendAr.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@Getter
public class VisitaDTO {
    private String tipoServico;
    private LocalDate dataServico;
    private LocalTime horaServico;
    private String cepEndereco;
    private String endereco;
    private Integer numeroResidencia;
    private String cidade;
    private String nomeAcolhedor;

    public VisitaDTO() {
    }

    public VisitaDTO(String tipoServico, LocalDate dataServico, LocalTime horaServico,
                     String cepEndereco, String endereco, Integer numeroResidencia,
                     String cidade, String nomeAcolhedor) {
        this.tipoServico = tipoServico;
        this.dataServico = dataServico;
        this.horaServico = horaServico;
        this.cepEndereco = cepEndereco;
        this.endereco = endereco;
        this.numeroResidencia = numeroResidencia;
        this.cidade = cidade;
        this.nomeAcolhedor = nomeAcolhedor;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public LocalDate getDataServico() {
        return dataServico;
    }

    public void setDataServico(LocalDate dataServico) {
        this.dataServico = dataServico;
    }

    public LocalTime getHoraServico() {
        return horaServico;
    }

    public void setHoraServico(LocalTime horaServico) {
        this.horaServico = horaServico;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(Integer numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNomeAcolhedor() {
        return nomeAcolhedor;
    }

    public void setNomeAcolhedor(String nomeAcolhedor) {
        this.nomeAcolhedor = nomeAcolhedor;
    }
}