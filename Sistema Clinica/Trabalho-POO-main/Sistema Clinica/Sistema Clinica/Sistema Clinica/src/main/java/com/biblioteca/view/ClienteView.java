package com.biblioteca.view;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.controller.ClienteController;
import com.biblioteca.model.entity.Cliente;

public class ClienteView {

    private final ClienteController clienteController;
    private final Scanner scanner;

    public ClienteView(ClienteController clienteController, Scanner scanner) {
        this.clienteController = clienteController;
        this.scanner = scanner;
    }

    public void cadastrarCliente() {
        System.out.println("Cadastro de Cliente");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(0, nome, endereco, telefone);
        String mensagem = clienteController.cadastrarCliente(cliente);
        System.out.println(mensagem);
    }

    public void atualizarCliente() {
        System.out.println("Atualização de Cliente");
        System.out.print("ID do Cliente a ser atualizado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Cliente cliente = clienteController.buscarCliente(id);
        if (cliente != null) {
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo Endereço: ");
            String novoEndereco = scanner.nextLine();
            System.out.print("Novo Telefone: ");
            String novoTelefone = scanner.nextLine();

            cliente.setNome(novoNome);
            cliente.setEndereco(novoEndereco);
            cliente.setTelefone(novoTelefone);

            String mensagem = clienteController.atualizarCliente(cliente);
            System.out.println(mensagem);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void excluirCliente() {
        System.out.println("Exclusão de Cliente");
        System.out.print("ID do Cliente a ser excluído: ");
        int id = Integer.parseInt(scanner.nextLine());
        String mensagem = clienteController.excluirCliente(id);
        System.out.println(mensagem);
    }

    public void buscarCliente() {
        System.out.println("Busca de Cliente");
        System.out.print("ID do Cliente a ser buscado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Cliente cliente = clienteController.buscarCliente(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public List<Cliente> listarClientes() {
        System.out.println("Listagem de Clientes");
        List<Cliente> clientes = clienteController.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        return clientes;
    }
}
