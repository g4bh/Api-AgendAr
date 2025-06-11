package com.agendAr.api.agendAr.domain.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@Table(name = "visitas")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoServico;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataServico;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaServico;

    private String cepEndereco;
    private String endereco;
    private Integer numeroResidencia;
    private String cidade;
    private String nomeAcolhedor;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Visita() {
    }

    public Visita(String tipoServico, LocalDate dataServico, LocalTime horaServico, String cepEndereco,
                  String endereco, Integer numeroResidencia, String cidade, String nomeAcolhedor, Usuario usuario) {
        this.tipoServico = tipoServico;
        this.dataServico = dataServico;
        this.horaServico = horaServico;
        this.cepEndereco = cepEndereco;
        this.endereco = endereco;
        this.numeroResidencia = numeroResidencia;
        this.cidade = cidade;
        this.nomeAcolhedor = nomeAcolhedor;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
