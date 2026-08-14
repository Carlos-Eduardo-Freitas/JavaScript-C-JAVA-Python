# Capítulo: Switch Case — A Cabine de Múltiplas Portas

> "Programas são feitos para serem lidos por humanos, e só incidentalmente para serem executados por máquinas." — Harold Abelson

## 1. O que é o `switch`?

Imagine uma cabine com várias portas numeradas. Você chega com uma senha na mão e a cabine olha pra ela e diz: *"Ah, senha 2? Porta 2!"* — e te manda direto pra lá, sem precisar checar porta por porta.

É exatamente isso que o `switch` faz. Ele é uma alternativa ao `if / else if / else` quando você está comparando **uma única variável** com **vários valores possíveis**.

Compare os dois:

```java
// Com if/else if
if (nota == 100) {
    System.out.println("Nota de cem");
} else if (nota == 50) {
    System.out.println("Nota de cinquenta");
} else if (nota == 20) {
    System.out.println("Nota de vinte");
} else {
    System.out.println("Nota desconhecida");
}
```

```java
// Com switch
switch (nota) {
    case 100:
        System.out.println("Nota de cem");
        break;
    case 50:
        System.out.println("Nota de cinquenta");
        break;
    case 20:
        System.out.println("Nota de vinte");
        break;
    default:
        System.out.println("Nota desconhecida");
        break;
}
```

Mesmo resultado, mas quando você tem **muitas opções fixas**, o `switch` fica muito mais organizado de ler.

## 2. Anatomia do switch

```java
switch (variavel) {
    case valor1:
        // código se variavel == valor1
        break;
    case valor2:
        // código se variavel == valor2
        break;
    default:
        // código se nenhum caso bateu
        break;
}
```

- `switch (variavel)` → abre a cabine e olha pra senha na mão.
- `case valorX:` → "se a senha for X, entre aqui."
- `break;` → a porta se fecha atrás de você. Sem ele, o programa **continua descendo** para os próximos `case`s, mesmo que já tenha encontrado o certo (isso se chama *fall-through*, e é uma pegadinha clássica de prova!).
- `default:` → a porta "não sei o que fazer com você", usada quando nenhum `case` bate. É o equivalente ao `else` final.

## 3. O perigo de esquecer o `break`

```java
int dia = 2;
switch (dia) {
    case 1:
        System.out.println("Segunda");
    case 2:
        System.out.println("Terça");
    case 3:
        System.out.println("Quarta");
        break;
    default:
        System.out.println("Outro dia");
}
```

**Saída:**
```
Terça
Quarta
```

Repare: entrou em `case 2`, imprimiu "Terça", e como não tinha `break`, **continuou** e imprimiu "Quarta" também! O `switch` só para quando encontra um `break` ou quando o bloco termina.

> Como diria um programador experiente: "o `break` não é opcional, é um contrato que você faz com o próximo caso."

## 4. `switch` funciona com quê?

Em Java, o `switch` aceita: `int`, `char`, `String`, `enum` (e alguns outros tipos numéricos menores como `byte` e `short`). Não funciona com `double` ou `float`.

```java
char nota = 'B';
switch (nota) {
    case 'A':
        System.out.println("Excelente!");
        break;
    case 'B':
        System.out.println("Muito bom!");
        break;
    case 'C':
        System.out.println("Precisa melhorar.");
        break;
    default:
        System.out.println("Nota inválida.");
        break;
}
```

```java
String comando = "sacar";
switch (comando) {
    case "sacar":
        System.out.println("Processando saque...");
        break;
    case "depositar":
        System.out.println("Processando depósito...");
        break;
    default:
        System.out.println("Comando não reconhecido.");
        break;
}
```

## 5. Múltiplos `case`s para o mesmo bloco

Você pode "empilhar" vários `case`s um em cima do outro se eles devem executar o mesmo código:

```java
int mes = 4;
switch (mes) {
    case 12:
    case 1:
    case 2:
        System.out.println("Verão");
        break;
    case 3:
    case 4:
    case 5:
        System.out.println("Outono");
        break;
    default:
        System.out.println("Outra estação");
        break;
}
```

Aqui, `mes = 4` cai direto em "Outono" — os `case`s vazios (sem `break`) apenas "empurram" a execução para baixo até achar código de verdade.

## 6. Exercício prático — Menu do caixa eletrônico

Baseado no nosso programa de notas, crie um `switch` que, dado um número de 1 a 4 digitado pelo usuário, mostre uma opção de menu:

```java
import java.util.Scanner;

public class MenuCaixa {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        System.out.println("1 - Saque");
        System.out.println("2 - Depósito");
        System.out.println("3 - Consultar saldo");
        System.out.println("4 - Sair");
        int opcao = dado.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Você escolheu Saque.");
                break;
            case 2:
                System.out.println("Você escolheu Depósito.");
                break;
            case 3:
                System.out.println("Você escolheu Consultar saldo.");
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
```

**Desafio:** tente reescrever a função `proximaNota` do programa de saque usando `switch` em vez de `if/else if`. Ela vai ficar assim?

```java
public static int proximaNota(int nota) {
    switch (nota) {
        case 100: return 50;
        case 50: return 20;
        case 20: return 10;
        case 10: return 5;
        case 5: return 2;
        case 2: return 1;
        default: return 0;
    }
}
```

(Dica: quando você usa `return` dentro de um `case`, o `break` se torna desnecessário — o `return` já sai da função inteira!)

## 7. Resumo rápido

| Situação | Use `if/else` | Use `switch` |
|---|---|---|
| Comparações complexas (`>`, `<`, `&&`) | ✅ | ❌ |
| Muitos valores fixos para uma variável | possível, mas verboso | ✅ mais limpo |
| Tipos `double`/`float` | ✅ | ❌ |
| Vários `case`s compartilhando o mesmo código | verboso | ✅ (case empilhado) |

> "Simplicidade é o último grau de sofisticação." — Leonardo da Vinci (frequentemente citada por programadores para lembrar: escolha a ferramenta certa, não a mais impressionante.)
