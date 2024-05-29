package com.biblioteca.model.entity;

public class Animal extends AbstractEntity {

    private String nome;
    private String raca;
    private char sexo;
    private String tipo;
    private int idCliente;

    public Animal() {
    }

    public Animal(int id, String nome, String raca, char sexo, String tipo, int idCliente) {
        super.setId(id);
        this.nome = nome;
        this.raca = raca;
        this.sexo = sexo;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
