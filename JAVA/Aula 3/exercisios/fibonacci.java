import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        System.out.println("Número de termos:");
        int n = dado.nextInt();

        int a = 0;
        int b = 1;
        int i = 2;
        int c;

        if (n == 1) {
            System.out.println(a);
        } else {
            System.out.println(a + " " + b);
        }

        while (i < n) {
            c = a + b;
            System.out.println(" " + c);
            a = b;
            b = c;
            i++;
        }
    }
}
