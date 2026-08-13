
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        double A = dado.nextDouble();
        double B = dado.nextDouble();
        double C = dado.nextDouble();
        double Delta =(B*B)-(4*A*C);

        if(A == 0 || Delta < 0){
            System.out.println("Impossivel calcular");
        }else{
            double x1 = (-B+Math.sqrt(Delta))/(2*A);
            double x2 = (-B-Math.sqrt(Delta))/(2*A);
            System.out.printf("R1 = %.5f\n", x1);
            System.out.printf("R2 = %.5f\n", x2);
        }
        dado.close();
    }
}
