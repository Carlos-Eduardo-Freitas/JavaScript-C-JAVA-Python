import java.util.Scanner; // Importação necessária para ler dados [2]

public class Main {
    public static void main(String[] args) {
        // Inicializa o Scanner para ler da entrada padrão (teclado) [2]
        Scanner sc = new Scanner(System.in);
        
        // Lê os dois valores inteiros [5, 6]
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        // Efetua a soma [7, 8]
        int X = A + B;
        
        // Imprime o resultado exatamente como pedido, com espaços e quebra de linha [1, 9]
        System.out.println("X = " + X);
        
        sc.close(); // Boa prática: fechar o scanner para liberar recursos [10]
    }
}
