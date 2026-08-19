import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int n = dado.nextInt();
        int cont;
        for (int i = 0; i < n; i++) {
            int num = dado.nextInt();
            cont = 0;
            if (num == 2) {
                System.out.println(num + " eh primo");
            } else if (num==0||num==1) {
                System.out.println(num+" nao eh primo");
            } else {
                for (int j = 2; j <= num; j++) {
                    if (j != num && num%j ==0) {
                        cont++;
                    }
                }
                if (cont>0){
                    System.out.println(num+" nao eh primo");
                }else{
                    System.out.println(num + " eh primo");
                }
            }
        }
    }
}
