import java.util.Scanner;
public class tes1 {
    public static void main(String[] args){
        System.out.println("Hello World.");
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();

        System.out.println("Olá, " + nome + "!");

        teclado.close();
    }

}
