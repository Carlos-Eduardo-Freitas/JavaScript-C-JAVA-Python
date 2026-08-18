import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int maior = -1;
        int posicao = 0;

        for (int i = 1; i <= 100; i++) {
            int num = input.nextInt();

            if (num > maior) {
                maior = num;
                posicao = i;
            }
        }

        System.out.println(maior);
        System.out.println(posicao);
    }
}
