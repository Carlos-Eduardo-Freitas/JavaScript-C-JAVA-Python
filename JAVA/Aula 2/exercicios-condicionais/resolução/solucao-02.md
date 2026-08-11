# Solução — Exercício 2: Calculadora de Desconto

```java
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o valor da compra: ");
        double valorCompra = entrada.nextDouble();

        double percentualDesconto;

        if (valorCompra > 1000.0) {
            percentualDesconto = 0.20;
        } else if (valorCompra >= 500.0) {
            percentualDesconto = 0.10;
        } else {
            percentualDesconto = 0.05;
        }

        double desconto = valorCompra * percentualDesconto;
        double valorFinal = valorCompra - desconto;

        System.out.printf("Desconto: R$ %.2f%n", desconto);
        System.out.printf("Valor final: R$ %.2f%n", valorFinal);
    }
}
```

### Explicação

- Declaramos `percentualDesconto` **sem** valor inicial, e decidimos o que ela vale dentro do `if`/`else if`/`else` — assim usamos a mesma variável para o cálculo final, sem repetir a fórmula em cada bloco.
- A ordem das condições vai da maior faixa para a menor: primeiro testamos `> 1000`, depois `>= 500` (que já cobre "entre 500 e 1000", já que valores acima de 1000 foram tratados antes), e por fim o `else` cobre tudo que sobrou (abaixo de 500).
- `%.2f` no `printf` garante que o valor sempre apareça com duas casas decimais, como dinheiro de verdade.

**Teste com R$ 750,00:** cai na faixa `>= 500.0`, desconto de 10% → `R$ 75.00` de desconto, valor final `R$ 675.00`. Bate com o exemplo da questão!
