import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        
        System.out.print("Número inteiro decimal: ");
        int n = dado.nextInt();

        // Converte o inteiro para uma String em binário
        String binario = Integer.toBinaryString(n);

        System.out.println("Número binário: " + binario);
        
        dado.close();
    }
}
