import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double salario = input.nextDouble();
        double ganho = 0;
        int[] percentual = {15, 12, 10, 7, 4};
        int p = 0;
        if (salario <= 400.00){
            p = percentual[0];
            ganho = (salario * p)/100;
            salario = salario + ganho;
        } else if (salario <= 800.00) {
            p = percentual[1];
            ganho = (salario * p)/100;
            salario = salario + ganho;

        } else if (salario<=1200.00) {
            p = percentual[2];
            ganho = (salario * p)/100;
            salario = salario + ganho;

        }else if (salario<=2000.00) {
            p = percentual[3];
            ganho = (salario * p)/100;
            salario = salario + ganho;
        }else{
            p = percentual[4];
            ganho = (salario * p)/100;
            salario = salario + ganho;
        }
        System.out.printf("Novo salario: %.2f%n",salario);
        System.out.printf("Reajuste ganho: %.2f%n",ganho);
        System.out.println("Em percentual: "+p+" %" );
    }
}
