import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    Scanner dado = new Scanner(System.in);
    int numero = dado.nextInt();
    for(int i = 1;i<=10;i++){
        int resultado = numero * i;
        System.out.println(i+" x "+numero+" = "+resultado);
    }
    }
}
