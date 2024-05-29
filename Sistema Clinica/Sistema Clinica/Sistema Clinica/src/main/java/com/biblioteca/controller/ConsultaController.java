package com.biblioteca.controller;

import java.util.List;

import com.biblioteca.model.dao.ConsultaDAO;
import com.biblioteca.model.entity.Consulta;

public class ConsultaController {

    private final ConsultaDAO consultaDAO;

    public ConsultaController(ConsultaDAO consultaDAO) {
        this.consultaDAO = consultaDAO;
    }

    public List<Consulta> buscarConsultasPorNome(String nome) {
        return consultaDAO.buscarPorNome(nome);
    }

    public String reagendarConsulta(int idConsulta, Consulta novaConsulta) {
        consultaDAO.reagendar(idConsulta, novaConsulta);
        return "Consulta reagendada com sucesso!";
    }

    public String cancelarConsulta(int idConsulta) {
        consultaDAO.cancelar(idConsulta);
        return "Consulta cancelada com sucesso!";
    }

    public Consulta buscarConsulta(int idConsulta) {
        return consultaDAO.buscar(idConsulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaDAO.listar();
    }

    public String cadastrarConsulta(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String atualizarConsulta(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String excluirConsulta(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
