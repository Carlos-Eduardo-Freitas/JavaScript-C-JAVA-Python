import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner dado = new Scanner(System.in);
        int A = dado.nextInt();
        int B = dado.nextInt();
        System.out.println(A%B == 0 || B%A == 0 ? "Sao Multiplos" : "Nao sao Multiplos");
    }
}
