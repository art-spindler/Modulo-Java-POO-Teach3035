package Exercicios3.Exercicio4;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> palavras = new ArrayList<>();

        palavras.add("Java");
        palavras.add("Python");
        palavras.add("HTML");
        palavras.add("CSS");
        palavras.add("JavaScript");

        HashSet<String> conjunto = new HashSet<>(palavras);

        System.out.println("Elementos do HashSet:");
        for (String palavra : conjunto) {
            System.out.println(palavra);
        }

        ArrayList<String> novaLista = new ArrayList<>(conjunto);

        System.out.println("\nElementos do ArrayList resultante:");
        for (String palavra : novaLista) {
            System.out.println(palavra);
        }
    }
}