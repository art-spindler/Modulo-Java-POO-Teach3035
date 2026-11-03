package Exercicios3.Exercicio5;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);
        numeros.add(9);
        numeros.add(10);

        numeros.removeIf(numero -> numero % 2 == 0);

        System.out.println("Números ímpares: " + numeros);

        HashSet<Integer> conjunto = new HashSet<>(numeros);

        System.out.println("HashSet: " + conjunto);

        int numeroProcurado = 5;

        if (conjunto.contains(numeroProcurado)) {
            System.out.println(numeroProcurado + " está no conjunto!");
        } else {
            System.out.println(numeroProcurado + " não está no conjunto!");
        }
    }
}