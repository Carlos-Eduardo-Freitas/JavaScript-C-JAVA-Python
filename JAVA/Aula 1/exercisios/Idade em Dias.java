import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int time = dado.nextInt();
        int out = time;
        int year = out/365;
        out = out % 365;
        int month = out/30;
        out = out % 30;
        int days = out/1;
        out = out % 1;
        System.out.println(year+" ano(s)");
        System.out.println(month+" mes(es)");
        System.out.println(days+" dia(s)");


    }

}
