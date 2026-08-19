import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int[] N = new int[20];
        int aux;
        for (int i = 0; i < N.length; i++) {
            N[i] = dado.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            aux = N[i];
            N[i] = N[19 - i];
            N[19 - i] = aux;
            
        }
        for (int i = 0; i < N.length; i++) {
            System.out.println("N[" + i + "] = " + N[i]);
        }
        dado.close();
    }
}
