import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int h = dado.nextInt();
        double v = dado.nextInt();
        double distancia = v * h;
        double litros = distancia/ 12.0;
        System.out.printf("%.3f%n", litros);

    }
}
