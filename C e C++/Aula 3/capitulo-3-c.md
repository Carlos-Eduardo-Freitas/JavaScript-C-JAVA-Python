# Curso Completo de C — Do Zero ao Avançado

*Continuação de `capitulo-2-c.md` (Capítulo 2 — Armazenamento, Tipos de Dados e Variáveis). Se ainda não leu, comece por lá. O Capítulo 1 está em `curso-c.md`.*

---

# Capítulo 3 — Operações Básicas e Aritmética Computacional

## 3.1 Operadores Aritméticos

| Operador | Significado | Exemplo |
|---|---|---|
| `+` | soma | `a + b` |
| `-` | subtração | `a - b` |
| `*` | multiplicação | `a * b` |
| `/` | divisão | `a / b` |
| `%` | resto da divisão (módulo) | `a % b` |

O operador `%` (módulo) só é definido para tipos inteiros em C — não existe `%` entre `double`s. Para resto de ponto flutuante, a biblioteca padrão oferece `fmod()` (de `<math.h>`), que veremos mais adiante.

## 3.2 Precedência de Operadores

C segue a mesma hierarquia matemática que você já conhece: multiplicação e divisão antes de soma e subtração, e parênteses sempre têm prioridade máxima.

```c
int resultado = 2 + 3 * 4;   // 14, não 20
int resultado2 = (2 + 3) * 4; // 20
```

> **Boa prática:** mesmo quando a precedência padrão já dá o resultado certo, usar parênteses deixa a intenção explícita para quem lê o código depois — inclusive você mesmo, daqui a seis meses.

## 3.3 Divisão Inteira vs. Divisão de Ponto Flutuante

Este é o erro aritmético mais comum entre iniciantes em C.

```c
int a = 7, b = 2;
printf("%d\n", a / b); // imprime 3, não 3.5!
```

Quando **ambos os operandos** de `/` são inteiros, C realiza **divisão inteira**: o resultado é truncado (a parte fracionária é descartada, não arredondada). Para obter o resultado fracionário, pelo menos um dos operandos precisa ser de ponto flutuante:

```c
double resultado = (double)a / b; // 3.5
```

### 3.3.1 Casting: conversão implícita e explícita

- **Conversão implícita:** quando você mistura tipos numa expressão (como `int` e `double`), o compilador converte automaticamente o tipo "menor" para o tipo "maior" antes de calcular — nesse caso, `int` vira `double`.
- **Conversão explícita (cast):** você força a conversão colocando o tipo desejado entre parênteses antes do valor, como em `(double)a` acima. Isso é necessário quando você quer controlar exatamente onde a conversão acontece.

```c
int a = 7, b = 2;
double errado = a / b;           // calcula 3 (int) e DEPOIS converte para double: 3.0
double certo = (double)a / b;    // converte a para double ANTES de dividir: 3.5
```

Repare na diferença: no primeiro caso, a divisão inteira já aconteceu antes de qualquer conversão — o cast tem que vir **antes** da operação, não depois do resultado.

## 3.4 Operadores de Atribuição Composta

| Operador | Equivalente |
|---|---|
| `+=` | `a = a + b` |
| `-=` | `a = a - b` |
| `*=` | `a = a * b` |
| `/=` | `a = a / b` |
| `%=` | `a = a % b` |

```c
int saldo = 100;
saldo -= 30; // saldo agora é 70
```

## 3.5 Incremento e Decremento: Pré vs. Pós

C oferece atalhos para somar ou subtrair 1 de uma variável: `++` (incremento) e `--` (decremento). A diferença crucial está em **quando** o valor é alterado em relação ao resto da expressão.

```c
int x = 5;
int y = x++; // y recebe 5 (valor ANTES do incremento), x vira 6
```

```c
int x = 5;
int y = ++x; // x vira 6 PRIMEIRO, y recebe 6
```

No nível da instrução de máquina: `x++` lê o valor atual de `x`, usa esse valor na expressão, e só depois escreve `x + 1` de volta na memória. `++x` faz o inverso — escreve `x + 1` na memória primeiro, e só então o novo valor é usado na expressão. Quando o incremento aparece sozinho em uma linha (`x++;`), não há diferença prática entre as duas formas — a diferença só importa quando o resultado é usado na mesma expressão.

---

## 3.6 📚 Leituras Complementares — Material do Professor

Os livros que você enviou têm capítulos específicos que aprofundam exatamente o que vimos aqui:

- **Kernighan & Ritchie, "The C Programming Language" (2ª ed.)** — Capítulo 2 (Types, Operators and Expressions) é a referência canônica sobre precedência, conversão de tipos e os operadores de incremento/decremento, escrita pelos próprios criadores da linguagem.
- **Herbert Schildt, "Linguagem C"** — tem uma seção dedicada inteiramente aos operadores aritméticos e de atribuição, com tabelas de precedência completas (incluindo operadores que ainda não vimos, como bitwise).

Os outros materiais que você mandou — os slides de **Filas, Pilhas, Listas, Deques, Conjuntos e Mapeamentos** do IFB, e os livros de programação competitiva (**Laaksonen**, **Halim**, **Arefin**) — vão entrar no curso a partir do momento em que tivermos ponteiros, structs e alocação dinâmica no repertório (eles pressupõem esse conhecimento, inclusive os exemplos de código já usam `std::queue`, `std::set` etc., que são C++ e não C puro). Quando chegarmos lá, vou puxar esses slides diretamente para as aulas de estruturas de dados.

---

## 3.7 Exercícios Resolvidos

### Exercício 1 — Divisão inteira vs. real

**Enunciado:** leia dois inteiros e exiba a divisão entre eles tanto como inteiro quanto como `double`.

