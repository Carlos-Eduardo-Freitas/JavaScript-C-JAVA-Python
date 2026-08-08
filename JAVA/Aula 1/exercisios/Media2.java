import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        float a = dado.nextFloat();
        float b = dado.nextFloat();
        float c = dado.nextFloat();
        double MEDIA = ((a*2) + (b*3) + (c*5))/(2+3+5);
        System.out.printf("MEDIA = %.1f%n", MEDIA);
    }
        }
