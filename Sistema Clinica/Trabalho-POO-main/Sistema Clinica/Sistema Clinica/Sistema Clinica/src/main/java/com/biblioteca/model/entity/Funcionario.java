package com.biblioteca.model.entity;

public class Funcionario extends AbstractEntity {
    private String nome;
    private String cargo;



    public Funcionario() {}
    public Funcionario(int id, String nome, String cargo) {
        super.setId(id);
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
