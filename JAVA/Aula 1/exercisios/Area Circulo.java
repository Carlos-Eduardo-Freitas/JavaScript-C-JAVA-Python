import java.util.Locale;
import java.util.Scanner;
 

public class Main {
 
    public static void main(String[] args) throws IOException {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);
        double raio = scanner.nextDouble();
        double PI = 3.14159;
        double area = PI * (raio * raio);
        System.out.printf("A=%.4f%n", area);
        scanner.close();
    
 
    }
 
}
