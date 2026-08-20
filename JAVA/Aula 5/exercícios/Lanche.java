import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int cod = dado.nextInt();
        int n = dado.nextInt();
        double[] precos = {4.00,4.50,5.00,2.00,1.50};
        double total;
            if (cod >= 1 && cod <= 5) {
                total = precos[cod-1] * n;
            } else {
                total = 0;
            }
        System.out.printf("Total: R$ %.2f%n",total);
    }
}
