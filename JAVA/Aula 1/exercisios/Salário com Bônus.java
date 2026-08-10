import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        String nome = dado.next();
        double SalárioFixo  = dado.nextDouble();
        double vendas = dado.nextDouble() ;
        double total = SalárioFixo + (vendas * 15)/100;
        System.out.printf("TOTAL = R$ %.2f%n", total);
    }
}
