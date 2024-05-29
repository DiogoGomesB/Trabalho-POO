package com.biblioteca.controller;

import java.util.List;

import com.biblioteca.model.dao.AnimalDAO;
import com.biblioteca.model.entity.Animal;

public class AnimalController {

    private final AnimalDAO animalDAO;

    public AnimalController(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public String cadastrarAnimal(Animal animal) {
        animalDAO.cadastrar(animal);
        return "Animal cadastrado com sucesso!";
    }

    public String atualizarAnimal(Animal animal) {
        animalDAO.atualizar(animal);
        return "Animal atualizado com sucesso!";
    }

    public String excluirAnimal(int id) {
        animalDAO.excluir(id);
        return "Animal excluído com sucesso!";
    }

    public Animal buscarAnimal(int id) {
        return animalDAO.buscar(id);
    }

    public List<Animal> listarAnimais() {
        return animalDAO.listar();
    }

}
