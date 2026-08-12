import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int saque = dado.nextInt();
        int saldo = saque;
        int notas100 = saldo / 100;
        saldo = saldo % 100;
        int notas50 = saldo / 50;
        saldo = saldo % 50;
        int notas20 = saldo / 20;
        saldo = saldo % 20;
        int notas10 = saldo / 10;
        saldo = saldo % 10;
        int notas5 = saldo / 5;
        saldo = saldo % 5;
        int notas2 = saldo / 2;
        saldo = saldo % 2;
        int notas1 = saldo / 1;
        saldo = saldo % 1;
        System.out.println(saque);
        System.out.println(notas100+" nota(s) de R$ 100,00");
        System.out.println(notas50+" nota(s) de R$ 50,00");
        System.out.println(notas20+" nota(s) de R$ 20,00");
        System.out.println(notas10+" nota(s) de R$ 10,00");
        System.out.println(notas5+" nota(s) de R$ 5,00");
        System.out.println(notas2+" nota(s) de R$ 2,00");
        System.out.println(notas1+" nota(s) de R$ 1,00");

    }

}
