import java.util.Scanner;
public class gh {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int anos = 0, meses = 0, dias;
        int time = dado.nextInt();
        int out = time;

        while (out >= 365) {
            out -= 365;
            anos++;
        }

        while (out >= 30) {
            out -= 30;
            meses++;
        }

        dias = out;
        System.out.println(anos+" ano(s)");
        System.out.println(meses+" mes(es)");
        System.out.println(dias+" dia(s)");
    }
}
