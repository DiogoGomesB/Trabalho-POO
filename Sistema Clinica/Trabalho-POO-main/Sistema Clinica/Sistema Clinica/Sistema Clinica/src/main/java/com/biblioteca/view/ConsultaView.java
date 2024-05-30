package com.biblioteca.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.biblioteca.controller.ConsultaController;
import com.biblioteca.model.entity.Consulta;

public class ConsultaView {
    private Connection connection;
    private final ConsultaController consultaController;
    private final Scanner scanner;
    private final SimpleDateFormat dateFormat;

    public ConsultaView(Connection connection, ConsultaController consultaController, Scanner scanner) {
        this.connection = connection;
        this.consultaController = consultaController;
        this.scanner = scanner;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }


    public ConsultaView(ConsultaController consultaController, Scanner scanner) {
        this.connection = connection;
        this.consultaController = consultaController;
        this.scanner = scanner;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void cadastrarConsulta() {
        System.out.println("Cadastro de Consulta");
        System.out.print("Data da Consulta (dd/mm/yyyy): ");
        String dataConsultaStr = scanner.nextLine();
        Date dataConsulta = parseDate(dataConsultaStr);
        System.out.print("ID do Animal: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        if (!idAnimalExiste(idAnimal)) {
            System.out.println("Error: Não há Animal cadastrado com o ID fornecido. Por favor, cadastre um novo.");
            return;
        }
        System.out.print("ID do Funcionário: ");
        int idFuncionario = Integer.parseInt(scanner.nextLine());
        if (!idFuncionarioExiste(idFuncionario)) {
            System.out.println("Error: Não há Funcionário cadastrado com o ID fornecido. Por favor, cadastre um novo.");
            return;
        }
        System.out.print("ID do Serviço: ");
        int idServico = Integer.parseInt(scanner.nextLine());
        if (!idServicoExiste (idServico)) {
            System.out.println("Error: Não há Serviço cadastrado com o ID fornecido. Por favor, cadastre um novo.");
            return;
        }

        Consulta consulta = new Consulta(0, dataConsulta, idAnimal, idFuncionario, idServico);
        String mensagem = consultaController.cadastrarConsulta(consulta);
        System.out.println(mensagem);
    }

    private boolean idAnimalExiste(int idAnimal) {
        if (connection == null) {
            System.out.println("Error: Conexão com o banco de dados não foi inicializada.");
            return false;
        }
        String sql = "SELECT COUNT(*) FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idAnimal);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Retorna true se o número de clientes for maior que zero
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //
    }
    private boolean idFuncionarioExiste(int idFuncionario) {
        if (connection == null) {
            System.out.println("Error: Conexão com o banco de dados não foi inicializada.");
            return false;
        }
        String sql = "SELECT COUNT(*) FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idFuncionario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Retorna true se o número de clientes for maior que zero
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //
    }

    private boolean idServicoExiste(int idServico) {
        if (connection == null) {
            System.out.println("Error: Conexão com o banco de dados não foi inicializada.");
            return false;
        }
        String sql = "SELECT COUNT(*) FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idServico);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Retorna true se o número de clientes for maior que zero
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //
    }
    public void atualizarConsulta() {
        System.out.println("Atualização de Consulta");
        System.out.print("ID da Consulta a ser atualizada: ");
        int id = Integer.parseInt(scanner.nextLine());
        Consulta consulta = consultaController.buscarConsulta(id);
        if (consulta != null) {
            System.out.print("Nova Data da Consulta (dd/mm/yyyy): ");
            String novaDataConsultaStr = scanner.nextLine();
            Date novaDataConsulta = parseDate(novaDataConsultaStr);
            System.out.print("Novo ID do Animal: ");
            int novoIdAnimal = Integer.parseInt(scanner.nextLine());
            System.out.print("Novo ID do Funcionário: ");
            int novoIdFuncionario = Integer.parseInt(scanner.nextLine());
            System.out.print("Novo ID do Serviço: ");
            int novoIdServico = Integer.parseInt(scanner.nextLine());

            consulta.setDataConsulta(novaDataConsulta);
            consulta.setIdAnimal(novoIdAnimal);
            consulta.setIdFuncionario(novoIdFuncionario);
            consulta.setIdServico(novoIdServico);

            String mensagem = consultaController.atualizarConsulta(consulta);
            System.out.println(mensagem);
        } else {
            System.out.println("Consulta não encontrada!");
        }
    }

    public void excluirConsulta() {
        System.out.println("Exclusão de Consulta");
        System.out.print("ID da Consulta a ser excluída: ");
        int id = Integer.parseInt(scanner.nextLine());
        String mensagem = consultaController.excluirConsulta(id);
        System.out.println(mensagem);
    }

    public void buscarConsulta() {
        System.out.println("Busca de Consulta");
        System.out.print("ID da Consulta a ser buscada: ");
        int id = Integer.parseInt(scanner.nextLine());
        Consulta consulta = consultaController.buscarConsulta(id);
        if (consulta != null) {
            System.out.println("Consulta encontrada:");
            System.out.println(formatConsulta(consulta));
        } else {
            System.out.println("Consulta não encontrada!");
        }
    }

    public List<Consulta> listarConsultas() {
        System.out.println("Listagem de Consultas");
        List<Consulta> consultas = consultaController.listarConsultas();
        for (Consulta consulta : consultas) {
            System.out.println(formatConsulta(consulta));
        }
        return consultas;
    }

    private Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            return null;
        }
    }

    private String formatConsulta(Consulta consulta) {
        return "ID: " + consulta.getId()
                + ", Data: " + dateFormat.format(consulta.getDataConsulta())
                + ", Animal: " + consulta.getIdAnimal()
                + ", Funcionário: " + consulta.getIdFuncionario()
                + ", Serviço: " + consulta.getIdServico();
    }
}
