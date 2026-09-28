# Curso Completo de C — Do Zero ao Avançado

*Continuação de `curso-c.md` (Capítulo 1 — Fundações, História e o Primeiro Contato). Se ainda não leu, comece por lá antes de seguir.*

---

# Capítulo 2 — Armazenamento, Tipos de Dados e Variáveis

## 2.1 O Conceito de Memória: o que É uma Variável de Verdade

Quando você escreve `int idade;` em C, algo concreto acontece no hardware: o compilador reserva um bloco contíguo de bytes na memória RAM — no caso de um `int` em arquitetura x86/x64 moderna, **4 bytes** — e associa esse bloco ao nome `idade` **apenas durante a compilação**. No binário final, o nome `idade` já não existe mais; o que existe é um **endereço de memória** (algo como `0x7ffee2a1b04c`), e todas as instruções que "usam" `idade` na verdade leem e escrevem diretamente nesse endereço.

Isso é diferente de linguagens como Python ou JavaScript, em que uma variável é uma referência para um objeto gerenciado por um runtime. Em C, **uma variável é, literalmente, um endereço mais um tamanho em bytes mais uma forma de interpretar esses bytes** (o tipo). É essa tríade — endereço, tamanho, interpretação — que veremos se repetir em praticamente todo capítulo futuro (especialmente no de ponteiros).

Você pode inclusive visualizar o endereço de uma variável usando o especificador `%p` do `printf` (veremos isso na seção 2.4), o que torna esse conceito tangível desde já, em vez de abstrato.

## 2.2 Tipos de Dados Primitivos

### 2.2.1 Tabela detalhada — arquitetura x86/x64 moderna

| Tipo | Modificadores possíveis | Tamanho típico (x86/x64) | Faixa de valores (versão padrão) |
|---|---|---|---|
| `char` | `signed`, `unsigned` | 1 byte | -128 a 127 (signed) / 0 a 255 (unsigned) |
| `short` (int) | `signed`, `unsigned` | 2 bytes | -32.768 a 32.767 |
| `int` | `signed`, `unsigned` | 4 bytes | -2.147.483.648 a 2.147.483.647 |
| `long` | `signed`, `unsigned` | 8 bytes (Linux/macOS 64-bit) / 4 bytes (Windows 64-bit) | depende do SO — cuidado ao portar código |
| `long long` | `signed`, `unsigned` | 8 bytes | -9,2 quintilhões a 9,2 quintilhões |
| `float` | — | 4 bytes | ponto flutuante, ~7 dígitos decimais de precisão |
| `double` | — | 8 bytes | ponto flutuante, ~15-16 dígitos decimais de precisão |

> **Observação de engenharia:** repare que `long` tem tamanho **diferente entre sistemas operacionais** (isso é chamado de "modelo de dados" — o Linux/macOS usam o modelo LP64, o Windows usa LLP64). Esse é um detalhe que já causou bugs reais em código portado entre plataformas, e é uma das razões pelas quais, mais adiante, você vai preferir tipos de tamanho fixo como `int32_t` e `int64_t` (do cabeçalho `<stdint.h>`) em código sério.

### 2.2.2 `signed` vs `unsigned`: o que muda na memória

