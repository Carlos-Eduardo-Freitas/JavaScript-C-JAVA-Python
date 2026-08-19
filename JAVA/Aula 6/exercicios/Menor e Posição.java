import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Lê o tamanho do vetor
        int n = entrada.nextInt();
        int[] x = new int[n];

        // Lemos o primeiro valor separadamente para inicializar a variável "menor"
        x[0] = entrada.nextInt();
        int menorValor = x[0];
        int posicao = 0;

        // Lemos o restante do vetor a partir da posição 1
        for (int i = 1; i < n; i++) {
            x[i] = entrada.nextInt();
            
            // Atualiza o menor valor e a posição se encontrar um número menor
            if (x[i] < menorValor) {
                menorValor = x[i];
                posicao = i;
            }
        }

        // Exibe o resultado exatamente no formato exigido
        System.out.println("Menor valor: " + menorValor);
        System.out.println("Posicao: " + posicao);

        entrada.close();
    }
}
