package Exercicios4.Exercicio4;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        int soma = numeros.stream()
                .reduce(0, (total, n) -> total + n);

        System.out.println("Soma dos números: " + soma);
    }
}