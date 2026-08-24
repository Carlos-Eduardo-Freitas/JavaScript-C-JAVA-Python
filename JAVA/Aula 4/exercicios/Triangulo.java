import java.util.Scanner;

public class Main {
    public static boolean ehValido(double a, double b, double c) {
        boolean cond1 = (Math.abs(b - c) < a) && (a < (c + b));
        boolean cond2 = (Math.abs(a - c) < b) && (b < (a + c));
        boolean cond3 = (Math.abs(a - b) < c) && (c < (a + b));

        return cond1 && cond2 && cond3;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double A = input.nextDouble();
        double B = input.nextDouble();
        double C = input.nextDouble();
            System.out.println(ehValido(A,B,C) ? "Perimetro = "+(A+B+C) : "Area = "+(((A+B)*C)/2));
        }
    }
