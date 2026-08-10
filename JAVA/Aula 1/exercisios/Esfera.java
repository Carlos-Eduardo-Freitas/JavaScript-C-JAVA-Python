import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        double r = dado.nextInt();
        double pi = 3.14159;
        double v = (4.0/3) * pi * (r*r*r);
        System.out.printf("VOLUME = %.3f%n", v);
    }
}
