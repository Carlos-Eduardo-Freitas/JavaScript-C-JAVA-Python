import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1 = input.nextDouble();
        double n2 = input.nextDouble();
        double n3 = input.nextDouble();
        double n4 = input.nextDouble();

        double media = ((n1 * 2) + (n2 * 3) + (n3 * 4) + (n4 * 1)) / 10;
        System.out.printf("Media: %.1f%n", media);

        if (media >= 7) {
            System.out.println("Aluno aprovado.");
        } else if (media >= 5) {
            System.out.println("Aluno em exame.");
            double n5 = input.nextDouble();
            System.out.println("Nota do exame: " + n5);

            double mediaFinal = (n5 + media) / 2.0;
            System.out.println(mediaFinal >= 5 ? "Aluno aprovado." : "Aluno reprovado.");
            System.out.printf("Media final: %.1f%n", mediaFinal);
        } else {
            System.out.println("Aluno reprovado.");
        }
    }
}
