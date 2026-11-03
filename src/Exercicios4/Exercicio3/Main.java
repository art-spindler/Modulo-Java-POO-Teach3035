package Exercicios4.Exercicio3;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList(
                "java", "lambda", "stream", "programacao"
        );

        List<String> maiusculas = palavras.stream()
                .map(p -> p.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Palavras em maiúsculas: " + maiusculas);
    }
}