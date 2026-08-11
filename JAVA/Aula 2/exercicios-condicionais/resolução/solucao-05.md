# Solução — Exercício 5: Classificando a Faixa Etária

```java
import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a idade: ");
        int idade = entrada.nextInt();

        if (idade <= 11) {
            System.out.println("Criança");
        } else if (idade <= 17) {
            System.out.println("Adolescente");
        } else if (idade <= 59) {
            System.out.println("Adulto");
        } else {
            System.out.println("Idoso");
        }
    }
}
```

### Explicação

- Como as faixas são sequenciais e não se sobrepõem, basta testar o **limite superior** de cada uma, em ordem crescente.
- `idade <= 11` cobre "Criança" (0 a 11). Se essa condição for falsa, já sabemos que a idade é 12 ou mais, então `idade <= 17` só precisa checar o teto de "Adolescente" — não é necessário testar `idade >= 12` de novo, porque o `else if` só é avaliado quando a condição anterior falhou.
- O mesmo raciocínio se repete para "Adulto" (`<= 59`), e o `else` final cobre automaticamente tudo que sobrou: 60 anos ou mais.

**Teste com 15:** falha em `<= 11`, passa em `<= 17` → `"Adolescente"`. Bate com o exemplo da questão!

> **Repare no padrão:** sempre que as faixas são sequenciais, cada `else if` "herda" a garantia de que os testes anteriores já falharam — isso deixa o código mais enxuto e evita comparações redundantes como `idade >= 12 && idade <= 17`.
