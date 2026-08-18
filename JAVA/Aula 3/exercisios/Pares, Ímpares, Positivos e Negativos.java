import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner dado  =new Scanner(System.in);
        int numeros;
        int pos = 0;
        int par = 0;
        int neg = 0;
        int imp = 0;
        for (int i = 0;i < 5;i++) {
            numeros = dado.nextInt();
            if (numeros>0){
                pos++ ;
                if (numeros % 2 == 0){
                    par++ ;
                }else{
                    imp++ ;
                }
            } else if (numeros<0) {
                neg++;
                if (numeros % 2 == 0){
                    par++;
                }else{
                    imp++;
                }
            } else if (numeros == 0) {
                par++;
            }else{
                System.out.println("Numero Invalido");
            }
        }
        System.out.println(par+" valor(es) par(es)");
        System.out.println(imp+" valor(es) impar(es)");
        System.out.println(pos+" valor(es) positivo(s)");
        System.out.println(neg+" valor(es) negativo(s)");

    }
}
