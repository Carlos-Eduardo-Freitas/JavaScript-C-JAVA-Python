import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double salary = input.nextDouble();
        double cal = 0;

        if (salary <= 2000.00) {
            System.out.println("Isento");
        } else if (salary <= 3000.00) {
            cal = (salary - 2000.00) * 0.08;
            System.out.printf("R$ %.2f\n", cal);
        } else if (salary <= 4500.00) {
            cal = (1000.00 * 0.08) + ((salary - 3000.00) * 0.18);
            System.out.printf("R$ %.2f\n", cal);
        } else {
            cal = (1000.00 * 0.08) + (1500.00 * 0.18) + ((salary - 4500.00) * 0.28);
            System.out.printf("R$ %.2f\n", cal);
        }
        
        input.close();
    }
}
