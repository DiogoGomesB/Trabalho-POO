package com.biblioteca.controller;

import java.util.List;

import com.biblioteca.model.dao.FuncionarioDAO;
import com.biblioteca.model.entity.Funcionario;

public class FuncionarioController {

    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public String cadastrarFuncionario(Funcionario funcionario) {
        funcionarioDAO.cadastrar(funcionario);
        return "Funcionário cadastrado com sucesso!\n";
    }

    public String atualizarFuncionario(Funcionario funcionario) {
        funcionarioDAO.atualizar(funcionario);
        return "Funcionário atualizado com sucesso!\n";
    }

    public String excluirFuncionario(int id) {
        funcionarioDAO.excluir(id);
        return "Funcionário excluído com sucesso!\n";
    }

    public Funcionario buscarFuncionario(int id) {
        return funcionarioDAO.buscar(id);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.listar();
    }
}
