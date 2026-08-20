import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int cod = dado.nextInt();
        int n = dado.nextInt();
        double somar = 0;
        double cq = 4.00;
        double xs = 4.50;
        double xb = 5.00;
        double ts = 2.00;
        double refri = 1.50;
        for (int i = 0; i < n; i++) {
            if (cod == 1) {
                somar += cq;
            }else if (cod == 2) {
                somar += xs;
            }else if (cod == 3) {
                somar += xb;
            }else if (cod == 4) {
                somar += ts;
            }else  if (cod == 5) {
                somar += refri;
            }else{
                somar = 0;
            }


        }
        System.out.printf("Total: R$ %.2f%n",somar);
    }
}
