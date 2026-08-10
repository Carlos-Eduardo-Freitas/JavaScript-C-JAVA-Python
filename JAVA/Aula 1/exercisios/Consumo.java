import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int x = dado.nextInt();
        double y = dado.nextDouble();
        double c = x/y;
        System.out.printf("%.3f km/l%n", c);

    }
}
