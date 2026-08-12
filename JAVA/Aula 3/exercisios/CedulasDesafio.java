// Não se preocupe o objetivo aqui é entender oque o while, if, else, else if.
import java.util.Scanner;

public class Main {

    public static int[] calcularNota(int resto, int nota) {
        int qtd = resto / nota;
        int novoResto = resto % nota;
        return new int[]{qtd, novoResto};
    }

    public static int proximaNota(int nota) {
        if (nota == 100) {
            return 50;
        } else if (nota == 50) {
            return 20;
        } else if (nota == 20) {
            return 10;
        } else if (nota == 10) {
            return 5;
        } else if (nota == 5) {
            return 2;
        } else if (nota == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int saque = dado.nextInt();
        System.out.println(saque);

        int resto = saque;
        int nota = 100;

        while (nota != 0) {
            int[] resultado = calcularNota(resto, nota);
            int qtd = resultado[0];
            resto = resultado[1];

            if (qtd > 0) {
                System.out.println(qtd + " nota(s) de R$ " + nota + ",00");
            }

            nota = proximaNota(nota);
        }
    }
}
