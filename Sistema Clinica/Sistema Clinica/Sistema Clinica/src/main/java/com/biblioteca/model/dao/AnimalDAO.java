package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.model.entity.Animal;

public class AnimalDAO {

    private Connection connection;

    public AnimalDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Animal animal) {
        String sql = "INSERT INTO animal (id, nome, raca, sexo, tipo, id_cliente) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, animal.getId());
            stmt.setString(2, animal.getNome());
            stmt.setString(3, animal.getRaca());
            stmt.setString(4, String.valueOf(animal.getSexo()));
            stmt.setString(5, animal.getTipo());
            stmt.setInt(6, animal.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Animal animal) {
        String sql = "UPDATE animal SET nome = ?, raca = ?, sexo = ?, tipo = ?, id_cliente = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setString(3, String.valueOf(animal.getSexo()));
            stmt.setString(4, animal.getTipo());
            stmt.setInt(5, animal.getIdCliente());
            stmt.setInt(6, animal.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM animal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Animal buscar(int id) {
        String sql = "SELECT * FROM animal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarAnimal(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Animal> listar() {
        List<Animal> animais = new ArrayList<>();
        String sql = "SELECT * FROM animal";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                animais.add(criarAnimal(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
    }

    private Animal criarAnimal(ResultSet rs) throws SQLException {
        Animal animal = new Animal();
        animal.setId(rs.getInt("id"));
        animal.setNome(rs.getString("nome"));
        animal.setRaca(rs.getString("raca"));
        animal.setSexo(rs.getString("sexo").charAt(0));
        animal.setTipo(rs.getString("tipo"));
        animal.setIdCliente(rs.getInt("id_cliente"));
        return animal;
    }
}
