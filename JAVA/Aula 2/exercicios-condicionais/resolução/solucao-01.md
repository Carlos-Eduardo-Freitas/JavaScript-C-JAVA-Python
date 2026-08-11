# Solução — Exercício 1: Classificando um Triângulo

```java
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o 1º lado: ");
        double ladoA = entrada.nextDouble();

        System.out.print("Digite o 2º lado: ");
        double ladoB = entrada.nextDouble();

        System.out.print("Digite o 3º lado: ");
        double ladoC = entrada.nextDouble();

        if (ladoA == ladoB && ladoB == ladoC) {
            System.out.println("Triângulo Equilátero");
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            System.out.println("Triângulo Isósceles");
        } else {
            System.out.println("Triângulo Escaleno");
        }
    }
}
```

### Explicação

- Primeiro testamos a condição mais restritiva: **os três lados iguais** (`ladoA == ladoB && ladoB == ladoC`). Se isso for verdade, já sabemos que é Equilátero, sem precisar checar mais nada.
- Se não for equilátero, testamos se **pelo menos dois** lados são iguais, usando `||` — basta um dos três pares bater para ser Isósceles.
- Se nenhuma das duas condições anteriores for verdadeira, só resta uma possibilidade: todos os lados são diferentes, ou seja, Escaleno.

> **Por que a ordem importa?** Se tivéssemos testado "Isósceles" antes de "Equilátero", um triângulo equilátero (que também tem pares de lados iguais) seria classificado errado como Isósceles. Sempre testamos do caso mais específico para o mais genérico.
