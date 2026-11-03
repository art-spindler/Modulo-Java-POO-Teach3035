package Exercicios3.Exercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> frutas = new ArrayList<>();

        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Uva");
        frutas.add("Morango");


        System.out.println("Tamanho da lista: " + frutas.size());


        System.out.println("Terceira fruta: " + frutas.get(2));


        frutas.remove(0);


        if (frutas.contains("Uva")) {
            System.out.println("Uva está na lista!");
        } else {
            System.out.println("Uva não está na lista!");
        }


        System.out.println("Frutas restantes:");

        for (String fruta : frutas) {
            System.out.println(fruta);
        }
    }
}