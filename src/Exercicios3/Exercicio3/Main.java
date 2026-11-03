package Exercicios3.Exercicio3;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        HashSet<Integer> conjunto = new HashSet<>();

        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.add(50);

        conjunto.add(10);
        conjunto.add(20);
        conjunto.add(30);
        conjunto.add(40);
        conjunto.add(50);

        System.out.println("Elementos do ArrayList:");
        for (int numero : lista) {
            System.out.println(numero);
        }

        System.out.println("Elementos do HashSet:");
        for (int numero : conjunto) {
            System.out.println(numero);
        }
    }
}