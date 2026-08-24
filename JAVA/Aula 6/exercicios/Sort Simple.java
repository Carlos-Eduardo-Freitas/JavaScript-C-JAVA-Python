import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 1. Ler exatamente os 3 valores inteiros originais
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        // 2. Colocar os valores em um vetor para podermos ordenar
        int[] ordenado = {a, b, c};
        // 3. Usar a função de ordenação nativa do Java (organiza em ordem crescente)
        Arrays.sort(ordenado);
        // 4. Imprimir os valores organizados em ordem crescente
        for (int i = 0; i < 3; i++) {
            System.out.println(ordenado[i]);
        }
        // 5. Imprimir a linha em branco obrigatória exigida pelo problema
        System.out.println();
        // 6. Imprimir os valores na ordem original em que foram digitados
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        input.close();
    }
}
