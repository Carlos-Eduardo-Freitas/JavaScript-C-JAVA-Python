import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int pos = 0;
        double soma = 0;

        for (int i = 0; i < 6; i++) {
            double ent = dado.nextDouble();
            if (ent > 0) {
                pos++;
                soma += ent;
            }
        }

        double media = soma / pos;

        System.out.println(pos+" valores positivos");
        System.out.printf("%.1f%n", media);
    }
}
