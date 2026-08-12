import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        
        System.out.print("Número inteiro decimal: ");
        int n = dado.nextInt();

        int q = n;
        int ndigit = 0;
        int r;
        int[] binario = new int[32]; // Suporta inteiros de até 32 bits

        do {
            r = q % 2;
            binario[ndigit] = r;
            ndigit = ndigit + 1;
            q = q / 2; // Divisão de inteiros no Java já trunca o resultado
        } while (q != 0);

        System.out.print("Número binário: ");

        for (int i = ndigit - 1; i >= 0; i--) {
            System.out.print(binario[i]);
        }
        
        System.out.println(); // Pula uma linha no final
        dado.close();
    }
}
