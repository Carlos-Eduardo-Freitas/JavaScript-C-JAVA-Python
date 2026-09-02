import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nc = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int c = 1; c <= nc; c++) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            long res = 0; // J(1) = 0
            for (long i = 2; i <= n; i++) {
                res = (res + k) % i;
            }

            sb.append("Case ").append(c).append(": ").append(res + 1).append("\n");
        }

        System.out.print(sb);
    }
}
