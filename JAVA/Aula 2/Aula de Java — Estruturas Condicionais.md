# Aula de Java — Estruturas Condicionais (if, else, if-else)

> Complemento da [Aula de Java para Iniciantes](../Aula%201/aula-java-basico.md). Aqui o programa aprende a **tomar decisões** — e a gente aprende junto, com bastante exemplo, uma pitada de história da programação e frases de gente que fez a computação acontecer.

---

## Índice

1. [Introdução: Programas que Pensam](#capítulo-1---introdução-programas-que-pensam)
2. [O comando if](#capítulo-2---o-comando-if)
3. [O comando else](#capítulo-3---o-comando-else)
4. [A cadeia else if](#capítulo-4---a-cadeia-else-if)
5. [Operadores usados nas condições](#capítulo-5---operadores-usados-nas-condições)
6. [Exemplos Práticos do Dia a Dia](#capítulo-6---exemplos-práticos-do-dia-a-dia)
7. [Armadilhas Comuns (e Como Evitá-las)](#capítulo-7---armadilhas-comuns-e-como-evitá-las)
8. [Sabedoria de Quem Já Passou por Isso](#capítulo-8---sabedoria-de-quem-já-passou-por-isso)
9. [Para Continuar Estudando: Livros e Leituras](#capítulo-9---para-continuar-estudando-livros-e-leituras)
10. [Resumo da Aula](#capítulo-10---resumo-da-aula)

---

## Capítulo 1 - Introdução: Programas que Pensam

Imagine que você é um guarda de trânsito. Cada carro que passa, você precisa decidir: *deixo passar* ou *paro o carro*? Você não trata todos os carros do mesmo jeito — depende da situação: a cor do sinal, se o carro está em excesso de velocidade, se é dia de rodízio.

Programas de computador fazem exatamente a mesma coisa. Até agora, nossos programas eram "de mão única": liam algo, calculavam, mostravam o resultado, fim. Mas o mundo real está cheio de "depende". *Depende* da idade da pessoa. *Depende* se a senha está certa. *Depende* se o número é par.

É para isso que existem as **estruturas condicionais**: `if`, `else` e `else if`. Elas são o jeito do programa dizer:

> "Se isso for verdade, faço uma coisa. Senão, faço outra."

Simples assim — e, ao mesmo tempo, é a peça que transforma uma calculadora burra em um programa inteligente.

---

## Capítulo 2 - O comando if

`if` significa **"se"**. Ele testa uma condição — algo que só pode ser verdadeiro (`true`) ou falso (`false`) — e só executa o bloco de código se essa condição for verdadeira.

### Sintaxe

```java
if (condição) {
    // executado somente se a condição for verdadeira
}
```

### Exemplo simples

```java
int idade = 20;

if (idade >= 18) {
    System.out.println("Você é maior de idade!");
}
```

Se `idade` for `20`, a condição `idade >= 18` é `true`, então a mensagem é exibida. Se `idade` fosse `15`, nada aconteceria — o programa simplesmente pularia o bloco do `if`.

> **Pense assim:** o `if` é uma porta. Só quem tem a "senha" (a condição verdadeira) consegue passar por ela.

---

## Capítulo 3 - O comando else

Todo `if` pode vir acompanhado de um `else` ("senão"), que executa quando a condição do `if` é **falsa**.

### Sintaxe

```java
if (condição) {
    // executado se verdadeiro
} else {
    // executado se falso
}
```

### Exemplo

```java
int idade = 15;

if (idade >= 18) {
    System.out.println("Você é maior de idade!");
} else {
    System.out.println("Você ainda é menor de idade.");
}
```

Agora o programa **sempre** vai dizer alguma coisa: ou você é maior, ou é menor. Não existe um terceiro caminho — é tudo ou nada, verdadeiro ou falso.

---

## Capítulo 4 - A cadeia else if

E se existirem mais de duas possibilidades? É aí que entra o `else if`, que permite encadear várias condições, uma atrás da outra.

### Sintaxe

```java
if (condição1) {
    // executado se condição1 for verdadeira
} else if (condição2) {
    // executado se condição1 for falsa e condição2 for verdadeira
} else if (condição3) {
    // executado se as anteriores forem falsas e condição3 for verdadeira
} else {
    // executado se todas as anteriores forem falsas
}
```

### Exemplo: classificando uma nota escolar

```java
double nota = 7.5;

if (nota >= 9.0) {
    System.out.println("Conceito A - Excelente!");
} else if (nota >= 7.0) {
    System.out.println("Conceito B - Bom!");
} else if (nota >= 5.0) {
    System.out.println("Conceito C - Regular.");
} else {
    System.out.println("Conceito D - Precisa melhorar.");
}
```

> **Importante:** o Java testa as condições **na ordem em que aparecem**, e para na primeira que for verdadeira. Por isso, a ordem das condições importa muito! Se você colocasse `nota >= 5.0` antes de `nota >= 7.0`, o programa nunca chegaria a testar a condição de 7.0, porque 7.5 já satisfaz `>= 5.0` primeiro.

---

## Capítulo 5 - Operadores usados nas condições

Toda condição de um `if` é, no fundo, uma expressão que resulta em `true` ou `false`. Para construir essas expressões, usamos:

### Operadores relacionais

| Operador | Significado |
|---|---|
| `==` | igual a |
| `!=` | diferente de |
| `>` | maior que |
| `<` | menor que |
| `>=` | maior ou igual |
| `<=` | menor ou igual |

### Operadores lógicos (para combinar condições)

| Operador | Significado | Exemplo |
|---|---|---|
| `&&` | E — as duas precisam ser verdadeiras | `idade >= 18 && temCNH` |
| \|\| | OU — pelo menos uma precisa ser verdadeira | `dia == 6 \|\| dia == 7` |
| `!` | NÃO — inverte o valor | `!aprovado` |

### Exemplo combinando operadores

```java
int idade = 20;
boolean temCarteira = true;

if (idade >= 18 && temCarteira) {
    System.out.println("Pode dirigir!");
} else {
    System.out.println("Não pode dirigir.");
}
```

> **Cuidado com `=` e `==`!** Um erro clássico de iniciante é usar `=` (atribuição) no lugar de `==` (comparação) dentro de um `if`. Em Java, isso geralmente nem compila quando a condição não é booleana — o que já ajuda a te proteger do erro.

---

## Capítulo 6 - Exemplos Práticos do Dia a Dia

Vamos agora para a parte divertida: usar `if`, `else` e `else if` para resolver problemas reais.

### 1. Verificando se um número é par ou ímpar

```java
int numero = 7;

if (numero % 2 == 0) {
    System.out.println(numero + " é par.");
} else {
    System.out.println(numero + " é ímpar.");
}
```

O operador `%` (módulo) devolve o resto da divisão. Se o resto da divisão por 2 for `0`, o número é par.

### 2. Verificando se dois números são múltiplos entre si

```java
int a = 15;
int b = 5;

if (a % b == 0) {
    System.out.println(a + " é múltiplo de " + b);
} else if (b % a == 0) {
    System.out.println(b + " é múltiplo de " + a);
} else {
    System.out.println(a + " e " + b + " não são múltiplos entre si.");
}
```

### 3. Validando uma senha

```java
import java.util.Scanner;

public class VerificaSenha {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String senhaCorreta = "java123";

        System.out.print("Digite a senha: ");
        String senhaDigitada = entrada.nextLine();

        if (senhaDigitada.equals(senhaCorreta)) {
            System.out.println("Acesso permitido!");
        } else {
            System.out.println("Senha incorreta. Acesso negado.");
        }
    }
}
```

> **Atenção:** para comparar textos (`String`) em Java, **nunca** use `==`. Use o método `.equals()`. O `==` compara se são o mesmo objeto na memória, não se o conteúdo é igual — um erro clássico que confunde muita gente no começo.

### 4. Verificando idade mínima para tirar a CNH

No Brasil, a idade mínima para tirar a Carteira Nacional de Habilitação (CNH) é 18 anos.

```java
import java.util.Scanner;

public class VerificaCNH {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = entrada.nextInt();

        if (idade >= 18) {
            System.out.println("Você já pode tirar a CNH!");
        } else {
            int faltam = 18 - idade;
            System.out.println("Você ainda não pode. Faltam " + faltam + " ano(s).");
        }
    }
}
```

### 5. Classificando o IMC (Índice de Massa Corporal)

```java
double peso = 70;
double altura = 1.75;
double imc = peso / (altura * altura);

if (imc < 18.5) {
    System.out.println("Abaixo do peso");
} else if (imc < 25) {
    System.out.println("Peso normal");
} else if (imc < 30) {
    System.out.println("Sobrepeso");
} else {
    System.out.println("Obesidade");
}
```

### 6. Verificando o maior de três números

```java
int a = 8, b = 15, c = 12;

if (a >= b && a >= c) {
    System.out.println("O maior é " + a);
} else if (b >= a && b >= c) {
    System.out.println("O maior é " + b);
} else {
    System.out.println("O maior é " + c);
}
```

### 7. Dia útil ou fim de semana

```java
int dia = 6; // 1 = domingo, 7 = sábado

if (dia == 1 || dia == 7) {
    System.out.println("Fim de semana!");
} else {
    System.out.println("Dia útil.");
}
```

---

## Capítulo 7 - Armadilhas Comuns (e Como Evitá-las)

Até os programadores mais experientes já caíram nessas pegadinhas. Melhor conhecer agora do que sofrer depois:

1. **Usar `=` em vez de `==`** dentro da condição — sempre revise se você quis *comparar* e não *atribuir*.
2. **Esquecer as chaves `{ }`** quando o bloco tem mais de uma linha — sem elas, só a linha seguinte ao `if` pertence a ele.
3. **Comparar `String` com `==`** — use sempre `.equals()`.
4. **Ordem errada nos `else if`** — condições mais restritivas devem vir antes das mais abrangentes (como vimos no exemplo da nota).
5. **Excesso de `if` aninhado** — quando você percebe muitos `if` dentro de `if`, geralmente dá pra simplificar combinando condições com `&&` e `||`.

---

## Capítulo 8 - Sabedoria de Quem Já Passou por Isso

Programar é, antes de tudo, uma forma de pensar. Algumas pessoas que ajudaram a construir a computação moderna deixaram frases que valem para qualquer iniciante:

> "A simplicidade é um pré-requisito para a confiabilidade." — **Edsger W. Dijkstra**, cientista da computação, criador de conceitos fundamentais de algoritmos.

> "A otimização prematura é a raiz de todo mal." — **Donald Knuth**, autor da coleção *The Art of Computer Programming*.

> "A frase mais perigosa na linguagem é: 'sempre fizemos assim'." — **Grace Hopper**, pioneira da programação e uma das criadoras do primeiro compilador.

> "Todos deveriam aprender a programar um computador, porque isso ensina a pensar." — ideia frequentemente atribuída a **Steve Jobs** em entrevistas sobre educação.

O que essas frases têm em comum? Todas apontam para o mesmo caminho: programar bem não é escrever código complicado, é escrever código **claro**. Um `if/else` bem escrito, com nomes de variáveis que fazem sentido, vale mais do que qualquer truque chamativo.

---

## Capítulo 9 - Para Continuar Estudando: Livros e Leituras

Se você curtiu essa aula e quer se aprofundar, aqui vão algumas leituras clássicas usadas em cursos de programação no Brasil:

- **Ana Fernanda Gomes Ascencio e Edilene Aparecida Campos** — *Fundamentos de Programação de Computadores: Algoritmos, Pascal, C/C++ e Java*. Um dos livros mais usados em disciplinas introdutórias de programação nas universidades brasileiras, com muitos exercícios de lógica e estruturas condicionais.
- **Deitel & Deitel** — *Java: Como Programar*. Referência clássica e extremamente completa sobre a linguagem Java, do básico ao avançado.
- **Robert Sebesta** — *Conceitos de Linguagens de Programação*. Ajuda a entender o "porquê" por trás de comandos como `if` e `else` em diferentes linguagens.

> Dica: procure esses títulos por nome e edição em sebos, bibliotecas universitárias ou livrarias — as edições variam bastante de ano para ano.

---

## Capítulo 10 - Resumo da Aula

- `if` executa um bloco de código **somente** se a condição for verdadeira.
- `else` executa um bloco alternativo quando a condição do `if` é falsa.
- `else if` permite encadear várias condições, testadas em ordem, até encontrar a primeira verdadeira.
- Condições são construídas com operadores relacionais (`==`, `!=`, `>`, `<`, `>=`, `<=`) e podem ser combinadas com operadores lógicos (`&&`, `||`, `!`).
- Para comparar `String`, use `.equals()` em vez de `==`.
- Um bom programador escreve condições claras — como dizia Dijkstra, simplicidade é o caminho para a confiabilidade.

---

*Continue para a pasta [`exercicios-condicionais/`](./exercicios-condicionais) e tente resolver os 5 desafios propostos usando tudo que você aprendeu aqui!*
