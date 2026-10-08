# Curso Completo de C — Do Zero ao Avançado

*Continuação de `capitulo-3-c.md` (Capítulo 3 — Operações Básicas e Aritmética Computacional). Capítulos anteriores: `curso-c.md` (1) e `capitulo-2-c.md` (2).*

---

# Capítulo 4 — Controle de Fluxo

## 4.1 Por que "controle de fluxo"?

Até agora, todo programa que escrevemos executa suas instruções em sequência linear, de cima para baixo, uma única vez. Controle de fluxo é o conjunto de construções que permite ao programa **decidir** (executar um bloco ou outro, dependendo de uma condição) e **repetir** (executar o mesmo bloco várias vezes). São essas duas capacidades — decisão e repetição — que separam um programa de verdade de uma simples lista de instruções.

No nível da CPU, controle de fluxo é implementado por instruções de **desvio** (*jump*/*branch*): em vez de executar a próxima instrução em sequência, o processador pula para outro endereço de memória do código, condicionalmente ou não. Toda vez que você escreve um `if` ou um `for` em C, o compilador traduz isso para uma sequência de comparações e desvios em Assembly.

## 4.2 A Condicional `if` / `else if` / `else`

### 4.2.1 Sintaxe básica

```c
if (condicao) {
    // executado se condicao for verdadeira (diferente de 0)
} else {
    // executado se condicao for falsa (igual a 0)
}
```

Em C, **não existe um tipo `boolean` nativo antes do C23** — qualquer expressão numérica é usada como condição: `0` é considerado falso, e **qualquer valor diferente de zero** é considerado verdadeiro (incluindo negativos).

```c
int idade = 20;
if (idade >= 18) {
    printf("Maior de idade\n");
} else {
    printf("Menor de idade\n");
}
```

### 4.2.2 Encadeando condições com `else if`

```c
int nota = 75;
if (nota >= 90) {
    printf("A\n");
} else if (nota >= 70) {
    printf("B\n");
} else if (nota >= 50) {
    printf("C\n");
} else {
    printf("Reprovado\n");
}
```

Cada `else if` só é avaliado se todas as condições anteriores forem falsas — assim que uma condição é verdadeira, o resto da cadeia é ignorado.

### 4.2.3 O perigo do `if` sem chaves

```c
if (idade >= 18)
    printf("Maior de idade\n");
    printf("Bem-vindo\n"); // ATENÇÃO: esta linha SEMPRE executa!
```

Sem chaves `{ }`, o `if` em C só controla a **próxima instrução única** — a indentação visual não tem nenhum efeito sobre o que pertence ao bloco. A segunda linha acima parece estar "dentro" do `if` por causa da indentação, mas na verdade sempre é executada, esteja a condição verdadeira ou não. **Regra prática: sempre use chaves, mesmo para um bloco de uma linha só.**

## 4.3 O Laço `while`

```c
int i = 0;
while (i < 5) {
    printf("%d\n", i);
    i++;
}
```

O `while` testa a condição **antes** de cada execução do bloco — se a condição já começar falsa, o bloco nunca executa nem uma vez.

## 4.4 O Laço `do-while`

```c
int i = 0;
do {
    printf("%d\n", i);
    i++;
} while (i < 5);
```

Diferente do `while`, o `do-while` testa a condição **depois** de cada execução — o bloco sempre executa **pelo menos uma vez**, mesmo que a condição comece falsa. É a escolha certa para situações como "peça um número até que o usuário digite um valor válido", em que você precisa executar o corpo ao menos uma vez antes de ter algo para testar.

## 4.5 O Laço `for`

```c
for (int i = 0; i < 5; i++) {
    printf("%d\n", i);
}
```

O `for` tem três partes, separadas por `;`, todas opcionais:

1. **Inicialização** (`int i = 0`) — executada uma única vez, antes do laço começar.
2. **Condição** (`i < 5`) — testada antes de cada iteração, igual ao `while`.
3. **Incremento** (`i++`) — executado ao final de cada iteração, antes de testar a condição de novo.

Um `for` é, na prática, apenas uma forma mais compacta de escrever um `while` — o compilador os traduz para a mesma coisa:

```c
int i = 0;
while (i < 5) {
    printf("%d\n", i);
    i++;
}
```

## 4.6 `break` e `continue`

- `break` encerra o laço **imediatamente**, pulando para a primeira instrução depois dele.
- `continue` pula **o restante da iteração atual**, indo direto para o teste da condição (ou para o incremento, no caso do `for`).

```c
for (int i = 0; i < 10; i++) {
    if (i == 5) break;       // para no 5
    if (i % 2 == 0) continue; // pula os pares
    printf("%d\n", i);        // só imprime 1 e 3
}
```

---

## 4.7 🚀🔬🏆 Decisões e Repetições que Mudaram a História

Os três casos desta seção mostram como `if`, laços e suas condições de parada já determinaram o resultado de missões espaciais, algoritmos quânticos e disputas de maratona.

### 4.7.1 🛰️ [Aeroespacial] O Apollo 11 quase abortou o pouso por causa de um laço sobrecarregado

> Hamilton, M. H. **"Computer Got Loaded"**, relatos técnicos sobre o software do Apollo Guidance Computer (AGC), MIT Instrumentation Laboratory, 1969 (documentado posteriormente em diversas publicações da NASA e do MIT).

Durante a descida final do módulo lunar Eagle, em 1969, o computador de bordo (AGC) começou a disparar os alarmes `1202` e `1201` — o laço principal de controle estava recebendo mais tarefas do que conseguia processar a tempo, porque um radar auxiliar, deixado ligado por engano, estava competindo por ciclos de processamento. O software foi projetado com um mecanismo de prioridade que descartava tarefas de baixa prioridade quando o laço ficava sobrecarregado, permitindo que o pouso continuasse com segurança.

**A parte mais importante para você, agora:** um laço (`while`, `for`) que roda indefinidamente — como o laço principal de um computador de bordo — precisa ser projetado para lidar com o caso em que o corpo do laço demora mais do que o esperado para executar. Isso é a semente do conceito de **sistemas de tempo real**, que você vai encontrar de novo se seguir a trilha aeroespacial.

### 4.7.2 🔬 [Computação Quântica] O "loop" que o algoritmo de Grover usa para buscar mais rápido

> Grover, L. K. **"A Fast Quantum Mechanical Algorithm for Database Search"**. Proceedings of the 28th ACM Symposium on Theory of Computing (STOC), 1996.

O algoritmo de Grover resolve o problema de busca em uma lista não ordenada repetindo, em um laço, uma operação quântica chamada "iteração de Grover" aproximadamente √N vezes (em vez das N tentativas que um laço clássico precisaria no pior caso). A condição de parada desse laço quântico não é um simples `i < N` — é um número de iterações calculado matematicamente a partir do tamanho do espaço de busca.

**A parte mais importante para você, agora:** a lógica de "repita até a condição certa" que você acabou de aprender com `for` e `while` é universal — ela aparece até em algoritmos quânticos, só que a *condição de parada* e o que acontece "dentro do corpo do laço" mudam radicalmente de complexidade.

### 4.7.3 🏆 [Programação Competitiva] O `break` que evita Time Limit Exceeded

> Laaksonen, A. **"Guide to Competitive Programming"**, Capítulo sobre eficiência de algoritmos e complexidade de tempo, 2ª ed., Springer, 2020.

Um erro comum e caro em maratonas é escrever um laço que continua procurando por uma resposta mesmo depois de já tê-la encontrado — o programa funciona, mas estoura o limite de tempo (*Time Limit Exceeded*, TLE) porque continua executando iterações desnecessárias. A prática recomendada, destacada na literatura de programação competitiva, é usar `break` assim que a condição de parada real do problema é satisfeita, em vez de deixar o laço rodar até o fim do intervalo original.

**A parte mais importante para você, agora:** `break` não é só uma conveniência sintática — em um laço que roda milhões de vezes, parar um instante mais cedo é, literalmente, a diferença entre uma solução aceita e uma rejeitada por tempo.

---

## 4.8 Exercícios Resolvidos

### Exercício 1 — Par ou ímpar com `if`/`else`

**Enunciado:** leia um número inteiro e informe se é par ou ímpar.

```c
#include <stdio.h>

int main() {
    int n;
    printf("Digite um numero: ");
    scanf("%d", &n);

    if (n % 2 == 0) {
        printf("Par\n");
    } else {
        printf("Impar\n");
    }

    return 0;
}
```

**Comentário sobre a lógica:** usa o operador `%` (Capítulo 3) como condição — o resto da divisão por 2 só pode ser 0 (par) ou diferente de 0, que em C já é tratado como verdadeiro no `else`.

---

### Exercício 2 — Tabuada com `for`

**Enunciado:** leia um número e exiba sua tabuada de 1 a 10.

```c
#include <stdio.h>

int main() {
    int n;
    printf("Digite um numero: ");
    scanf("%d", &n);

    for (int i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", n, i, n * i);
    }

    return 0;
}
```

**Comentário sobre a lógica:** fixação pura da sintaxe do `for`, com a variável de controle `i` usada diretamente dentro do cálculo do corpo do laço.

---

### Exercício 3 — Validação de entrada com `do-while`

**Enunciado:** peça repetidamente um número entre 1 e 10 até que o usuário digite um valor válido.

```c
#include <stdio.h>

int main() {
    int n;

    do {
        printf("Digite um numero entre 1 e 10: ");
        scanf("%d", &n);
    } while (n < 1 || n > 10);

    printf("Voce digitou: %d\n", n);

    return 0;
}
```

**Comentário sobre a lógica:** exemplo canônico de `do-while` — o corpo precisa executar pelo menos uma vez (para pedir o número pela primeira vez) antes de haver qualquer valor para testar na condição.

---

### Exercício 4 — Soma dos pares com `continue`

**Enunciado:** some todos os números pares entre 1 e 20, pulando os ímpares com `continue`.

```c
#include <stdio.h>

int main() {
    int soma = 0;

    for (int i = 1; i <= 20; i++) {
        if (i % 2 != 0) continue;
        soma += i;
    }

    printf("Soma dos pares: %d\n", soma);

    return 0;
}
```

**Comentário sobre a lógica:** `continue` pula direto para o incremento (`i++`) sempre que `i` é ímpar, sem executar `soma += i` — uma alternativa ao uso de `if`/`else` aninhado.

---

### Exercício 5 — Busca com `break` ao encontrar o alvo

**Enunciado:** percorra os números de 1 a 100 e pare assim que encontrar o primeiro múltiplo de 7 e de 3 ao mesmo tempo.

```c
#include <stdio.h>

int main() {
    int encontrado = -1;

    for (int i = 1; i <= 100; i++) {
        if (i % 7 == 0 && i % 3 == 0) {
            encontrado = i;
            break;
        }
    }

    printf("Primeiro numero encontrado: %d\n", encontrado);

    return 0;
}
```

**Comentário sobre a lógica:** usa `&&` (operador lógico E, que vimos na introdução do Capítulo 1) para combinar duas condições, e `break` para parar assim que a resposta é encontrada — exatamente a prática da seção 4.7.3 sobre evitar iterações desnecessárias.

---

## 4.9 Exercícios Propostos

**Fácil**

1. Leia três números e exiba o maior deles, usando apenas `if`/`else if`/`else`.
2. Exiba todos os números de 1 a 20 usando um laço `while`.

**Médio**

3. Leia um número e verifique se ele é primo, usando um laço `for` que testa divisores de 2 até o próprio número menos 1.
4. Escreva um menu simples com `do-while`: exiba três opções numeradas, leia a escolha do usuário, e repita o menu até que ele digite a opção "Sair".

**Difícil**

5. Implemente o jogo "Adivinhe o número": o programa "pensa" em um número fixo no código (por exemplo, 42), e o usuário tenta adivinhar em um laço `while (1)` (infinito), recebendo dicas de "maior" ou "menor" a cada tentativa, até acertar — quando acertar, use `break` para sair do laço infinito.

---

## Resumo do Capítulo 4

- Controle de fluxo em C se resume a decisão (`if`/`else if`/`else`) e repetição (`while`, `do-while`, `for`).
- Em C, qualquer valor diferente de zero é "verdadeiro"; só o zero é "falso" — não existe tipo booleano nativo antes do C23.
- `if` sem chaves só controla a próxima instrução única, não o bloco indentado visualmente — sempre use chaves.
- `while` testa antes (pode nunca executar); `do-while` testa depois (sempre executa ao menos uma vez).
- `for` é um `while` mais compacto, com inicialização, condição e incremento declarados juntos.
- `break` encerra o laço imediatamente; `continue` pula para a próxima iteração.
- O alarme 1202 da Apollo 11, o algoritmo de Grover e a disciplina de evitar Time Limit Exceeded em maratonas mostram que a lógica de repetição que você acabou de aprender escala desde sistemas embarcados críticos até algoritmos quânticos.

---

*Aula anterior: Capítulo 3 — Operações Básicas e Aritmética Computacional (`capitulo-3-c.md`).*
*Próxima aula: Capítulo 5 — Funções (declaração, parâmetros por valor, escopo, recursão).*
