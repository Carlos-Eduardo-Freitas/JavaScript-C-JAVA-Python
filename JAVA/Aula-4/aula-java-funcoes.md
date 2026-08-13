# Aula de Java — Funções e Algoritmos Clássicos

> Complemento das aulas anteriores: [Aula de Java para Iniciantes](../Aula%201/aula-java-basico.md), [Estruturas Condicionais](../Aula%202/aula-java-condicionais.md) e [Estruturas de Repetição](../Aula%203/aula-java-laços.md). Agora vamos aprender a organizar código em **funções** e usar essa organização para resolver problemas clássicos que aparecem em praticamente todo curso de programação.

---

## Índice

1. [Introdução: Por que Dividir o Código em Pedaços?](#capítulo-1---introdução-por-que-dividir-o-código-em-pedaços)
2. [Anatomia de uma Função em Java](#capítulo-2---anatomia-de-uma-função-em-java)
3. [Parâmetros, Retorno e o void](#capítulo-3---parâmetros-retorno-e-o-void)
4. [Escopo: Onde Cada Variável Vive](#capítulo-4---escopo-onde-cada-variável-vive)
5. [Algoritmo Clássico: Troca de Valores (Swap)](#capítulo-5---algoritmo-clássico-troca-de-valores-swap)
6. [Algoritmo Clássico: Maior Valor e sua Posição](#capítulo-6---algoritmo-clássico-maior-valor-e-sua-posição)
7. [Loop Infinito com break](#capítulo-7---loop-infinito-com-break)
8. [Algoritmo Clássico: Fatorial](#capítulo-8---algoritmo-clássico-fatorial)
9. [Algoritmo Clássico: Fibonacci](#capítulo-9---algoritmo-clássico-fibonacci)
10. [Algoritmo Clássico: Conversão de Base](#capítulo-10---algoritmo-clássico-conversão-de-base)
11. [Algoritmo Clássico: Gerando os Primeiros Números Primos](#capítulo-11---algoritmo-clássico-gerando-os-primeiros-números-primos)
12. [Armadilhas Comuns (e Como Evitá-las)](#capítulo-12---armadilhas-comuns-e-como-evitá-las)
13. [Sabedoria de Quem Já Passou por Isso](#capítulo-13---sabedoria-de-quem-já-passou-por-isso)
14. [Para Continuar Estudando: Livros e Leituras](#capítulo-14---para-continuar-estudando-livros-e-leituras)
15. [Resumo da Aula](#capítulo-15---resumo-da-aula)

---

## Capítulo 1 - Introdução: Por que Dividir o Código em Pedaços?

Até agora, todo código que escrevemos morava dentro do `main`. Isso funciona bem para programas pequenos, mas imagine um programa que precisa calcular o fatorial de um número em **cinco lugares diferentes** do código. Copiar e colar o mesmo bloco de `for` cinco vezes é exatamente o tipo de repetição que já aprendemos a evitar — só que, dessa vez, em vez de repetir com um laço, vamos repetir **reutilizando um pedaço de código já pronto**: uma **função**.

Uma função é como uma receita de bolo: você escreve o passo a passo **uma vez**, dá um nome pra ela (ex: "fazer bolo de chocolate"), e depois, toda vez que quiser um bolo, só precisa chamar a receita pelo nome — sem reescrever os ingredientes e o modo de preparo do zero.

> Você já usou funções sem perceber: `System.out.println()` é uma função. `dado.nextInt()` é uma função. Até o `main` é uma função — só que uma função especial, chamada automaticamente pela JVM quando o programa começa.

Nesta aula, vamos aprender a **criar nossas próprias funções**, e usar essa habilidade para resolver alguns dos algoritmos mais clássicos da programação — aqueles que aparecem em praticamente toda prova, todo curso introdutório e toda entrevista técnica.

---

## Capítulo 2 - Anatomia de uma Função em Java

### Sintaxe geral

```java
modificador tipoDeRetorno nomeDaFuncao(tipo parametro1, tipo parametro2) {
    // corpo da função
    return valor; // se o tipo de retorno não for void
}
```

### Exemplo simples

```java
public static int somar(int a, int b) {
    int resultado = a + b;
    return resultado;
}
```

Vamos destrinchar cada peça:

| Parte | O que significa |
|---|---|
| `public` | a função pode ser acessada de fora da classe (por enquanto, sempre usaremos `public`). |
| `static` | a função pertence à classe, não a um objeto — assim como o `main`, pode ser chamada sem precisar criar uma instância. |
| `int` (antes do nome) | o **tipo de retorno** — o tipo de valor que a função devolve. |
| `somar` | o **nome** da função — escolhido por você, seguindo o padrão camelCase. |
| `(int a, int b)` | os **parâmetros** — os "ingredientes" que a função recebe para trabalhar. |
| `return resultado;` | devolve o valor calculado para quem chamou a função. |

### Chamando a função

```java
public static void main(String[] args) {
    int soma = somar(5, 3);
    System.out.println(soma); // 8
}
```

Repare: `somar(5, 3)` "vira" o valor `8` no lugar onde foi chamada — é exatamente como usar `Math.sqrt(9)`, que "vira" `3.0`.

---

## Capítulo 3 - Parâmetros, Retorno e o void

### Funções que não devolvem nada: void

Nem toda função precisa devolver um valor. Quando uma função só **executa uma ação** (como imprimir algo na tela), usamos `void` no lugar do tipo de retorno:

```java
public static void saudar(String nome) {
    System.out.println("Olá, " + nome + "!");
}
```

Repare que, dentro de uma função `void`, não existe `return valor;` — no máximo um `return;` sozinho, para encerrar a função mais cedo, se necessário.

### Funções sem parâmetros

```java
public static void mostrarMenu() {
    System.out.println("1 - Iniciar");
    System.out.println("2 - Sair");
}
```

### Funções que devolvem mais de um valor: usando array

Como vimos no exercício do caixa eletrônico, o Java não tem uma forma nativa de devolver "dois valores separados" — a solução é empacotar tudo num array:

```java
public static int[] dividir(int dividendo, int divisor) {
    int quociente = dividendo / divisor;
    int resto = dividendo % divisor;
    return new int[]{quociente, resto};
}
```

---

## Capítulo 4 - Escopo: Onde Cada Variável Vive

**Escopo** é a "área" onde uma variável existe e pode ser usada. Essa é uma das confusões mais comuns de quem está começando a usar funções.

```java
public static void main(String[] args) {
    int x = 10;
    dobrar(x);
    System.out.println(x); // ainda imprime 10!
}

public static void dobrar(int numero) {
    numero = numero * 2;
    System.out.println(numero); // imprime 20
}
```

**Por que `x` continua `10` depois de chamar `dobrar(x)`?** Porque, em Java, quando você passa um `int` (ou `double`, `boolean`, etc.) para uma função, ela recebe **uma cópia** do valor, não a variável original. O `numero` dentro de `dobrar` é uma variável nova, que só existe enquanto a função está rodando — mudar `numero` não afeta `x` lá fora.

> **Pense assim:** é como fotocopiar um documento antes de emprestar. Se a pessoa que pegou emprestado rabiscar a cópia, o seu original continua intacto.

---

## Capítulo 5 - Algoritmo Clássico: Troca de Valores (Swap)

Um dos primeiros algoritmos clássicos que todo programador aprende: como trocar o valor de duas variáveis entre si.

### O problema

Você tem `a = 5` e `b = 10`, e quer que, no final, `a = 10` e `b = 5`.

### A armadilha inicial

Um erro comum de quem tenta pela primeira vez:

```java
a = b; // agora a vale 10... mas o valor antigo de a (5) foi perdido!
b = a; // isso só copia o 10 de volta para b, que já era 10
```

Depois desse código, tanto `a` quanto `b` valem `10` — perdemos o `5` original.

### A solução: uma variável auxiliar

```java
public static void main(String[] args) {
    int a = 5;
    int b = 10;

    int aux = a; // guarda o valor de "a" antes de perdê-lo
    a = b;       // agora "a" recebe o valor de "b"
    b = aux;     // "b" recebe o valor original de "a", salvo em "aux"

    System.out.println("a = " + a + ", b = " + b); // a = 10, b = 5
}
```

> **Pense assim:** é como trocar a água de dois copos sem ter um terceiro copo — impossível, você derramaria um deles antes de conseguir. A variável `aux` é justamente esse "terceiro copo" temporário.

### E por que isso não pode ser uma função "de verdade"?

Lembra do Capítulo 4? Se você tentar fazer uma função `trocar(int a, int b)`, ela vai trocar apenas as **cópias locais**, sem efeito nenhum nas variáveis originais lá fora. Para uma função de troca funcionar "de verdade" em Java, ela precisaria devolver os dois valores trocados (usando array, como no Capítulo 3) e você reatribuir na `main`:

```java
public static int[] trocar(int a, int b) {
    return new int[]{b, a}; // já devolve invertido
}

public static void main(String[] args) {
    int a = 5, b = 10;
    int[] resultado = trocar(a, b);
    a = resultado[0];
    b = resultado[1];
    System.out.println("a = " + a + ", b = " + b);
}
```

---

## Capítulo 6 - Algoritmo Clássico: Maior Valor e sua Posição

Outro clássico: dado um conjunto de números, descobrir **qual é o maior** e **em que posição (ordem de leitura)** ele apareceu.

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int quantidade = 5;

        int maior = Integer.MIN_VALUE; // começa "o mais baixo possível"
        int posicaoDoMaior = -1;

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o " + i + "º número: ");
            int numero = entrada.nextInt();

            if (numero > maior) {
                maior = numero;
                posicaoDoMaior = i;
            }
        }

        System.out.println("O maior valor foi " + maior + ", digitado na posição " + posicaoDoMaior);
    }
}
```

### Por que começar com `Integer.MIN_VALUE`?

`Integer.MIN_VALUE` é o menor número inteiro que um `int` consegue representar em Java. Usamos esse truque para garantir que **o primeiro número digitado sempre vai ser maior** que o valor inicial de `maior` — assim, a variável já é atualizada corretamente logo na primeira volta do laço, sem precisar de um tratamento especial para "a primeira vez".

> **Alternativa mais simples (e comum):** em vez de `Integer.MIN_VALUE`, muita gente inicializa `maior` com o **primeiro valor lido**, e começa o laço a partir do segundo. As duas abordagens são válidas — a que usamos aqui evita duplicar o código de leitura.

---

## Capítulo 7 - Loop Infinito com break

Às vezes, você não sabe de antemão quantas vezes vai repetir algo — você só sabe **a condição que deve interromper** a repetição. Nesses casos, um padrão muito comum é criar um laço que roda "para sempre" (`while (true)`), e usar `break` para sair dele quando a condição certa aparecer.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int soma = 0;

        while (true) {
            System.out.print("Digite um número (ou -1 para parar): ");
            int numero = entrada.nextInt();

            if (numero == -1) {
                break; // sai do laço imediatamente
            }

            soma += numero;
        }

        System.out.println("Soma total: " + soma);
    }
}
```

### O que o break faz, exatamente?

`break` interrompe o laço **na hora**, mesmo que a condição do `while` (nesse caso, `true`, que nunca vira falsa sozinha) continuasse permitindo mais repetições. É a única forma de sair de um `while (true)` — sem ele, esse laço realmente nunca pararia sozinho.

> **Cuidado:** `while (true)` sem um `break` em algum caminho possível do código é a receita perfeita para um loop infinito de verdade — o tipo que trava o programa e faz você precisar fechar o terminal na marra.

---

## Capítulo 8 - Algoritmo Clássico: Fatorial

O fatorial de um número `n` (escrito `n!`) é o produto de todos os inteiros positivos até `n`. Por exemplo, `5! = 5 × 4 × 3 × 2 × 1 = 120`.

### Versão com função e for

```java
public static long fatorial(int n) {
    long resultado = 1;
    for (int i = 1; i <= n; i++) {
        resultado *= i;
    }
    return resultado;
}

public static void main(String[] args) {
    System.out.println(fatorial(5)); // 120
}
```

### Versão recursiva (bônus)

Fatorial é o exemplo clássico usado para introduzir **recursão** — uma função que chama a si mesma:

```java
public static long fatorialRecursivo(int n) {
    if (n <= 1) {
        return 1; // caso base: para de chamar a si mesma
    }
    return n * fatorialRecursivo(n - 1);
}
```

Repare no **caso base** (`if (n <= 1) return 1;`) — toda função recursiva precisa de um caso onde ela para de chamar a si mesma, ou vira um loop infinito (só que, nesse caso, um "loop infinito de chamadas de função", que trava o programa com um erro chamado `StackOverflowError`).

> **Como isso funciona por dentro?** `fatorialRecursivo(5)` chama `fatorialRecursivo(4)`, que chama `fatorialRecursivo(3)`, e assim por diante, até `fatorialRecursivo(1)` devolver `1`. Aí a "pilha" de chamadas começa a se resolver de trás pra frente: `2 × 1`, depois `3 × 2`, depois `4 × 6`, até `5 × 24 = 120`.

---

## Capítulo 9 - Algoritmo Clássico: Fibonacci

A sequência de Fibonacci começa com `0` e `1`, e cada número seguinte é a soma dos dois anteriores: `0, 1, 1, 2, 3, 5, 8, 13, 21...`

### Versão com função e while

```java
public static void imprimirFibonacci(int quantidadeDeTermos) {
    int a = 0, b = 1;
    int contador = 0;

    while (contador < quantidadeDeTermos) {
        System.out.print(a + " ");
        int proximo = a + b;
        a = b;
        b = proximo;
        contador++;
    }
}

public static void main(String[] args) {
    imprimirFibonacci(10); // 0 1 1 2 3 5 8 13 21 34
}
```

Esse é o mesmo algoritmo que vimos na aula anterior — agora organizado como uma função reutilizável, com o número de termos como parâmetro.

---

## Capítulo 10 - Algoritmo Clássico: Conversão de Base

Converter um número decimal (base 10) para binário (base 2) é outro algoritmo muito comum. A ideia: dividir repetidamente por 2, guardando os restos — o número em binário é a sequência de restos, lida de trás pra frente.

```java
public static String decimalParaBinario(int numero) {
    if (numero == 0) {
        return "0";
    }

    String binario = "";

    while (numero > 0) {
        int resto = numero % 2;
        binario = resto + binario; // vai "empilhando" na frente
        numero = numero / 2;
    }

    return binario;
}

public static void main(String[] args) {
    System.out.println(decimalParaBinario(13)); // 1101
}
```

### Por que `resto + binario` e não `binario + resto`?

Porque os restos são gerados na **ordem inversa** à leitura final do número binário. O primeiro resto calculado é o **último** dígito do número binário — por isso, colocamos cada novo resto **na frente** da string que já tínhamos, em vez de no final.

**Testando com 13:** `13 % 2 = 1` (`numero = 6`) → `13 / 2 = 6`. `6 % 2 = 0` (`numero = 3`) → resultado parcial: `"01"`. `3 % 2 = 1` (`numero = 1`) → `"101"`. `1 % 2 = 1` (`numero = 0`) → `"1101"`. O laço para, pois `numero` chegou a `0`. Resultado: `1101`, que é `13` em binário.

> Java já tem uma forma pronta pra isso — `Integer.toBinaryString(13)` — mas entender o algoritmo "na unha" é o que realmente ensina como a conversão de base funciona por dentro.

---

## Capítulo 11 - Algoritmo Clássico: Gerando os Primeiros Números Primos

Já vimos, na aula sobre laços, como **verificar se um número é primo**. Agora vamos usar essa mesma ideia, organizada como função, para **gerar os N primeiros números primos**.

```java
public static boolean ehPrimo(int numero) {
    if (numero < 2) {
        return false;
    }

    for (int i = 2; i < numero; i++) {
        if (numero % i == 0) {
            return false; // achou um divisor, não é primo
        }
    }

    return true;
}

public static void main(String[] args) {
    int quantidade = 10;
    int encontrados = 0;
    int numero = 2;

    while (encontrados < quantidade) {
        if (ehPrimo(numero)) {
            System.out.print(numero + " ");
            encontrados++;
        }
        numero++;
    }
}
```

### Explicando a lógica

- `ehPrimo(numero)` faz exatamente o que já vimos: tenta dividir o número por todos os valores entre `2` e `numero - 1`. Se algum divisor for encontrado, `return false` já interrompe a função na hora — nem precisa terminar o laço interno.
- Na `main`, usamos um `while` que só para quando já tivermos encontrado a `quantidade` de primos desejada — perceba que **não sabemos de antemão até qual número vamos precisar chegar**, por isso um `for` tradicional não seria a escolha mais natural aqui.

> **Repare como as funções se conectam:** `ehPrimo` cuida de uma responsabilidade (verificar um único número), e a `main` cuida de outra (controlar quantos primos já foram encontrados). Dividir o problema assim — cada função com uma única responsabilidade clara — é uma das ideias mais importantes de todo esse capítulo sobre funções.

---

## Capítulo 12 - Armadilhas Comuns (e Como Evitá-las)

1. **Esperar que uma função mude a variável original passada como parâmetro** — como vimos no Capítulo 4, tipos primitivos (`int`, `double`, `boolean`...) são passados **por cópia**. Se precisar "devolver" um novo valor, use `return`.
2. **Esquecer o `return` numa função que não é `void`** — o código simplesmente não compila. Toda função com tipo de retorno diferente de `void` precisa garantir um `return` em **todo** caminho possível do código.
3. **Recursão sem caso base** — esquecer o `if` que interrompe a recursão gera `StackOverflowError`, o "loop infinito" das funções recursivas.
4. **`while (true)` sem nenhum `break` alcançável** — sempre confira se existe um caminho garantido para sair do laço.
5. **Funções gigantes fazendo várias coisas ao mesmo tempo** — se sua função tem 80 linhas e faz cinco tarefas diferentes, geralmente é sinal de que ela deveria virar três ou quatro funções menores, cada uma com uma responsabilidade clara (igual fizemos com `ehPrimo`).

---

## Capítulo 13 - Sabedoria de Quem Já Passou por Isso

> "Existem duas formas de construir um projeto de software: uma é fazê-lo tão simples que não haja deficiências óbvias; a outra é fazê-lo tão complicado que não haja deficiências óbvias." — **C.A.R. Hoare**, cientista da computação, criador do algoritmo Quicksort.

> "A função de uma boa função é fazer uma coisa, e fazer bem feita." — princípio amplamente associado às ideias de **Robert C. Martin ("Uncle Bob")** sobre funções pequenas e de responsabilidade única.

> "Recursão é quando uma função entende que, para resolver um problema grande, basta resolver uma versão menor dele e confiar no resto." — forma comum de explicar a recursão em cursos introdutórios de ciência da computação.

O fio condutor dessas ideias: funções pequenas, com um propósito claro e um nome que já explica o que fazem, tornam o código mais fácil de testar, de reutilizar e de entender — inclusive por você mesmo, revisitando esse código daqui a um tempo.

---

## Capítulo 14 - Para Continuar Estudando: Livros e Leituras

- **Ana Fernanda Gomes Ascencio e Edilene Aparecida Campos** — *Fundamentos de Programação de Computadores: Algoritmos, Pascal, C/C++ e Java*. Traz uma boa seção sobre subalgoritmos (funções e procedimentos) e diversos algoritmos clássicos.
- **Deitel & Deitel** — *Java: Como Programar*. Tem um capítulo dedicado inteiramente a métodos (o nome que Java dá às funções dentro de classes), incluindo recursão.
- **Thomas H. Cormen et al.** — *Introduction to Algorithms*. Leitura mais avançada, mas é a referência clássica para quem quiser se aprofundar de verdade em algoritmos como os apresentados aqui.

> Dica: procure esses títulos por nome e edição em sebos, bibliotecas universitárias ou livrarias — as edições variam bastante de ano para ano.

---

## Capítulo 15 - Resumo da Aula

- Funções permitem reutilizar código, dando nome a um bloco de instruções que pode ser chamado várias vezes.
- Parâmetros são os valores de entrada; `return` devolve um valor de saída; `void` indica que a função não devolve nada.
- Tipos primitivos são passados **por cópia** — uma função não altera a variável original do chamador diretamente.
- **Troca de valores** precisa de uma variável auxiliar (ou de um `return` com array) para não perder um dos valores originais.
- **Maior valor e posição** usa uma variável de controle atualizada dentro de um laço, comparando a cada novo valor lido.
- `while (true)` combinado com `break` é o padrão para repetir "até que uma condição inesperada apareça", quando não se sabe de antemão quantas repetições serão necessárias.
- **Fatorial** e **Fibonacci** são exemplos clássicos de acumulação de valores dentro de um laço — e o fatorial também é o exemplo mais comum para introduzir recursão.
- **Conversão de base** usa divisões e restos sucessivos, montando o resultado de trás para frente.
- **Geração de números primos** combina uma função de verificação (`ehPrimo`) com um laço externo que controla quantos primos já foram encontrados — um bom exemplo de como dividir responsabilidades entre funções.
