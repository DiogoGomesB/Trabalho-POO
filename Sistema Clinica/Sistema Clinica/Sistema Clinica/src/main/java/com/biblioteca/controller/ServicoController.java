package com.biblioteca.controller;

import java.util.List;

import com.biblioteca.model.dao.ServicoDAO;
import com.biblioteca.model.entity.Servico;

public class ServicoController {

    private final ServicoDAO servicoDAO;

    public ServicoController(ServicoDAO servicoDAO) {
        this.servicoDAO = servicoDAO;
    }

    public String cadastrarServico(Servico servico) {
        servicoDAO.cadastrar(servico);
        return "Serviço cadastrado com sucesso!";
    }

    public String atualizarServico(Servico servico) {
        servicoDAO.atualizar(servico);
        return "Serviço atualizado com sucesso!";
    }

    public String excluirServico(int id) {
        servicoDAO.excluir(id);
        return "Serviço excluído com sucesso!";
    }

    public Servico buscarServico(int id) {
        return servicoDAO.buscar(id);
    }

    public List<Servico> listarServicos() {
        return servicoDAO.listar();
    }
}