O número de bits **não muda** entre `signed` e `unsigned` — o que muda é **como os mesmos bits são interpretados**. Um `unsigned char` de 8 bits sempre representa valores de 0 a 255. Um `signed char` de 8 bits usa o esquema de **complemento de dois** (*two's complement*), reservando o bit mais significativo para indicar o sinal, o que desloca a faixa para -128 a 127 — mesma quantidade de valores possíveis (256), apenas deslocada.

## 2.3 Declaração e Inicialização: o Perigo do "Lixo de Memória"

Quando você declara uma variável sem inicializá-la...

```c
int contador;
printf("%d\n", contador); // comportamento indefinido!
```

...o compilador **não zera automaticamente** esse espaço de memória por padrão. O valor exibido será **o que já estava naquele endereço de RAM antes**, deixado por outro programa ou por uma execução anterior do seu próprio programa. Isso é chamado de **"lixo de memória"** (*garbage value*), e é uma das fontes mais clássicas de bugs difíceis de reproduzir em C — porque o valor pode até "parecer certo" algumas vezes e mudar em outras execuções.

**Regra prática:** sempre inicialize uma variável no momento da declaração, a menos que você tenha uma razão explícita e documentada para não fazer isso (por exemplo, por questão de performance em um `array` muito grande que será totalmente preenchido logo em seguida de qualquer forma).

```c
int contador = 0; // seguro
```

## 2.4 Entrada e Saída Padrão: `printf` e `scanf` a Fundo

### 2.4.1 Especificadores de formato

| Especificador | Tipo esperado | Exemplo |
|---|---|---|
| `%d` | `int` | `printf("%d", 10);` |
| `%f` | `float`/`double` (na saída, ambos usam `%f`) | `printf("%.2f", 3.14159);` → `3.14` |
| `%c` | `char` | `printf("%c", 'A');` |
| `%s` | string (`char*`) | `printf("%s", "ola");` |
| `%p` | ponteiro/endereço | `printf("%p", &contador);` |
| `%u` | `unsigned int` | `printf("%u", 4000000000u);` |
| `%ld` | `long` | `printf("%ld", 10000000000L);` |
| `%lld` | `long long` | `printf("%lld", numeroGrande);` |

> **Atenção — assimetria entre `printf` e `scanf`:** ao **ler** um `double` com `scanf`, o especificador correto é `%lf`, não `%f` (mesmo que, ao **exibir** um `double` com `printf`, `%f` funcione perfeitamente). Isso é uma pegadinha histórica da linguagem que confunde muitos iniciantes.

```c
double altura;
scanf("%lf", &altura); // lf para ler double
printf("%f\n", altura); // f para exibir double
```

Note também o `&` antes de `altura` no `scanf` — ele passa o **endereço** da variável, não o valor, porque `scanf` precisa **escrever** na memória que você reservou (voltaremos a isso com muito mais profundidade no capítulo de ponteiros).

---

## 2.5 🚀🧬🏆 Quando um Tipo de Dado Vira Manchete: Artigos e Casos Reais

Tipo de dado errado não é só "erro de prova" — já derrubou foguete, perdeu sonda espacial e ainda hoje derruba soluções inteiras em maratona de programação. Sete casos reais, ligados a Computação Quântica, Sistemas Aeroespaciais e Programação Competitiva, para você nunca mais encarar `int` vs `long long` como detalhe bobo:

### 2.5.1 🛰️ [Aeroespacial] O desastre do Ariane 5 — quando um tipo de dado explode um foguete

> Lions, J. L. et al. **"ARIANE 5 Flight 501 Failure — Report by the Inquiry Board"**. ESA/CNES, 1996.

Em 4 de junho de 1996, o foguete Ariane 5 se autodestruiu 37 segundos após o lançamento. A causa raiz, segundo o relatório oficial da comissão de investigação, foi uma conversão de um valor de ponto flutuante de 64 bits (representando a velocidade horizontal) para um inteiro de 16 bits no software de referência inercial — um valor grande demais para caber nesse tipo, causando um **overflow**. O software não tinha tratamento de exceção para esse caso específico, e a falha derrubou o sistema de guiamento por completo.

**A parte mais importante para você, agora:** a tabela da seção 2.2.1 não é decoreba — escolher um tipo pequeno demais para o valor real que ele vai armazenar é, historicamente, um erro capaz de destruir um foguete de centenas de milhões de dólares.

### 2.5.2 🛰️ [Aeroespacial/Segurança] As "10 Regras" da JPL/NASA para código crítico em C

> Holzmann, G. J. **"The Power of 10: Rules for Developing Safety-Critical Code"**. IEEE Computer, 2006.

Gerard Holzmann, do Jet Propulsion Laboratory (JPL) da NASA, propôs dez regras restritivas para código C usado em sistemas críticos (sondas espaciais, por exemplo). Duas delas conversam diretamente com o que vimos neste capítulo: declarar variáveis com o **menor escopo possível** e **sempre verificar o valor de retorno** de operações de entrada de dados.

**A parte mais importante para você, agora:** a regra "sempre inicialize e verifique suas variáveis" (seção 2.3) não é apenas boa prática de sala de aula — é literalmente regra formal de engenharia de software da NASA para código que voa em espaçonaves.

### 2.5.3 🛰️ [Aeroespacial] Mars Climate Orbiter — uma sonda de US$ 327 milhões perdida por incompatibilidade de unidades

> NASA. **"Mars Climate Orbiter Mishap Investigation Board — Phase I Report"**, 1999.

Em setembro de 1999, a sonda Mars Climate Orbiter se desintegrou ao entrar na atmosfera de Marte. A investigação apontou que um módulo de software calculava a força de propulsão em **libras-força** (unidade imperial), enquanto outro módulo esperava receber o valor em **newtons** (unidade métrica) — os dados numéricos trafegaram corretamente entre os sistemas, mas o **significado** por trás dos mesmos bits era diferente em cada ponta.

**A parte mais importante para você, agora:** um tipo (`double`, `float`) descreve *quantos bytes* e *como interpretar os bits* — mas não descreve sozinho o **significado** do valor. Documentar unidades e convenções junto da declaração da variável é tão importante quanto escolher o tipo certo.

### 2.5.4 🔬 [Computação Quântica] Por que simuladores quânticos dependem tanto de `double`

> Kahan, W. **"IEEE Standard 754 for Binary Floating-Point Arithmetic"**, 1997 (documentação de referência do padrão IEEE 754, do qual Kahan foi o principal arquiteto).

Um simulador de computação quântica representa o estado de um sistema de *n* qubits como um vetor de números complexos (amplitudes de probabilidade), quase sempre armazenados como pares de `double` (parte real e imaginária). O padrão IEEE 754 — que define exatamente como `float` e `double` são representados nos bits da memória (sinal, expoente, mantissa) — é o que garante que esses cálculos sejam consistentes entre computadores diferentes.

**A parte mais importante para você, agora:** quando, mais adiante neste curso, você somar dois `double` e o resultado não bater "exatamente" com o que esperava na calculadora, não é bug do seu código — é a natureza da representação binária de ponto flutuante, a mesma questão que simuladores quânticos profissionais precisam administrar com extremo cuidado.

### 2.5.5 🔬 [Computação Quântica] Shor e o algoritmo que assusta a criptografia — e exige números gigantes

> Shor, P. W. **"Polynomial-Time Algorithms for Prime Factorization and Discrete Logarithms on a Quantum Computer"**. SIAM Journal on Computing, 1997.

O algoritmo de Shor mostra como um computador quântico poderia fatorar números inteiros gigantes (centenas de dígitos, como os usados em criptografia RSA) em tempo polinomial — algo inviável para computadores clássicos. Simuladores clássicos que tentam reproduzir esse processo em C esbarram imediatamente num limite prático: nenhum tipo primitivo da tabela da seção 2.2.1 (nem `long long`) consegue armazenar números com centenas de dígitos.

**A parte mais importante para você, agora:** isso é a primeira pista, ainda neste capítulo introdutório, de por que mais adiante no curso você vai aprender **structs** e **alocação dinâmica** — para representar números "grandes o suficiente" que nenhum tipo primitivo sozinho comporta.

### 2.5.6 🏆 [Programação Competitiva] Por que `unordered_map` pode ser "hackeado" em maratonas

> Carter, J. L.; Wegman, M. N. **"Universal Classes of Hash Functions"**. Journal of Computer and System Sciences, 1979.

Esse artigo é a base teórica por trás das tabelas hash — a estrutura usada, por exemplo, no `unordered_map` do C++ ou em implementações manuais de hash em C. Em maratonas de programação (Codeforces, ICPC), é um fato conhecido que times adversários conseguem submeter **casos de teste projetados propositalmente** para colidir com uma função hash previsível, degradando a performance de O(1) para O(n) por acesso.

**A parte mais importante para você, agora:** a "assinatura" usada para gerar um hash normalmente vem de valores inteiros (`int`, `long long`) — entender exatamente como esses tipos são armazenados na memória (seção 2.2) é o primeiro passo para, futuramente, entender por que certos hashes são previsíveis e outros não.

### 2.5.7 🏆 [Programação Competitiva] O bug nº 1 de quem começa em maratonas: overflow silencioso

> Dietz, W.; Li, P.; Regehr, J.; Adve, V. **"Understanding Integer Overflow in C/C++"**. ICSE (International Conference on Software Engineering), 2012.

Esse estudo analisou, de forma sistemática, o quão comum é o overflow de inteiros em código C/C++ real — e mostrou que a linguagem, por padrão, **não avisa** quando uma conta ultrapassa o limite do tipo (diferente de uma exceção lançada por outras linguagens). Em competições como Codeforces e ICPC, esse é disparadamente o bug mais comum entre iniciantes: declarar um resultado como `int` quando o valor real (por exemplo, o produto de dois números grandes) ultrapassa 2,1 bilhões.

**A parte mais importante para você, agora:** a "regra de ouro" que todo competidor aprende cedo — "na dúvida, use `long long`" — não é superstição, é resposta direta a um problema medido e documentado cientificamente.

---

## 2.6 Exercícios Resolvidos

### Exercício 1 — Declarando e exibindo cada tipo primitivo

**Enunciado:** declare uma variável de cada tipo primitivo (`int`, `float`, `double`, `char`) já inicializada, e exiba todas com `printf`.

```c
#include <stdio.h>

int main() {
    int quantidade = 42;
    float peso = 3.5f;
    double distancia = 384400.0;
    char inicial = 'C';

    printf("quantidade = %d\n", quantidade);
    printf("peso = %f\n", peso);
    printf("distancia = %f\n", distancia);
    printf("inicial = %c\n", inicial);

    return 0;
}
```

**Comentário sobre a lógica:** exercício de fixação pura da sintaxe de declaração, reforçando o sufixo `f` para literais `float`.

---

### Exercício 2 — Tamanho real em bytes com `sizeof`

**Enunciado:** exiba, usando o operador `sizeof`, o tamanho em bytes de cada tipo primitivo na sua máquina.

```c
#include <stdio.h>

int main() {
    printf("sizeof(char) = %zu byte(s)\n", sizeof(char));
    printf("sizeof(int) = %zu byte(s)\n", sizeof(int));
    printf("sizeof(long) = %zu byte(s)\n", sizeof(long));
    printf("sizeof(float) = %zu byte(s)\n", sizeof(float));
    printf("sizeof(double) = %zu byte(s)\n", sizeof(double));
    return 0;
}
```

**Comentário sobre a lógica:** `sizeof` é um operador (não uma função de runtime) resolvido em tempo de compilação. O especificador correto para o tipo que ele retorna (`size_t`) é `%zu`, não `%d` — outra pegadinha clássica de iniciante.

---

### Exercício 3 — Demonstrando o "lixo de memória"

**Enunciado:** declare uma variável `int` sem inicializar e exiba seu valor (observe que pode variar a cada execução).

```c
#include <stdio.h>

int main() {
    int misterioso;
    printf("Valor nao inicializado: %d\n", misterioso);
    return 0;
}
```

**Comentário sobre a lógica:** este exercício existe **propositalmente para ilustrar comportamento indefinido** (seção 2.3) — o objetivo não é obter um valor "certo", e sim visualizar, na prática, que memória não inicializada não é zero por garantia.

---

### Exercício 4 — Lendo dois tipos diferentes com `scanf`

**Enunciado:** leia o nome (como `char` único inicial) e a altura (como `double`) do usuário, exibindo ambos formatados.

```c
#include <stdio.h>

int main() {
    char inicialNome;
    double altura;

    printf("Digite a inicial do seu nome: ");
    scanf(" %c", &inicialNome); // espaço antes de %c consome quebras de linha pendentes

    printf("Digite sua altura em metros: ");
    scanf("%lf", &altura);

    printf("Inicial: %c | Altura: %.2f m\n", inicialNome, altura);

    return 0;
}
```

**Comentário sobre a lógica:** o espaço antes de `%c` na string de formato é uma técnica padrão para "pular" espaços em branco e quebras de linha deixados no buffer de entrada por leituras anteriores — variação do problema do `nextInt`/`nextLine` em Java, que também existe (de forma análoga) em C.

---

### Exercício 5 — `unsigned` e o "underflow" visual

**Enunciado:** declare um `unsigned int` com valor `0`, subtraia `1`, e observe o resultado.

```c
#include <stdio.h>

int main() {
    unsigned int contador = 0;
    contador = contador - 1;
    printf("Resultado: %u\n", contador);
    return 0;
}
```

**Comentário sobre a lógica:** como `unsigned int` não representa números negativos, subtrair 1 de 0 não gera erro — os bits "dão a volta" (*wraparound*) e o resultado exibido é o maior valor possível do tipo (4.294.967.295 em uma arquitetura de 32 bits). Esse comportamento de wraparound em tipos `unsigned` é, aliás, uma fonte real de bugs de segurança catalogados em CVEs de software escrito em C.

---

## 2.7 Exercícios Propostos

**Fácil**

1. Declare três variáveis `int` já inicializadas com sua idade, o ano atual e o ano do seu nascimento, e exiba uma frase completa combinando as três.
2. Declare uma variável `char` com uma letra e exiba, ao lado dela, o valor numérico ASCII correspondente usando `%d` no lugar de `%c`.

**Médio**

3. Usando `scanf`, leia dois números `double` do usuário e exiba qual dos dois é maior (você pode usar um `if` simples, mesmo que ele só seja formalizado no próximo capítulo).
4. Repita o Exercício 5 da seção 2.6, mas agora com um `signed int` no lugar de `unsigned int`, subtraindo 1 de `0`. Compare o resultado e explique, em um comentário no próprio código, por que o comportamento é diferente.

**Difícil**

5. Escreva um programa que declare um `float` com um valor decimal "simples" (por exemplo, `0.1f`), some esse valor a ele mesmo 10 vezes em um laço (pode usar um `for`, mesmo sem tê-lo estudado formalmente ainda, apenas copiando a sintaxe `for (int i = 0; i < 10; i++) { ... }`), e exiba o resultado com `%.20f` (20 casas decimais). Observe que o resultado não é exatamente `1.0` — isso está diretamente ligado ao artigo da seção 2.5.4 sobre IEEE 754.

---

## Resumo do Capítulo 2

- Uma variável em C é, na prática, um endereço de memória + um tamanho em bytes + uma forma de interpretar esses bytes (o tipo).
- Os tipos primitivos têm tamanhos definidos pela arquitetura/sistema operacional — `long` é o caso mais traiçoeiro, variando entre Windows e Linux/macOS.
- Variáveis não inicializadas contêm "lixo de memória" — comportamento indefinido, não zero garantido.
- `scanf` para `double` exige `%lf`, mesmo que `printf` use `%f` para o mesmo tipo.
- Ariane 5, Mars Climate Orbiter e as regras da JPL/NASA mostram que escolha, validação e documentação de tipos de dados são questões de engenharia crítica, não só de sintaxe.
- IEEE 754 e o algoritmo de Shor conectam ponto flutuante e limites de tipos primitivos diretamente à computação quântica.
- Hashing (Carter & Wegman) e overflow de inteiros (Dietz et al.) são os dois bugs relacionados a tipos que mais aparecem em maratonas de programação.

---

*Aula anterior: Capítulo 1 — Fundações, História e o Primeiro Contato (`curso-c.md`).*
*Próxima aula: Capítulo 3 — Operações Básicas e Aritmética Computacional (precedência de operadores, divisão inteira vs. ponto flutuante, casting, incremento/decremento).*
