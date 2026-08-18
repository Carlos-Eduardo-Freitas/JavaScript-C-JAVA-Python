import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int n = dado.nextInt();
        int a = 0;
        int b = 0;
        for (int i = 0; i<n;i++){
            int x = dado.nextInt();
            if (x>=10&&x<=20){
                a++;
            } else if (x<10||x>20) {
                b++;
            }
        }
        System.out.println(a+" in");
        System.out.println(b+" out");
    }
}
