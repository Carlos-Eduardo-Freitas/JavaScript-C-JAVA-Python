import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(){
        Scanner dado = new Scanner(System.in);
        int[] v  = {20, 35, 18, 8, 14, 41, 3, 39};
        System.out.println(Arrays.toString(v));
        int aux;
        for (int i = 0; i < v.length-1; i++) {
            for (int j = 0; j < v.length-1-i; j++) {
                if (v[j] > v[j + 1]) {
                    aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }
        System.out.println(Arrays.toString(v));
    }

}
