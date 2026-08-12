import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);

        int n = dado.nextInt();
        int nota;
        int contagem = 0;
        int i = 0;

        while (i < n) {
            i = i + 1;

            nota = dado.nextInt();

            if (nota >= 50) {
                contagem = contagem + 1;
            }
        }

        System.out.println("Número de aprovações: " + contagem);
    }
}
