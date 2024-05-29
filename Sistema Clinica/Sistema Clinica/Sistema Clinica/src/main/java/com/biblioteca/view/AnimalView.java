package com.biblioteca.view;

import java.util.Scanner;

import com.biblioteca.controller.AnimalController;
import com.biblioteca.model.entity.Animal;

public class AnimalView {

    private final AnimalController animalController;
    private final Scanner scanner;

    public AnimalView(AnimalController animalController, Scanner scanner) {
        this.animalController = animalController;
        this.scanner = scanner;
    }

    public void cadastrarAnimal() {
        System.out.println("Cadastro de Animal");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        System.out.print("Sexo (M/F): ");
        char sexo = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("ID do Cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());

        Animal animal = new Animal(0, nome, raca, sexo, tipo, idCliente);
        String mensagem = animalController.cadastrarAnimal(animal);
        System.out.println(mensagem);
    }

    public void atualizarAnimal() {
        System.out.println("Atualização de Animal");
        System.out.print("ID do Animal a ser atualizado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Animal animal = animalController.buscarAnimal(id);
        if (animal != null) {
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Nova Raça: ");
            String novaRaca = scanner.nextLine();
            System.out.print("Novo Sexo (M/F): ");
            char novoSexo = scanner.nextLine().toUpperCase().charAt(0);
            System.out.print("Novo Tipo: ");
            String novoTipo = scanner.nextLine();
            System.out.print("Novo ID do Cliente: ");
            int novoIdCliente = Integer.parseInt(scanner.nextLine());

            animal.setNome(novoNome);
            animal.setRaca(novaRaca);
            animal.setSexo(novoSexo);
            animal.setTipo(novoTipo);
            animal.setIdCliente(novoIdCliente);

            String mensagem = animalController.atualizarAnimal(animal);
            System.out.println(mensagem);
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    public void excluirAnimal() {
        System.out.println("Exclusão de Animal");
        System.out.print("ID do Animal a ser excluído: ");
        int id = Integer.parseInt(scanner.nextLine());
        String mensagem = animalController.excluirAnimal(id);
        System.out.println(mensagem);
    }

    public void buscarAnimal() {
        System.out.println("Busca de Animal");
        System.out.print("ID do Animal a ser buscado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Animal animal = animalController.buscarAnimal(id);
        if (animal != null) {
            System.out.println("Animal encontrado:");
            System.out.println(animal);
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    public void listarAnimais() {
        System.out.println("Listagem de Animais");
        for (Animal animal : animalController.listarAnimais()) {
            System.out.println(animal);
        }
    }
}
