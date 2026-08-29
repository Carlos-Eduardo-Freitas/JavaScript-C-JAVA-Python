import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int horainicial = input.nextInt();
        int minutainicial = input.nextInt();
        int horafinal = input.nextInt();
        int minutafinal = input.nextInt();

        int inicioTotal = horainicial * 60 + minutainicial;
        int fimTotal = horafinal * 60 + minutafinal;

        int duracao = fimTotal - inicioTotal;
        if (duracao <= 0) {
            duracao += 24 * 60; // virou o dia (ou durou 24h exatas)
        }

        int novodia = duracao / 60;
        int novominuta = duracao % 60;

        System.out.println("O JOGO DUROU " + novodia + " HORA(S) E " + novominuta + " MINUTO(S)");
    }
}
