# Aula de Java — Estruturas de Repetição (for, while, do-while)

> Complemento das aulas anteriores: [Aula de Java para Iniciantes](../Aula%201/aula-java-basico.md) e [Estruturas Condicionais](../Aula%202/aula-java-condicionais.md). Agora vamos ensinar o programa a **repetir tarefas** sem que a gente precise copiar e colar a mesma linha de código cem vezes.

---

## Índice

1. [Introdução: Por que Repetir na Mão é uma Péssima Ideia](#capítulo-1---introdução-por-que-repetir-na-mão-é-uma-péssima-ideia)
2. [O comando while](#capítulo-2---o-comando-while)
3. [O comando do-while](#capítulo-3---o-comando-do-while)
4. [O comando for](#capítulo-4---o-comando-for)
5. [Incremento, Decremento e Atalhos](#capítulo-5---incremento-decremento-e-atalhos)
6. [Escolhendo o Laço Certo](#capítulo-6---escolhendo-o-laço-certo)
7. [Exemplos Práticos do Dia a Dia](#capítulo-7---exemplos-práticos-do-dia-a-dia)
8. [Armadilhas Comuns (e Como Evitá-las)](#capítulo-8---armadilhas-comuns-e-como-evitá-las)
9. [Sabedoria de Quem Já Passou por Isso](#capítulo-9---sabedoria-de-quem-já-passou-por-isso)
10. [Para Continuar Estudando: Livros e Leituras](#capítulo-10---para-continuar-estudando-livros-e-leituras)
11. [Resumo da Aula](#capítulo-11---resumo-da-aula)

---

## Capítulo 1 - Introdução: Por que Repetir na Mão é uma Péssima Ideia

Imagine que alguém pede pra você escrever os números de 1 a 1000 no papel, um por um, à mão. Você provavelmente desistiria no número 50. Agora imagine escrever isso em código, linha por linha:

```java
System.out.println(1);
System.out.println(2);
System.out.println(3);
// ... mais 997 linhas iguaizinhas a essa
```

Isso é exaustivo, feio e — o pior de tudo — se você precisar mudar alguma coisa (por exemplo, ir até 2000 em vez de 1000), você teria que reescrever tudo de novo.

É exatamente para isso que existem as **estruturas de repetição**, também chamadas de **laços** ou **loops**: `while`, `do-while` e `for`. Elas dizem ao programa:

> "Repita este bloco de código várias vezes, até que uma condição não seja mais verdadeira."

Com um laço, os mil números de antes viram só 3 linhas de código. É a mesma sensação de descobrir que existe control+C e control+V — só que para lógica, não para texto.

---

## Capítulo 2 - O comando while

`while` significa **"enquanto"**. Ele repete um bloco de código **enquanto** uma condição continuar sendo verdadeira. Assim que a condição vira falsa, o laço para.

### Sintaxe

```java
while (condição) {
    // executado repetidamente, enquanto a condição for verdadeira
}
```

### Exemplo: contando de 1 a 5

```java
int contador = 1;

while (contador <= 5) {
    System.out.println(contador);
    contador++;
}
```

Repare em três partes que **sempre** precisam existir num `while` bem escrito:

1. **Inicialização:** `int contador = 1;` — antes do laço, precisamos de um valor inicial.
2. **Condição:** `contador <= 5` — testada **antes** de cada repetição.
3. **Atualização:** `contador++;` — dentro do laço, algo precisa mudar para que a condição, um dia, se torne falsa.

> **Pense assim:** o `while` é como perguntar "ainda tenho combustível?" antes de cada quarteirão. Se a resposta for sim, você anda mais um quarteirão. Se for não, você para. Mas se você nunca gastar combustível (esquecer o `contador++`), vai ficar perguntando pra sempre — isso se chama **loop infinito**, e é uma das primeiras armadilhas que veremos no Capítulo 8.

---

## Capítulo 3 - O comando do-while

O `do-while` é "primo" do `while`, com uma diferença importante: ele executa o bloco de código **pelo menos uma vez**, e só depois verifica a condição.

### Sintaxe

```java
do {
    // executado pelo menos uma vez
} while (condição);
```

> Repare no ponto e vírgula depois do `while` — aqui ele é obrigatório, diferente do `while` sozinho.

### Exemplo: pedindo uma senha até acertar

```java
import java.util.Scanner;

Scanner entrada = new Scanner(System.in);
String senha;

do {
    System.out.print("Digite a senha: ");
    senha = entrada.nextLine();
} while (!senha.equals("java123"));

System.out.println("Acesso liberado!");
```

### Por que usar do-while em vez de while?

A diferença fica clara quando a condição depende de algo que **só existe depois** de rodar o bloco pelo menos uma vez. No exemplo acima, não faz sentido perguntar "a senha está certa?" antes mesmo do usuário ter digitado alguma coisa — por isso, primeiro pedimos a senha (`do`), e só depois verificamos (`while`).

> **Pense assim:** se o `while` é "olho antes de agir", o `do-while` é "ajo primeiro, e decido se repito depois de ver o resultado" — como provar uma comida antes de decidir se repete o prato.

---

## Capítulo 4 - O comando for

O `for` é o laço mais usado quando você **já sabe, de antemão, quantas vezes** quer repetir algo (ou pelo menos sabe a regra que define o início, o fim e o passo).

### Sintaxe

```java
for (inicialização; condição; atualização) {
    // executado repetidamente, enquanto a condição for verdadeira
}
```

Repare que o `for` reúne, numa única linha, as três partes que no `while` ficavam espalhadas (uma antes do laço, uma na condição, uma dentro do laço).

### Exemplo: o mesmo "contar de 1 a 5", agora com for

```java
for (int contador = 1; contador <= 5; contador++) {
    System.out.println(contador);
}
```

Compare com o `while` do Capítulo 2 — é exatamente a mesma lógica, só que mais compacta e organizada, porque as três partes ficam juntas, visíveis de cara.

### Exemplo: contando de trás pra frente

```java
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
System.out.println("Fim da contagem!");
```

### Exemplo: pulando de 2 em 2

```java
for (int i = 0; i <= 20; i += 2) {
    System.out.println(i);
}
```

> **Curiosidade:** a letra `i` é usada por tradição (vem de "index", índice em inglês) para variáveis de controle de laço. Não é uma regra obrigatória, mas é tão comum que, quando você vê um `for (int i = ...)`, já sabe de cara que é um contador.

---

## Capítulo 5 - Incremento, Decremento e Atalhos

Nos exemplos acima, usamos alguns operadores que valem a pena destacar:

| Operador | Significado | Equivalente |
|---|---|---|
| `i++` | incrementa 1 | `i = i + 1` |
| `i--` | decrementa 1 | `i = i - 1` |
| `i += 2` | soma 2 e atualiza | `i = i + 2` |
| `i -= 3` | subtrai 3 e atualiza | `i = i - 3` |
| `i *= 2` | multiplica por 2 e atualiza | `i = i * 2` |

Esses "atalhos" existem porque atualizar uma variável com base nela mesma é algo extremamente comum dentro de laços — por isso o Java (e quase toda linguagem) oferece uma forma mais curta de escrever.

> **Diferença sutil:** `i++` (pós-incremento) e `++i` (pré-incremento) se comportam diferente quando usados **dentro de uma expressão maior** (tipo `array[i++]`), mas quando estão sozinhos numa linha, como na maioria dos laços que você vai escrever no começo, o resultado final é o mesmo. Não se preocupe com essa diferença agora — é um detalhe pra quando você já estiver mais confortável.

---

## Capítulo 6 - Escolhendo o Laço Certo

Uma dúvida comum de quem está aprendendo: "beleza, mas qual eu uso?" Aqui vai um guia rápido:

| Situação | Melhor escolha |
|---|---|
| Eu sei exatamente quantas vezes quero repetir (ou tenho uma regra clara de início/fim/passo) | `for` |
| Eu não sei quantas vezes vou repetir, depende de uma condição que só se resolve durante a execução | `while` |
| Eu preciso que o bloco rode **pelo menos uma vez**, antes de checar a condição | `do-while` |

Na prática, `while` e `for` conseguem resolver os mesmos problemas — a escolha entre eles é, na maioria das vezes, uma questão de **clareza**: qual dos dois deixa a intenção do código mais fácil de entender pra quem for ler depois (inclusive você mesmo, daqui a 6 meses).

---

## Capítulo 7 - Exemplos Práticos do Dia a Dia

### 1. Tabuada de um número

```java
import java.util.Scanner;

Scanner entrada = new Scanner(System.in);
System.out.print("Digite um número: ");
int numero = entrada.nextInt();

for (int i = 1; i <= 10; i++) {
    System.out.println(numero + " x " + i + " = " + (numero * i));
}
```

### 2. Somando uma sequência de números digitados

```java
import java.util.Scanner;

Scanner entrada = new Scanner(System.in);
int soma = 0;
int quantidade = 5;

for (int i = 1; i <= quantidade; i++) {
    System.out.print("Digite o número " + i + ": ");
    int numero = entrada.nextInt();
    soma += numero;
}

System.out.println("A soma total é: " + soma);
```

### 3. Calculando o fatorial de um número

```java
import java.util.Scanner;

Scanner entrada = new Scanner(System.in);
System.out.print("Digite um número: ");
int n = entrada.nextInt();

long fatorial = 1;
for (int i = 1; i <= n; i++) {
    fatorial *= i;
}

System.out.println(n + "! = " + fatorial);
```

> Usamos `long` em vez de `int` para o fatorial porque esse valor cresce muito rápido — o fatorial de números um pouco maiores já estoura a capacidade de um `int`.

### 4. Verificando se um número é primo

```java
import java.util.Scanner;

Scanner entrada = new Scanner(System.in);
System.out.print("Digite um número: ");
int numero = entrada.nextInt();

boolean primo = true;

if (numero < 2) {
    primo = false;
} else {
    for (int i = 2; i < numero; i++) {
        if (numero % i == 0) {
            primo = false;
        }
    }
}

if (primo) {
    System.out.println(numero + " é primo.");
} else {
    System.out.println(numero + " não é primo.");
}
```

### 5. Menu que repete até o usuário sair (do-while)

```java
import java.util.Scanner;

Scanner entrada = new Scanner(System.in);
int opcao;

do {
    System.out.println("1 - Ver saldo");
    System.out.println("2 - Fazer saque");
    System.out.println("0 - Sair");
    System.out.print("Escolha uma opção: ");
    opcao = entrada.nextInt();

    if (opcao == 1) {
        System.out.println("Seu saldo é R$ 1000,00");
    } else if (opcao == 2) {
        System.out.println("Saque realizado!");
    }
} while (opcao != 0);

System.out.println("Encerrando o sistema...");
```

### 6. Sequência de Fibonacci (while)

```java
int termos = 10;
int a = 0, b = 1;
int contador = 0;

while (contador < termos) {
    System.out.print(a + " ");
    int proximo = a + b;
    a = b;
    b = proximo;
    contador++;
}
```

### 7. Revisitando o caixa eletrônico com for

Lembra do exercício das notas, lá da aula sobre condicionais? Se guardássemos as notas num array (o que o enunciado original não permitia, mas serve de exemplo aqui), o `for` deixaria o código bem mais enxuto:

```java
int[] notas = {100, 50, 20, 10, 5, 2, 1};
int saldo = 576;

for (int i = 0; i < notas.length; i++) {
    int qtd = saldo / notas[i];
    saldo = saldo % notas[i];

    if (qtd > 0) {
        System.out.println(qtd + " nota(s) de R$ " + notas[i] + ",00");
    }
}
```

Isso substitui os 7 blocos repetidos de divisão e módulo por um único laço — é um bom exemplo de como `for` + array evita a repetição manual de código parecido.

---

## Capítulo 8 - Armadilhas Comuns (e Como Evitá-las)

1. **Esquecer de atualizar a variável de controle** — no `while` e no `do-while`, se você esquecer o `contador++` (ou equivalente), a condição nunca vira falsa, e o programa trava num **loop infinito**.
2. **Off-by-one (erro de um a mais ou um a menos)** — confundir `<` com `<=` faz o laço rodar uma vez a mais ou a menos do que deveria. Se você quer repetir "de 1 até 10, incluindo o 10", a condição precisa ser `i <= 10`, não `i < 10`.
3. **Declarar a variável de controle dentro do `for` e tentar usá-la depois, fora dele** — uma variável declarada em `for (int i = ...)` só existe **dentro** das chaves do laço. Se precisar do valor final fora do laço, declare a variável antes.
4. **Confundir `while` com `do-while` quando a condição depende de uma entrada do usuário** — se você usar `while` para pedir uma senha, mas a variável `senha` ainda não tem valor nenhum antes do laço começar, o programa nem compila. Nesses casos, `do-while` costuma ser a escolha certa.
5. **Laços aninhados sem necessidade** — um `for` dentro de outro `for` (comum em matrizes) é válido e necessário às vezes, mas se você perceber vários níveis de laço só para repetir a mesma coisa, vale parar e pensar se existe um jeito mais simples.

---

## Capítulo 9 - Sabedoria de Quem Já Passou por Isso

> "Um programa de computador faz o que você manda ele fazer, não o que você quer que ele faça." — atribuída com frequência a programadores experientes como um lembrete de que o computador segue exatamente as instruções, nem mais, nem menos — inclusive quando um laço "esquece" de parar.

> "Todo grande programa é construído a partir de programas pequenos e simples que funcionam." — ideia central defendida por **Niklaus Wirth**, criador da linguagem Pascal, ao longo de sua obra sobre estruturas de programação.

> "Programas devem ser escritos para pessoas lerem, e só incidentalmente para máquinas executarem." — **Harold Abelson**, coautor do clássico *Structure and Interpretation of Computer Programs*.

A lição por trás dessas frases: um laço `for` bem escrito, com nomes de variáveis que fazem sentido e uma condição clara, é muito mais valioso do que um código "esperto" que só você entende hoje — e talvez nem você entenda mais daqui a um mês.

---

## Capítulo 10 - Para Continuar Estudando: Livros e Leituras

- **Ana Fernanda Gomes Ascencio e Edilene Aparecida Campos** — *Fundamentos de Programação de Computadores: Algoritmos, Pascal, C/C++ e Java*. Traz bastante exercício de lógica com laços, incluindo sequências numéricas e séries.
- **Deitel & Deitel** — *Java: Como Programar*. Tem capítulos inteiros dedicados a estruturas de repetição, com muitos exercícios progressivos.
- **Robert Sebesta** — *Conceitos de Linguagens de Programação*. Explica como diferentes linguagens implementam laços por baixo dos panos — leitura mais avançada, mas esclarecedora.

> Dica: procure esses títulos por nome e edição em sebos, bibliotecas universitárias ou livrarias — as edições variam bastante de ano para ano.

---

## Capítulo 11 - Resumo da Aula

- `while` testa a condição **antes** de cada repetição — pode nunca executar o bloco, se a condição já começar falsa.
- `do-while` executa o bloco **pelo menos uma vez**, e só depois testa a condição.
- `for` reúne inicialização, condição e atualização numa única linha — ideal quando você já sabe (ou tem uma regra clara para) a quantidade de repetições.
- Toda repetição precisa de uma variável de controle que **mude** a cada volta, ou você corre o risco de criar um loop infinito.
- `i++`, `i--`, `+=`, `-=` são atalhos para atualizar uma variável com base nela mesma — extremamente comuns dentro de laços.
- Como dizia Harold Abelson: escreva os laços pensando em quem vai ler o código, não só em fazer o computador entender.
