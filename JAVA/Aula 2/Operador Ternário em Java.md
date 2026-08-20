# Aula Complementar: Operador Ternário em Java

> "Simplicidade é o último grau de sofisticação." — Leonardo da Vinci

Bem-vindo a mais uma aula complementar! Se você já domina `if/else` (Aula 2), já deve ter sentido, algumas vezes, que escrever quatro ou cinco linhas só para decidir o valor de **uma única variável** parece trabalho demais. É exatamente esse problema que o operador ternário resolve.

Esta aula assume que você já estudou:
- Aula 1 — Variáveis, tipos e Scanner
- Aula 2 — if / else / else if
- Aula 3 — for, while, do-while

## Índice

1. O que é o operador ternário
2. Sintaxe e anatomia
3. Comparando com if/else, passo a passo
4. Exemplos práticos (do simples ao real)
5. Ternário dentro de println e printf
6. Ternário aninhado — poder e perigo
7. Quando usar (e quando NÃO usar)
8. Armadilhas comuns
9. Exercícios
10. Resumo final

---

## 1. O que é o operador ternário

O operador ternário é chamado assim porque é o único operador do Java que trabalha com **três operandos**: uma condição, um valor para o caso verdadeiro e um valor para o caso falso.

Ele não substitui o `if/else` como estrutura de controle geral — ele serve para um caso específico e muito comum: **escolher um valor para atribuir a uma variável (ou imprimir) com base em uma condição**.

Pensa assim: o `if/else` decide o que o programa *faz*. O ternário decide o que uma expressão *vale*.

## 2. Sintaxe e anatomia

```java
condição ? valorSeVerdadeiro : valorSeFalso
```

Vamos abrir essa frase em pedaços usando um exemplo seu:

```java
double total = (cod >= 1 && cod <= 5) ? precos[cod] * n : 0;
```

| Parte | O que é | Valor no exemplo |
|---|---|---|
| `(cod >= 1 && cod <= 5)` | a condição, um `boolean` | `true` ou `false` |
| `?` | "se a condição acima for verdadeira, então..." | — |
| `precos[cod] * n` | valor usado quando a condição é `true` | — |
| `:` | "...senão..." | — |
| `0` | valor usado quando a condição é `false` | — |

O resultado inteiro da expressão é **um único valor**, que é atribuído a `total`. O tipo desse valor precisa ser compatível dos dois lados (aqui, os dois são `double`).

## 3. Comparando com if/else, passo a passo

Toda expressão ternária pode ser reescrita como um `if/else`. Vamos fazer o caminho inverso dos seus três exemplos, para você enxergar a equivalência.

**Exemplo A — aprovação de aluno**

Ternário:
```java
System.out.println(mediaFinal >= 5 ? "Aluno aprovado." : "Aluno reprovado.");
```

Equivalente em if/else:
```java
if (mediaFinal >= 5) {
    System.out.println("Aluno aprovado.");
} else {
    System.out.println("Aluno reprovado.");
}
```

**Exemplo B — maioridade**

Ternário:
```java
String status = (idade >= 18) ? "maior de idade" : "menor de idade";
```

Equivalente:
```java
String status;
if (idade >= 18) {
    status = "maior de idade";
} else {
    status = "menor de idade";
}
```

**Exemplo C — total da compra**

Ternário:
```java
double total = (cod >= 1 && cod <= 5) ? precos[cod] * n : 0;
```

Equivalente:
```java
double total;
if (cod >= 1 && cod <= 5) {
    total = precos[cod] * n;
} else {
    total = 0;
}
```

Repare no padrão: sempre que um `if/else` serve **só** para decidir o valor de uma variável (e não faz mais nada além disso, como imprimir várias coisas ou chamar métodos diferentes), ele é candidato a virar ternário.

## 4. Exemplos práticos (do simples ao real)

**Par ou ímpar:**
```java
int n = 7;
String tipo = (n % 2 == 0) ? "par" : "ímpar";
System.out.println(n + " é " + tipo);
```

**Maior entre dois números:**
```java
int a = 10, b = 25;
int maior = (a > b) ? a : b;
System.out.println("Maior: " + maior);
```

**Preço com desconto para maiores de 60 anos:**
```java
int idade = 65;
double precoBase = 20.0;
double precoFinal = (idade >= 60) ? precoBase * 0.5 : precoBase;
System.out.printf("Preço: R$ %.2f%n", precoFinal);
```

**Situação de aprovação simples (sem exame):**
```java
double media = 6.8;
String situacao = (media >= 7) ? "Aprovado" : "Reprovado";
```

## 5. Ternário dentro de println e printf

Um detalhe importante: você **não precisa** guardar o resultado numa variável antes de usar. Dá para colocar o ternário direto dentro de um `println` ou `printf`, como você já fez:

```java
System.out.println(mediaFinal >= 5 ? "Aluno aprovado." : "Aluno reprovado.");
```

Aqui o Java calcula o valor da expressão ternária primeiro (o texto certo) e só depois manda esse texto para o `println`. Funciona porque, no fim das contas, um ternário é só uma expressão que **produz um valor** — e em qualquer lugar onde o Java espera um valor, uma expressão ternária pode entrar.

