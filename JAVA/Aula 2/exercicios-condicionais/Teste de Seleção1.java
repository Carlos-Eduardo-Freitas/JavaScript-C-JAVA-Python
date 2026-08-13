import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        
        int A = dado.nextInt();
        int B = dado.nextInt();
        int C = dado.nextInt();
        int D = dado.nextInt();
        
        // Todas as condições unificadas em um único IF
        if (B > C && D > A && (C + D) > (A + B) && C > 0 && D > 0 && A % 2 == 0) {
            System.out.println("Valores aceitos");
        } else {
            System.out.println("Valores nao aceitos");
        }
        
        dado.close(); 
    }
}
