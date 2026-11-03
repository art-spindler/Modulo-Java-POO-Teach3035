package Exercicios3.Exercicio2;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashSet<String> cores = new HashSet<>();

        cores.add("Azul");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Preto");

        System.out.println("Tamanho do conjunto: " + cores.size());

        cores.add("Azul");
        System.out.println("Tamanho após adicionar Azul novamente: " + cores.size());

        cores.remove("Verde");

        if (cores.contains("Preto")) {
            System.out.println("Preto está no conjunto!");
        } else {
            System.out.println("Preto não está no conjunto!");
        }

        System.out.println("Cores restantes:");

        for (String cor : cores) {
            System.out.println(cor);
        }
    }
}