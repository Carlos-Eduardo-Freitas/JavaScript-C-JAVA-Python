import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Garante o ponto como separador decimal para o Scanner (ex: 576.73)
        Scanner dado = new Scanner(System.in).useLocale(Locale.US);

        double saque = dado.nextDouble();

        // Converte o valor para centavos inteiros (somando 0.5 para evitar erros de arredondamento)
        int centavos = (int) Math.round(saque * 100);

        System.out.println("NOTAS:");

        int notas100 = centavos / 10000;
        centavos %= 10000;
        System.out.printf("%d nota(s) de R$ 100.00%n", notas100);

        int notas50 = centavos / 5000;
        centavos %= 5000;
        System.out.printf("%d nota(s) de R$ 50.00%n", notas50);

        int notas20 = centavos / 2000;
        centavos %= 2000;
        System.out.printf("%d nota(s) de R$ 20.00%n", notas20);

        int notas10 = centavos / 1000;
        centavos %= 1000;
        System.out.printf("%d nota(s) de R$ 10.00%n", notas10);

        int notas5 = centavos / 500;
        centavos %= 500;
        System.out.printf("%d nota(s) de R$ 5.00%n", notas5);

        int notas2 = centavos / 200;
        centavos %= 200;
        System.out.printf("%d nota(s) de R$ 2.00%n", notas2);

        System.out.println("MOEDAS:");

        int moedas100 = centavos / 100;
        centavos %= 100;
        System.out.printf("%d moeda(s) de R$ 1.00%n", moedas100);

        int moedas50 = centavos / 50;
        centavos %= 50;
        System.out.printf("%d moeda(s) de R$ 0.50%n", moedas50);

        int moedas25 = centavos / 25;
        centavos %= 25;
        System.out.printf("%d moeda(s) de R$ 0.25%n", moedas25);

        int moedas10 = centavos / 10;
        centavos %= 10;
        System.out.printf("%d moeda(s) de R$ 0.10%n", moedas10);

        int moedas5 = centavos / 5;
        centavos %= 5;
        System.out.printf("%d moeda(s) de R$ 0.05%n", moedas5);

        int moedas1 = centavos;
        System.out.printf("%d moeda(s) de R$ 0.01%n", moedas1);

        dado.close();
    }
}
