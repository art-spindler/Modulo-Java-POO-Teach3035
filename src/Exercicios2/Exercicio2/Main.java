package Exercicios2.Exercicio2;

public class Main {
    public static void main(String[] args) {
        String texto = "123";

        try {
            int numero = Integer.parseInt(texto);
            System.out.println("Número convertido: " + numero);

        } catch (NumberFormatException e) {
            System.out.println("Erro: a string não contém um número inteiro válido!");

        } finally {
            System.out.println("Bloco finally executado!");
        }
    }
}