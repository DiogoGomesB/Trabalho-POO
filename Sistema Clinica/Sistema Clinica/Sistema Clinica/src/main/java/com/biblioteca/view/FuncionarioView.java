package com.biblioteca.view;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.controller.FuncionarioController;
import com.biblioteca.model.entity.Funcionario;

public class FuncionarioView {

    private final FuncionarioController funcionarioController;
    private final Scanner scanner;

    public FuncionarioView(FuncionarioController funcionarioController, Scanner scanner) {
        this.funcionarioController = funcionarioController;
        this.scanner = scanner;
    }

    public void cadastrarFuncionario() {
        System.out.println("Cadastro de Funcionário");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        Funcionario funcionario = new Funcionario(0, nome, cargo);
        String mensagem = funcionarioController.cadastrarFuncionario(funcionario);
        System.out.println(mensagem);
    }

    public void atualizarFuncionario() {
        System.out.println("Atualização de Funcionário");
        System.out.print("ID do Funcionário a ser atualizado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Funcionario funcionario = funcionarioController.buscarFuncionario(id);
        if (funcionario != null) {
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo Cargo: ");
            String novoCargo = scanner.nextLine();

            funcionario.setNome(novoNome);
            funcionario.setCargo(novoCargo);

            String mensagem = funcionarioController.atualizarFuncionario(funcionario);
            System.out.println(mensagem);
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    public void excluirFuncionario() {
        System.out.println("Exclusão de Funcionário");
        System.out.print("ID do Funcionário a ser excluído: ");
        int id = Integer.parseInt(scanner.nextLine());
        String mensagem = funcionarioController.excluirFuncionario(id);
        System.out.println(mensagem);
    }

    public void buscarFuncionario() {
        System.out.println("Busca de Funcionário");
        System.out.print("ID do Funcionário a ser buscado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Funcionario funcionario = funcionarioController.buscarFuncionario(id);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    public void listarFuncionarios() {
        System.out.println("Listagem de Funcionários");
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
}
