import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int horainicial = input.nextInt();
        int horafinal = input.nextInt();
        int novodia;
        if (horainicial > horafinal) {
            novodia = 24 - horainicial + horafinal;
        } else if (horainicial < horafinal) {
            novodia = horafinal - horainicial;
        } else {
            novodia = 24;
        }
        System.out.println("O JOGO DUROU "+novodia+" HORA(S)");
    }
}
