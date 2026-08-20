import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int cod = dado.nextInt();
        int n = dado.nextInt();

        double[] precos = {0, 4.00, 4.50, 5.00, 2.00, 1.50};
        double total = (cod >= 1 && cod <= 5) ? precos[cod] * n : 0;

        System.out.printf("Total: R$ %.2f%n", total);
    }
}
