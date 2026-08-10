import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    Scanner dado = new Scanner(System.in);
      int  NUMBER = dado.nextInt();
      int HOURS = dado.nextInt();
      double Winner = dado.nextDouble();
      double SALARY = HOURS * Winner;
      System.out.println("NUMBER = " + NUMBER );
        System.out.printf("SALARY = U$ %.2f%n", SALARY);
    }
}
