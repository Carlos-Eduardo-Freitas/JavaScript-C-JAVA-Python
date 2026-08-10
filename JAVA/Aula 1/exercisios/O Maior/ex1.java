import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int a = dado.nextInt(), b = dado.nextInt(), c = dado.nextInt();

        int maiorAB = (a + b + Math.abs(a - b)) / 2;      // maior entre a e b
        int maiorFinal = (maiorAB + c + Math.abs(maiorAB - c)) / 2; // maior entre esse resultado e c

        System.out.println(maiorFinal + " eh o maior");
    }
}