## 6. Ternário aninhado — poder e perigo

É possível colocar um ternário dentro de outro, para tratar mais de duas possibilidades:

```java
String conceito = (media >= 9) ? "A"
                 : (media >= 7) ? "B"
                 : (media >= 5) ? "C"
                 : "D";
```

Isso funciona e é usado em código real. Mas repare que já não é tão rápido de ler quanto os exemplos anteriores. A regra prática:

- **1 nível de ternário** → geralmente deixa o código mais limpo.
- **2 níveis, bem formatados** (como acima, um por linha) → ainda aceitável.
- **3 ou mais níveis, ou tudo em uma linha só** → prefira voltar para `if/else if/else`. Nesse ponto, o ternário deixa de economizar esforço e passa a exigir esforço extra para ser lido.

## 7. Quando usar (e quando NÃO usar)

**Use ternário quando:**
- O objetivo é decidir o valor de **uma única variável** ou argumento.
- As duas alternativas são simples (um valor, uma chamada curta, uma expressão).
- A condição é fácil de entender de cabeça.

**Evite ternário quando:**
- Cada ramo precisa executar **várias instruções** (como no seu código original, onde o caso "em exame" lê `n5`, imprime duas linhas e ainda calcula a média final — isso é trabalho de `if/else` normal, não de ternário).
- A condição já é complexa por si só (muitos `&&` e `||` juntos).
- Você precisaria aninhar 3+ ternários para cobrir todos os casos.

Bom exemplo de "não force o ternário" é justamente o seu programa de notas: o caso `media >= 5` faz leitura de entrada, dois `println` e um cálculo — isso continua sendo `if/else` comum. Só a linha final (aprovado/reprovado do exame) virou ternário, porque ali sim havia só uma escolha de texto.

## 8. Armadilhas comuns

**Tipos incompatíveis nos dois lados**
```java
// Erro de compilação: um lado é int, outro é String
int resultado = (x > 0) ? 1 : "negativo";
```
Os dois valores possíveis precisam ter tipos compatíveis, porque a expressão toda tem um tipo só.

**Esquecer os parênteses em condições compostas**
```java
// Funciona, mas fica difícil de ler
double total = cod >= 1 && cod <= 5 ? precos[cod] * n : 0;

// Mais claro com parênteses
double total = (cod >= 1 && cod <= 5) ? precos[cod] * n : 0;
```
Não é obrigatório, mas parênteses ao redor da condição deixam a leitura muito mais rápida.

**Efeitos colaterais dentro do ternário**
```java
// Má prática: esconde uma alteração de estado dentro de uma expressão
contador = (x > 0) ? contador++ : contador--;
```
Ternário é para **calcular um valor**, não para executar ações escondidas. Se cada lado precisa "fazer algo" além de retornar um valor, use `if/else`.

**Ternário gigante em uma linha só**
```java
String r = a > b ? (a > c ? "a" : "c") : (b > c ? "b" : "c");
```
Compila e funciona, mas ninguém lê isso rápido. Quebre em várias linhas ou volte para `if/else`.

## 9. Exercícios

Tente resolver antes de olhar qualquer solução pronta.

1. Leia um número inteiro e imprima `"positivo"`, `"negativo"` ou `"zero"` usando ternário aninhado.
2. Leia a idade de uma pessoa e imprima o valor da entrada de cinema: `R$ 10,00` para menores de 12 anos, `R$ 20,00` caso contrário — usando ternário.
3. Leia dois números e imprima o menor deles, usando ternário.
4. Reescreva, usando `if/else` comum, um ternário aninhado de 3 níveis que você mesmo escrever — para sentir na prática por que ternário grande demais atrapalha a leitura.
5. Leia uma nota de 0 a 10 e, usando ternário, monte a string `"Situação: Aprovado"` ou `"Situação: Reprovado"` (considere aprovado nota >= 6), imprimindo tudo numa única linha com `println`.

## 10. Resumo final

- O operador ternário (`condição ? valorTrue : valorFalse`) é uma forma compacta de escolher **um valor** com base em uma condição.
- Todo ternário pode ser reescrito como `if/else`, mas nem todo `if/else` deve virar ternário — só os que servem apenas para decidir um valor.
- Pode ser usado direto dentro de `println`, `printf` ou qualquer lugar que espere um valor.
- Ternário aninhado existe e é válido, mas tem um limite prático de legibilidade — passou de 2 níveis, considere voltar ao `if/else`.
- A regra de ouro: se o ramo precisa fazer mais de uma coisa (ler entrada, imprimir várias linhas, calcular algo à parte), não é trabalho de ternário.

> "Programas devem ser escritos para pessoas lerem, e só incidentalmente para máquinas executarem." — Harold Abelson

**Sugestão de leitura complementar:** capítulo sobre operadores e estruturas de decisão em *"Fundamentos da Programação de Computadores"*, de Ascencio — ele trata expressões condicionais com boa progressão de exemplos.
