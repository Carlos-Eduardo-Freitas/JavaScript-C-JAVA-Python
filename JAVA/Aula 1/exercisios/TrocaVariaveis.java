import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        System.out.println("Informe valor para a variável A: ");
        int a = dado.nextInt();
        System.out.println("Informe valor para a variável B: ");
        int b = dado.nextInt();
        int c;

        c = a;
        a = b;
        b = c;
        System.out.println("Novo valor da variável A: " + a);
        System.out.println("Novo valor da variável B: " + b);
    }
}
