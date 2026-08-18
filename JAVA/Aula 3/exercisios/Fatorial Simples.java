import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int n = dado.nextInt();
        int fator = 1;
        for(int i = 1;i <= n;i++){
            fator = fator * i;
        }
        System.out.println(fator);
    }
}
