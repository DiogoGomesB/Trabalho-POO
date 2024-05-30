package com.biblioteca.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.model.entity.Consulta;

public class ConsultaDAO {

    public ConsultaDAO(Connection connection) {
    }

    public List<Consulta> buscarPorNome(String nome) {
        // Implemente a lógica para buscar consultas por nome
        // Retorna uma lista de consultas
        return new ArrayList<>();
    }

    public void reagendar(int idConsulta, Consulta novaConsulta) {
        // Implemente a lógica para reagendar uma consulta
    }

    public void cancelar(int idConsulta) {
        // Implemente a lógica para cancelar uma consulta
    }

    public Consulta buscar(int idConsulta) {
        // Implemente a lógica para buscar uma consulta por ID
        return null;
    }

    public List<Consulta> listar() {
        // Implemente a lógica para listar todas as consultas
        return new ArrayList<>();
    }

    public void cadastrar(Consulta consulta) {
        // Implemente a lógica para cadastrar uma nova consulta
    }

    public void atualizar(Consulta consulta) {
        // Implemente a lógica para atualizar uma consulta
    }

    public void excluir(int id) {
        // Implemente a lógica para excluir uma consulta
    }
}
