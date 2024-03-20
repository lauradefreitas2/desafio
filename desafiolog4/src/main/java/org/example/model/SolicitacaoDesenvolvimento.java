package org.example.model;

import java.util.Date;
import java.util.List;

public class SolicitacaoDesenvolvimento {
    private String numeroSequencia;
    private Date dataInicio;
    private Date dataFinal;
    private StatusDesenvolvimento statusDesenvolvimento;
    private DominioAtendimento dominioAtendimento;
    private List<Desenvolvedor> desenvolvedores;

    public SolicitacaoDesenvolvimento(String numeroSequencia, Date dataInicio, Date dataFinal, StatusDesenvolvimento statusDesenvolvimento, DominioAtendimento dominioAtendimento, List<Desenvolvedor> desenvolvedores) {
        this.numeroSequencia = numeroSequencia;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.statusDesenvolvimento = statusDesenvolvimento;
        this.dominioAtendimento = dominioAtendimento;
        this.desenvolvedores = desenvolvedores;
    }

    public String getNumeroSequencia() {
        return numeroSequencia;
    }

    public void setNumeroSequencia(String numeroSequencia) {
        this.numeroSequencia = numeroSequencia;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public StatusDesenvolvimento getStatusDesenvolvimento() {
        return statusDesenvolvimento;
    }

    public void setStatusDesenvolvimento(StatusDesenvolvimento statusDesenvolvimento) {
        this.statusDesenvolvimento = statusDesenvolvimento;
    }

    public DominioAtendimento getDominioAtendimento() {
        return dominioAtendimento;
    }

    public void setDominioAtendimento(DominioAtendimento dominioAtendimento) {
        this.dominioAtendimento = dominioAtendimento;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
