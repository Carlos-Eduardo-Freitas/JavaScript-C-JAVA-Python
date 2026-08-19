import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int[] N = new int[20];
        
        // 1. Lê os valores preenchendo o vetor de trás para frente (do índice 19 ao 0)
        for (int i = 19; i >= 0; i--) {
            N[i] = dado.nextInt();
        }
        
        // 2. Imprime o vetor, que agora já está com os valores invertidos
        for (int i = 0; i < N.length; i++) {
            System.out.println("N[" + i + "] = " + N[i]);
        }
        
        dado.close();
    }
}
