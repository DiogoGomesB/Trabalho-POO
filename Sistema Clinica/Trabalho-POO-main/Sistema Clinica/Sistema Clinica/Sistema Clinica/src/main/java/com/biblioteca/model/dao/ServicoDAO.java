package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.model.entity.Servico;

public class ServicoDAO {

    private Connection connection;

    public ServicoDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Servico servico) {
        String sql = "INSERT INTO servico (id, descricao, preco) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, servico.getId());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Servico servico) {
        String sql = "UPDATE servico SET descricao = ?, preco = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getPreco());
            stmt.setInt(3, servico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM servico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Servico buscar(int id) {
        String sql = "SELECT * FROM servico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarServico(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Servico> listar() {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM servico";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                servicos.add(criarServico(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicos;
    }

    private Servico criarServico(ResultSet rs) throws SQLException {
        Servico servico = new Servico();
        servico.setId(rs.getInt("id"));
        servico.setDescricao(rs.getString("descricao"));
        servico.setPreco(rs.getDouble("preco"));
        return servico;
    }
}
