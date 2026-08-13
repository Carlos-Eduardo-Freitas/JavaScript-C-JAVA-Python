import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        double entrada = dado.nextDouble();

        if (entrada < 0 || entrada > 100) {
            System.out.println("Fora de intervalo");
        } else if (entrada <= 25) {
            System.out.println("Intervalo [0,25]");
        } else if (entrada <= 50) {
            System.out.println("Intervalo (25,50]");
        } else if (entrada <= 75) {
            System.out.println("Intervalo (50,75]");
        } else {
            System.out.println("Intervalo (75,100]");
        }
        
        dado.close();
    }
}
