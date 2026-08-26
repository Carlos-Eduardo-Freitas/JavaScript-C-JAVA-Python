import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double salario = input.nextDouble();
        int p;

        if (salario <= 400.00) {
            p = 15;
        } else if (salario <= 800.00) {
            p = 12;
        } else if (salario <= 1200.00) {
            p = 10;
        } else if (salario <= 2000.00) {
            p = 7;
        } else {
            p = 4;
        }

        double ganho = salario * p / 100;
        double novoSalario = salario + ganho;

        System.out.printf("Novo salario: %.2f%n", novoSalario);
        System.out.printf("Reajuste ganho: %.2f%n", ganho);
        System.out.println("Em percentual: " + p + " %");
    }
}
