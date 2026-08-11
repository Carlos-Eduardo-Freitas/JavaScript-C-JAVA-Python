import java.util.Scanner;
import java.lang.Math;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        double x1 = dado.nextDouble();
        double y1 = dado.nextDouble();
        double x2 = dado.nextDouble();
        double y2 = dado.nextDouble();
        double Distacia = Math.sqrt((x2 - x1)*(x2 - x1)+(y2 -y1)*(y2 -y1));
        System.out.printf("%.4f%n",Distacia);


    }
}
