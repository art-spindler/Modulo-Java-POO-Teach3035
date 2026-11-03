package Exercicios1.Exercicio2;

public class Gato extends Animal {

    public Gato(String nome) {
        super(nome, "Miau!");
    }

    public void fazerSom() {
        System.out.println(som);
    }
}