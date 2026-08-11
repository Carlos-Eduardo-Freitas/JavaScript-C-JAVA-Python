# Solução — Exercício 3: Ano Bissexto

```java
import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um ano: ");
        int ano = entrada.nextInt();

        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            System.out.println(ano + " é um ano bissexto.");
        } else {
            System.out.println(ano + " não é um ano bissexto.");
        }
    }
}
```

### Explicação

A regra do ano bissexto tem três partes, e a ordem de avaliação dos operadores importa:

1. `ano % 4 == 0` → o ano precisa ser divisível por 4.
2. `(ano % 100 != 0 || ano % 400 == 0)` → **e** (não pode ser divisível por 100, **a menos que** também seja divisível por 400).

Os parênteses são essenciais aqui: eles garantem que o `||` seja resolvido **antes** de ser combinado com o `&&` externo. Sem os parênteses, o Java ainda respeitaria a precedência (`&&` tem prioridade sobre `||`), mas os parênteses deixam a intenção muito mais clara para quem lê o código.

**Testando com 2024:** `2024 % 4 == 0` (verdadeiro) **e** (`2024 % 100 != 0`, que é verdadeiro, pois 2024 não é múltiplo de 100) → resultado final `true` → **é bissexto**. Bate com o exemplo da questão!

**Testando com 1900:** `1900 % 4 == 0` (verdadeiro), mas `1900 % 100 == 0` (então a primeira parte do `||` é falsa) e `1900 % 400 != 0` (segunda parte também falsa) → resultado final `false` → **não é bissexto**, mesmo sendo divisível por 4. É por isso que a regra dos séculos existe!
