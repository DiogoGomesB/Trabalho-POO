package com.biblioteca.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.biblioteca.controller.AnimalController;
import com.biblioteca.controller.ClienteController;
import com.biblioteca.controller.ConsultaController;
import com.biblioteca.controller.FuncionarioController;
import com.biblioteca.controller.ServicoController;
import com.biblioteca.model.dao.AnimalDAO;
import com.biblioteca.model.dao.ClienteDAO;
import com.biblioteca.model.dao.ConsultaDAO;
import com.biblioteca.model.dao.FuncionarioDAO;
import com.biblioteca.model.dao.ServicoDAO;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Estabelecer conexão com o banco de dados
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ClinicaVet", "postgres", "200325");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return;
        }

        // Crie e inicialize os controladores correspondentes
        AnimalController animalController = new AnimalController(new AnimalDAO(conexao));
        ClienteController clienteController = new ClienteController(new ClienteDAO(conexao));
        ConsultaController consultaController = new ConsultaController(new ConsultaDAO(conexao));
        FuncionarioController funcionarioController = new FuncionarioController(new FuncionarioDAO(conexao));
        ServicoController servicoController = new ServicoController(new ServicoDAO(conexao));

        // Crie instâncias das classes de visualização e passe os controladores e o scanner como argumentos
        AnimalView animalView = new AnimalView(animalController, scanner);
        ClienteView clienteView = new ClienteView(clienteController, scanner);
        ConsultaView consultaView = new ConsultaView(consultaController, scanner);
        FuncionarioView funcionarioView = new FuncionarioView(funcionarioController, scanner);
        ServicoView servicoView = new ServicoView(servicoController, scanner);

        while (true) {
            System.out.println("Sistema de Gestão da Clínica Veterinária");
            System.out.println("1. Gerenciar Animais");
            System.out.println("2. Gerenciar Clientes");
            System.out.println("3. Gerenciar Consultas");
            System.out.println("4. Gerenciar Funcionários");
            System.out.println("5. Gerenciar Serviços");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    gerenciarAnimais(animalView, scanner);
                    break;
                case 2:
                    gerenciarClientes(clienteView, scanner);
                    break;
                case 3:
                    gerenciarConsultas(consultaView, scanner);
                    break;
                case 4:
                    gerenciarFuncionarios(funcionarioView, scanner);
                    break;
                case 5:
                    gerenciarServicos(servicoView, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarAnimais(AnimalView animalView, Scanner scanner) {
        while (true) {
            System.out.println("Gerenciar Animais");
            System.out.println("1. Exibir todos os animais");
            System.out.println("2. Adicionar animal");
            System.out.println("3. Atualizar animal");
            System.out.println("4. Deletar animal");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    animalView.listarAnimais();
                    break;
                case 2:
                    animalView.cadastrarAnimal();
                    break;
                case 3:
                    animalView.atualizarAnimal();
                    break;
                case 4:
                    animalView.excluirAnimal();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarClientes(ClienteView clienteView, Scanner scanner) {
        while (true) {
            System.out.println("Gerenciar Clientes");
            System.out.println("1. Exibir todos os clientes");
            System.out.println("2. Adicionar cliente");
            System.out.println("3. Atualizar cliente");
            System.out.println("4. Deletar cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    clienteView.listarClientes();
                    break;
                case 2:
                    clienteView.cadastrarCliente();
                    break;
                case 3:
                    clienteView.atualizarCliente();
                    break;
                case 4:
                    clienteView.excluirCliente();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarConsultas(ConsultaView consultaView, Scanner scanner) {
        while (true) {
            System.out.println("Gerenciar Consultas");
            System.out.println("1. Exibir todas as consultas");
            System.out.println("2. Adicionar consulta");
            System.out.println("3. Atualizar consulta");
            System.out.println("4. Deletar consulta");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    consultaView.listarConsultas();
                    break;
                case 2:
                    consultaView.cadastrarConsulta();
                    break;
                case 3:
                    consultaView.atualizarConsulta();
                    break;
                case 4:
                    consultaView.excluirConsulta();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarFuncionarios(FuncionarioView funcionarioView, Scanner scanner) {
        while (true) {
            System.out.println("Gerenciar Funcionários");
            System.out.println("1. Exibir todos os funcionários");
            System.out.println("2. Adicionar funcionário");
            System.out.println("3. Atualizar funcionário");
            System.out.println("4. Deletar funcionário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1 ->
                    funcionarioView.listarFuncionarios();
                case 2 ->
                    funcionarioView.cadastrarFuncionario();
                case 3 ->
                    funcionarioView.atualizarFuncionario();
                case 4 ->
                    funcionarioView.excluirFuncionario();
                case 0 -> {
                    return;
                }
                default ->
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarServicos(ServicoView servicoView, Scanner scanner) {
        while (true) {
            System.out.println("Gerenciar Serviços");
            System.out.println("1. Exibir todos os serviços");
            System.out.println("2. Adicionar serviço");
            System.out.println("3. Atualizar serviço");
            System.out.println("4. Deletar serviço");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    servicoView.listarServicos();
                    break;
                case 2:
                    servicoView.cadastrarServico();
                    break;
                case 3:
                    servicoView.atualizarServico();
                    break;
                case 4:
                    servicoView.excluirServico();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}