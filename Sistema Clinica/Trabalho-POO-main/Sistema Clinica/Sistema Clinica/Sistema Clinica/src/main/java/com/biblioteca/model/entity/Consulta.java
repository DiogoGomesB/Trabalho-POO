package com.biblioteca.model.entity;

import java.util.Date;

public class Consulta extends AbstractEntity {

    private Date dataConsulta;
    private int idAnimal;
    private int idFuncionario;
    private int idServico;


    public Consulta() {}
    public Consulta(int id, Date dataConsulta, int idAnimal, int idFuncionario, int idServico) {
        super.setId(id);
        this.dataConsulta = dataConsulta;
        this.idAnimal = idAnimal;
        this.idFuncionario = idFuncionario;
        this.idServico = idServico;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getTipo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
    }
}
