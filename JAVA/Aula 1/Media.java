import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        float a = dado.nextFloat();
        float b = dado.nextFloat();
        double MEDIA = ((a*3.5) + (b*7.5)) / (3.5 + 7.5);
        System.out.printf("MEDIA = %.5f%n", MEDIA);
    }

}
