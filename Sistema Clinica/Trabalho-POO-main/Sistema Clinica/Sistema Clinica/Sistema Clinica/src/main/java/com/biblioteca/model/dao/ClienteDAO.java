package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.model.entity.Cliente;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Cliente cliente) { 
        String sql = "INSERT INTO cliente (id, nome, endereco, telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscar(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarCliente(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(criarCliente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    private Cliente criarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setEndereco(rs.getString("endereco"));
        cliente.setTelefone(rs.getString("telefone"));
        return cliente;
    }
}
