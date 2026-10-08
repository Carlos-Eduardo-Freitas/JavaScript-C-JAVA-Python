import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Escolha o tipo de objeto:");
        System.out.println("1 - Polígono Regular Genérico");
        System.out.println("2 - Triângulo Equilátero");
        System.out.println("3 - Quadrado");
        int opcao = input.nextInt();

        System.out.print("Digite o tamanho do lado: ");
        double tamanhoLado = input.nextDouble();

        // Uso de Polimorfismo: A referência é genérica, o objeto é específico
        PolReg poligono = null;

        if (opcao == 1) {
            System.out.print("Digite o número de lados: ");
            int lados = input.nextInt();
            poligono = new PolReg(lados, tamanhoLado);
        } else if (opcao == 2) {
            poligono = new TrianguloEq(tamanhoLado);
        } else if (opcao == 3) {
            poligono = new Quadrado(tamanhoLado);
        } else {
            System.out.println("Opção inválida!");
            input.close();
            return;
        }

        System.out.println("\n--- RESULTADOS ---");
        System.out.printf("Perímetro: %.2f\n", poligono.calcularPerimetro());
        System.out.printf("Ângulo Interno: %.2f graus\n", poligono.calcularAnguloInterno());
        System.out.printf("Área: %.2f\n", poligono.calcularArea());

        input.close();
    }
}

class PolReg {
    private int numLados;
    private double tamLados; // Corrigido de quantLados para tamLados

    public PolReg(int numLados, double tamLados){
        this.numLados = numLados;
        this.tamLados = tamLados;
    }

    public int getNumLados(){
        return numLados;
    }

    public void setNumLados(int numLados){
        if(numLados > 0){
            this.numLados = numLados;
        }
    }

    public double getTamLados() {
        return tamLados;
    }

    public void setTamLados(double tamLados){
        if (tamLados > 0){
            this.tamLados = tamLados;
        }
    }

    public double calcularPerimetro(){
        return numLados * tamLados;
    }

    public double calcularAnguloInterno(){
        return ((numLados - 2) * 180.0) / numLados;
    }

    public double calcularArea(){
        return 0.0;
    }
}

// Corrigido de Triangulo para TrianguloEq
class TrianguloEq extends PolReg {
    public TrianguloEq(double tamLados){
        super(3, tamLados);
    }

    @Override
    public double calcularArea() {
        double lado = getTamLados();
        return (Math.pow(lado, 2) * Math.sqrt(3)) / 4.0;
    }
}

class Quadrado extends PolReg {
    public Quadrado(double tamLados) {
        super(4, tamLados);
    }

    @Override
    public double calcularArea(){
        double lado = getTamLados();
        return Math.pow(lado, 2);
    }
}
