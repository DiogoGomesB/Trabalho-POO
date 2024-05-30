package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.model.entity.Funcionario;

public class FuncionarioDAO {

    private Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (id, nome, cargo) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setInt(3, funcionario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Funcionario buscar(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarFuncionario(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                funcionarios.add(criarFuncionario(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    private Funcionario criarFuncionario(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(rs.getInt("id"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setCargo(rs.getString("cargo"));
        return funcionario;
    }
}
