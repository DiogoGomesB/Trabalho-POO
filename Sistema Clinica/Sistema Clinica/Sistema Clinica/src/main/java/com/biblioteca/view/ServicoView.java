package com.biblioteca.view;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.controller.ServicoController;
import com.biblioteca.model.entity.Servico;

public class ServicoView {

    private final ServicoController servicoController;
    private final Scanner scanner;

    public ServicoView(ServicoController servicoController, Scanner scanner) {
        this.servicoController = servicoController;
        this.scanner = scanner;
    }

    public void cadastrarServico() {
        System.out.println("Cadastro de Serviço");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        Servico servico = new Servico(0, descricao, preco);
        String mensagem = servicoController.cadastrarServico(servico);
        System.out.println(mensagem);
    }

    public void atualizarServico() {
        System.out.println("Atualização de Serviço");
        System.out.print("ID do Serviço a ser atualizado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Servico servico = servicoController.buscarServico(id);
        if (servico != null) {
            System.out.print("Nova Descrição: ");
            String novaDescricao = scanner.nextLine();
            System.out.print("Novo Preço: ");
            double novoPreco = Double.parseDouble(scanner.nextLine());

            servico.setDescricao(novaDescricao);
            servico.setPreco(novoPreco);

            String mensagem = servicoController.atualizarServico(servico);
            System.out.println(mensagem);
        } else {
            System.out.println("Serviço não encontrado!");
        }
    }

    public void excluirServico() {
        System.out.println("Exclusão de Serviço");
        System.out.print("ID do Serviço a ser excluído: ");
        int id = Integer.parseInt(scanner.nextLine());
        String mensagem = servicoController.excluirServico(id);
        System.out.println(mensagem);
    }

    public void buscarServico() {
        System.out.println("Busca de Serviço");
        System.out.print("ID do Serviço a ser buscado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Servico servico = servicoController.buscarServico(id);
        if (servico != null) {
            System.out.println("Serviço encontrado:");
            System.out.println(servico);
        } else {
            System.out.println("Serviço não encontrado!");
        }
    }

    public void listarServicos() {
        System.out.println("Listagem de Serviços");
        List<Servico> servicos = servicoController.listarServicos();
        for (Servico servico : servicos) {
            System.out.println(servico);
        }
    }
}
