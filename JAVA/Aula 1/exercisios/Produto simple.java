import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int a = dado.nextInt();
        int b = dado.nextInt();
        int PROD = a * b;
        System.out.println("PROD = " + PROD);
    }
}
