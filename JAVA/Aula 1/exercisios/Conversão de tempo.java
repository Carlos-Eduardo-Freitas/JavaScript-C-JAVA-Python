import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    Scanner dado = new Scanner(System.in);
    int time = dado.nextInt();
    int out = time;
    int hours = out/3600;
    out = out % 3600;
    int minutes = out/60;
    out = out % 60;
    int seconds = out/1;
    out = out % 1;
    System.out.println(hours+":"+minutes+":"+seconds);


    }

}
