package com.biblioteca.model.entity;

public class TestCliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "João da Silva", "Rua das Flores, 123", "1234-5678");
        System.out.println(cliente);
    }
}
