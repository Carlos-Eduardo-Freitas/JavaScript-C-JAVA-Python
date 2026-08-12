import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int saque = dado.nextInt();
        int saldo = saque;

        int notas100 = 0, notas50 = 0, notas20 = 0, notas10 = 0, notas5 = 0, notas2 = 0, notas1 = 0;

        while (saldo >= 100) {
            saldo = saldo - 100;
            notas100++;
        }

        while (saldo >= 50) {
            saldo = saldo - 50;
            notas50++;
        }
        while (saldo >= 20) {
            saldo = saldo - 20;
            notas20++;
        }
        while (saldo >= 10) {
            saldo = saldo - 10;
            notas10++;
        }
        while (saldo >= 5) {
            saldo = saldo - 5;
            notas5++;
        }
        while (saldo >= 2) {
            saldo = saldo - 2;
            notas2++;
        }
        while (saldo >= 1) {
            saldo = saldo - 1;
            notas1++;
        }
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
