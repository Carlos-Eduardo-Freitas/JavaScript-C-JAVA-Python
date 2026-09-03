import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       double n;
       int cont = 0;
       for (int i = 1; i <= 6; i++) {
           n =  input.nextDouble();
           if(n>0) {
               cont++;
           }
       }
       System.out.println(cont+" valores positivos");
    }
}
