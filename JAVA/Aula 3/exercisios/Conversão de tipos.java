import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);

        System.out.print("Digite o número: ");
        // Leitura como String para poder iterar caractere por caractere
        String numero = dado.next();

        int n = numero.length();
        int decimal = 0;
        int base = 48; // Código ASCII do caractere '0'
        int digito;
        for (int i = 0; i < n; i++) {
            // .charAt(i) pega o caractere e converte automaticamente para o seu valor ASCII ao subtrair
            digito = numero.charAt(i) - base;
            decimal = decimal * 10 + digito;
        }
        System.out.println("Formato decimal: " + decimal);
    }
}
