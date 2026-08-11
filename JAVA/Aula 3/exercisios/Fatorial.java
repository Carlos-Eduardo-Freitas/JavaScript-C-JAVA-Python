import java.util.Scanner;
public class Main{
   public static long fatorial (long n){
            int fator = 1;

            for(int i = 1; i <= n;i++) {
                fator = fator * i;
            }
            return  fator;
    }
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int n = dado.nextInt();
        double x = dado.nextDouble();
        double termo;
        double s = 0;
        int i = 1;
        int sinal = 1;
        for (int j = 0; j < n;j++){
            termo = Math.pow(x, i) / fatorial(i);
            s = s  + sinal * termo;
            i = i + 2;
            sinal = -sinal;
        }
        System.out.println("S = " + s);
    }
}
