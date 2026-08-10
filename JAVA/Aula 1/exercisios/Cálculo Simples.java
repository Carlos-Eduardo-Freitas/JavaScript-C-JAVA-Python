import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int c1 = dado.nextInt(), q1 = dado.nextInt();
        double p1 = dado.nextDouble();
        int c2 = dado.nextInt(), q2 = dado.nextInt();
        double p2 = dado.nextDouble();
        double v = (q1 * p1) + (q2 * p2);
        System.out.printf("VALOR A PAGAR: R$ %.2f%n",v);

    }
}
