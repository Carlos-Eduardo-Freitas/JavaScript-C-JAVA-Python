import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int n = dado.nextInt();
        int numero;
        int soma = 0;
        int i = 0;

        while (i < n) {
            i += 1;
            numero = dado.nextInt();
            soma = soma + numero;
        }

        System.out.print("Soma = " + soma);
    }
}
