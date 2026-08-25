import java.util.Scanner;

public class Main {
    public static int MDC(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return MDC(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int N1, N2, D1, D2;
        char s, s2, s3;

        for (int i = 0; i < N; i++) {
            N1 = input.nextInt();
            s = input.next().charAt(0);
            D1 = input.nextInt();
            s2 = input.next().charAt(0);
            N2 = input.nextInt();
            s3 = input.next().charAt(0);
            D2 = input.nextInt();

            int numResultado;
            int denResultado;

            if (s2 == '+') {
                numResultado = N1 * D2 + N2 * D1;
                denResultado = D1 * D2;
            } else if (s2 == '-') {
                numResultado = N1 * D2 - N2 * D1;
                denResultado = D1 * D2;
            } else if (s2 == '*') {
                numResultado = N1 * N2;
                denResultado = D1 * D2;
            } else if (s2 == '/') {
                numResultado = N1 * D2;
                denResultado = N2 * D1;
            } else {
                System.out.println("Invalid input");
                continue;
            }

            int mdc = MDC(Math.abs(numResultado), Math.abs(denResultado));
            int numSimplificado = numResultado / mdc;
            int denSimplificado = denResultado / mdc;

            System.out.println(numResultado + "/" + denResultado + " = " + numSimplificado + "/" + denSimplificado);
        }
    }
}
