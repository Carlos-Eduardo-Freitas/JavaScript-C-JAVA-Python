import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int a = dado.nextInt(), b = dado.nextInt(), c = dado.nextInt();
        
        int maior = a;
        if (b > maior) {
            maior = b;
        }
        if (c > maior) {
            maior = c;
        }
        
        System.out.println(maior + " eh o maior");
    }
}
