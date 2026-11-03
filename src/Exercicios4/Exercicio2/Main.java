package Exercicios4.Exercicio2;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> primo = n -> {
            if (n < 2) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        };

        System.out.println("7 é primo? " + primo.test(7));
        System.out.println("10 é primo? " + primo.test(10));
        System.out.println("1 é primo? " + primo.test(1));
    }
}