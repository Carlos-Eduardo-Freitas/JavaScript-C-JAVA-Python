import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        float[] A = new float[100];
        for (int i = 0; i < A.length; i++) {
            A[i] = dado.nextFloat();
            if (A[i] <= 10){
                System.out.printf("A[%d] = %.1f\n",i,A[i]);
            }
        }

    }
}
