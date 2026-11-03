package Exercicios1.Exercicio2;

public class Cachorro extends Animal {

    public Cachorro(String nome) {
        super(nome, "Au au!");
    }

    public void fazerSom() {
        System.out.println(som);
    }
}