```c
#include <stdio.h>

int main() {
    int a, b;
    printf("Digite dois inteiros: ");
    scanf("%d %d", &a, &b);

    printf("Divisao inteira: %d\n", a / b);
    printf("Divisao real: %.2f\n", (double)a / b);

    return 0;
}
```

**Comentário sobre a lógica:** exercício direto de fixação da diferença entre as duas divisões, reforçando que o cast precisa vir antes da operação.

---

### Exercício 2 — Conversão de segundos em horas, minutos e segundos

**Enunciado:** leia uma quantidade de segundos e decomponha em horas, minutos e segundos restantes.

```c
#include <stdio.h>

int main() {
    int totalSegundos;
    printf("Digite o total de segundos: ");
    scanf("%d", &totalSegundos);

    int horas = totalSegundos / 3600;
    int minutos = (totalSegundos % 3600) / 60;
    int segundos = totalSegundos % 60;

    printf("%dh %dm %ds\n", horas, minutos, segundos);

    return 0;
}
```

**Comentário sobre a lógica:** combina divisão inteira (para "quantos blocos de 3600 cabem") com módulo (para "o que sobra depois de tirar os blocos completos") — o par divisão/módulo é a ferramenta clássica para decompor uma quantidade em unidades diferentes.

---

### Exercício 3 — Pré-incremento dentro de uma expressão

**Enunciado:** mostre, com código, a diferença de resultado entre `x++` e `++x` dentro de uma soma.

```c
#include <stdio.h>

int main() {
    int x = 10;
    int resultado1 = x++ + 5; // usa 10, DEPOIS x vira 11
    printf("resultado1 = %d, x = %d\n", resultado1, x);

    x = 10;
    int resultado2 = ++x + 5; // x vira 11 PRIMEIRO, usa 11
    printf("resultado2 = %d, x = %d\n", resultado2, x);

    return 0;
}
```

**Comentário sobre a lógica:** `resultado1` é 15 e `resultado2` é 16 — mesmo valor inicial de `x`, resultados diferentes, só pela posição do operador.

---

### Exercício 4 — Cálculo de troco com atribuição composta

**Enunciado:** leia o valor de uma compra e o valor pago, e calcule o troco usando `-=`.

```c
#include <stdio.h>

int main() {
    double valorPago, valorCompra;
    printf("Valor da compra: ");
    scanf("%lf", &valorCompra);
    printf("Valor pago: ");
    scanf("%lf", &valorPago);

    valorPago -= valorCompra; // valorPago agora guarda o troco
    printf("Troco: %.2f\n", valorPago);

    return 0;
}
```

**Comentário sobre a lógica:** reforça que `-=` modifica a própria variável — aqui reaproveitamos `valorPago` para guardar o troco, em vez de criar uma terceira variável, para fixar a mecânica do operador.

---

### Exercício 5 — Área de um círculo com `M_PI`

**Enunciado:** leia o raio de um círculo e calcule sua área.

```c
#include <stdio.h>
#define _USE_MATH_DEFINES
#include <math.h>

int main() {
    double raio;
    printf("Digite o raio: ");
    scanf("%lf", &raio);

    double area = M_PI * raio * raio;
    printf("Area: %.4f\n", area);

    return 0;
}
```

**Comentário sobre a lógica:** introduz `<math.h>` e a constante `M_PI`, e reforça a precedência (multiplicação antes de qualquer outra coisa na expressão, sem necessidade de parênteses extras).

---

## 3.8 Exercícios Propostos

**Fácil**

1. Leia dois números inteiros e exiba sua soma, subtração, multiplicação, divisão (como `double`) e resto da divisão.
2. Leia um valor em Celsius e converta para Fahrenheit usando a fórmula `F = C * 9.0/5.0 + 32`. Explique, em comentário, por que `9.0/5.0` precisa ter o `.0` e não pode ser `9/5`.

**Médio**

3. Leia um valor em reais e calcule quantas notas de 100, 50, 20, 10, 5 e 1 são necessárias para formar esse valor, usando divisão inteira e módulo em sequência (como no Exercício 2).
4. Escreva um programa que leia um número inteiro e mostre, lado a lado, o valor de `x++` e `++x` quando aplicados ao mesmo `x` em expressões separadas, comentando a diferença no código.

**Difícil**

5. Calcule a média ponderada de três notas (pesos 2, 3 e 5) lidas do usuário, usando `+=` para acumular o numerador da fórmula antes de dividir pela soma dos pesos. Tome cuidado especial com a ordem de operações para não cair em divisão inteira sem perceber.

---

## Resumo do Capítulo 3

- A hierarquia de operadores em C segue a matemática padrão: `*` e `/` antes de `+` e `-`, parênteses sempre primeiro.
- Divisão entre dois inteiros é sempre inteira (truncada) em C — para divisão real, pelo menos um operando precisa virar `double`, com cast feito **antes** da divisão.
- `+=`, `-=`, `*=`, `/=`, `%=` modificam a própria variável, evitando repetir o nome dela duas vezes.
- `x++` usa o valor atual e incrementa depois; `++x` incrementa primeiro e usa o novo valor — a diferença só importa quando o incremento está dentro de uma expressão maior.
- K&R e Schildt têm os capítulos de referência para aprofundar operadores; os materiais sobre estruturas de dados entram no curso a partir dos capítulos de ponteiros e structs.

---

*Aula anterior: Capítulo 2 — Armazenamento, Tipos de Dados e Variáveis (`capitulo-2-c.md`).*
*Próxima aula: Capítulo 4 — Controle de Fluxo (condicionais `if`/`else`, laços `for`/`while`/`do-while`).*
