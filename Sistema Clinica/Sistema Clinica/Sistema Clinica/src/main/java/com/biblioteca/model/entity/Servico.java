package com.biblioteca.model.entity;

public class Servico extends AbstractEntity {
    private String descricao;
    private double preco;



    public Servico() {}
    public Servico(int id, String descricao, double preco) {
        super.setId(id);
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
