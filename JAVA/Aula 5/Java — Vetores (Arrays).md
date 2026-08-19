# Aula de Java — Vetores (Arrays)

> Complemento das aulas anteriores: [Aula de Java para Iniciantes](../Aula%201/aula-java-basico.md), [Estruturas Condicionais](../Aula%202/aula-java-condicionais.md), [Estruturas de Repetição](../Aula%203/aula-java-laços.md) e [Funções e Algoritmos Clássicos](../Aula%204/aula-java-funcoes.md). Agora vamos aprender a guardar **vários valores relacionados** numa única estrutura, e usar isso para resolver problemas clássicos que aparecem em praticamente todo curso de programação.

---

## Índice

1. [Introdução: Por que Não Criar uma Variável para Cada Valor?](#capítulo-1---introdução-por-que-não-criar-uma-variável-para-cada-valor)
2. [Anatomia de um Vetor em Java](#capítulo-2---anatomia-de-um-vetor-em-java)
3. [Índices, Percurso e o .length](#capítulo-3---índices-percurso-e-o-length)
4. [Vetores e Escopo: Por que Eles Quebram a Regra do Capítulo 4 da Aula 4](#capítulo-4---vetores-e-escopo-por-que-eles-quebram-a-regra-do-capítulo-4-da-aula-4)
5. [Algoritmo Clássico: Soma e Média](#capítulo-5---algoritmo-clássico-soma-e-média)
6. [Algoritmo Clássico: Maior Valor e sua Posição (Revisitado)](#capítulo-6---algoritmo-clássico-maior-valor-e-sua-posição-revisitado)
7. [Algoritmo Clássico: Busca Linear](#capítulo-7---algoritmo-clássico-busca-linear)
8. [Algoritmo Clássico: Inversão de Vetor](#capítulo-8---algoritmo-clássico-inversão-de-vetor)
9. [Algoritmo Clássico: Ordenação (Bubble Sort)](#capítulo-9---algoritmo-clássico-ordenação-bubble-sort)
10. [Vetores de Duas Dimensões (Matrizes)](#capítulo-10---vetores-de-duas-dimensões-matrizes)
11. [Reescrevendo o Caixa Eletrônico com Vetores](#capítulo-11---reescrevendo-o-caixa-eletrônico-com-vetores)
12. [Armadilhas Comuns (e Como Evitá-las)](#capítulo-12---armadilhas-comuns-e-como-evitá-las)
13. [Sabedoria de Quem Já Passou por Isso](#capítulo-13---sabedoria-de-quem-já-passou-por-isso)
14. [Para Continuar Estudando: Livros e Leituras](#capítulo-14---para-continuar-estudando-livros-e-leituras)
15. [Resumo da Aula](#capítulo-15---resumo-da-aula)

---

## Capítulo 1 - Introdução: Por que Não Criar uma Variável para Cada Valor?

Lá na Aula 4, resolvemos o problema de "maior valor e posição" lendo **5 números, um de cada vez**, sem guardar nenhum deles depois de comparado. Isso funciona bem quando você só precisa **usar** o valor uma vez e descartar. Mas e se você precisar guardar as notas de uma turma inteira para, depois, calcular a média, achar a maior, ordenar, buscar um valor específico?

Você poderia tentar:

```java
int nota1 = 8;
int nota2 = 7;
int nota3 = 9;
int nota4 = 6;
int nota5 = 10;
```

Isso funciona para 5 alunos. Para 50, seria uma loucura — e pior, você não conseguiria usar um `for` para percorrer `nota1`, `nota2`, `nota3`... eles são variáveis **completamente independentes** para o Java, sem nenhuma relação entre si.

A solução é o **vetor** (array): uma única estrutura que guarda **vários valores do mesmo tipo**, organizados em posições numeradas — e que pode ser percorrida com um `for`, exatamente como fizemos na Aula 3.

> Pense num vetor como uma fileira de caixinhas numeradas, grudadas lado a lado. Você não pergunta "cadê a nota do terceiro aluno?" separadamente — você pergunta "o que tem na caixinha número 2?".

---

## Capítulo 2 - Anatomia de um Vetor em Java

### Sintaxe geral

```java
tipo[] nomeDoVetor = new tipo[tamanho];
```

### Exemplo simples

```java
int[] notas = new int[5];
```

Vamos destrinchar cada peça, no mesmo espírito da anatomia de função que vimos na Aula 4:

| Parte | O que significa |
|---|---|
| `int` | o **tipo** dos valores que o vetor vai guardar — todos precisam ser do mesmo tipo. |
| `[]` | indica que `notas` não é uma variável comum, e sim um vetor. |
| `notas` | o **nome** do vetor — escolhido por você, seguindo o padrão camelCase. |
| `new int[5]` | cria de fato a estrutura na memória, com **5 posições**, todas iniciadas com o valor padrão do tipo (`0` para `int`). |

### Criando um vetor já preenchido

```java
int[] notas = {8, 7, 9, 6, 10};
```

Aqui não usamos `new` nem especificamos o tamanho — o Java já deduz o tamanho (5) a partir de quantos valores foram informados entre as chaves.

---

## Capítulo 3 - Índices, Percurso e o .length

### A contagem começa em 0

**Regra de ouro:** em Java, a numeração das posições de um vetor **começa em 0**, não em 1.

```java
int[] notas = {8, 7, 9, 6, 10};
//              0  1  2  3  4   ← índices
```

- `notas[0]` → 8 (primeira posição)
- `notas[4]` → 10 (última posição — repare que **não** é `notas[5]`!)

Se um vetor tem tamanho 5, os índices válidos vão de `0` a `4`. Tentar acessar `notas[5]` gera um erro em tempo de execução chamado `ArrayIndexOutOfBoundsException` — o Java está te dizendo "essa caixinha não existe nessa fileira".

```java
System.out.println(notas[2]); // imprime 9
notas[1] = 10; // troca o conteúdo da posição 1 (era 7, agora é 10)
```

### Descobrindo o tamanho: .length

```java
System.out.println(notas.length); // 5
```

Repare: **sem parênteses!** `.length` é um atributo do vetor, diferente de `.length()` em `String`, que é um método.

### Percorrendo com for

```java
for (int i = 0; i < notas.length; i++) {
    System.out.println("Posição " + i + ": " + notas[i]);
}
```

Usar `notas.length` em vez de escrever `5` na mão é uma boa prática: se o vetor mudar de tamanho no futuro, o `for` se ajusta sozinho.

### Percorrendo com for-each

Quando você só precisa **do valor**, sem se importar com a posição, existe uma forma mais enxuta:

```java
for (int nota : notas) {
    System.out.println(nota);
}
```

Leia assim: *"para cada `nota` dentro de `notas`, faça..."*. É mais simples de escrever, mas tem uma limitação: você não sabe em qual índice está, e não é possível alterar o vetor original através dele.

---

## Capítulo 4 - Vetores e Escopo: Por que Eles Quebram a Regra do Capítulo 4 da Aula 4

Lembra da Aula 4, quando vimos que tipos primitivos (`int`, `double`, `boolean`...) são passados **por cópia** para uma função, e por isso a função não consegue alterar a variável original do chamador? Com vetores, **a regra muda**.

```java
public static void main(String[] args) {
    int[] notas = {8, 7, 9};
    zerarPrimeira(notas);
    System.out.println(notas[0]); // imprime 0!
}

public static void zerarPrimeira(int[] vetor) {
    vetor[0] = 0;
}
```

Diferente do exemplo `dobrar(x)` da Aula 4, aqui a alteração feita **dentro** da função `zerarPrimeira` afeta o vetor **original**, lá fora, na `main`.

**Por quê?** Porque, embora a *referência* ao vetor seja copiada para o parâmetro `vetor`, essa cópia ainda **aponta para a mesma fileira de caixinhas** na memória. É como dar a alguém uma cópia do **endereço da sua casa**, em vez de fotocopiar a casa inteira: a pessoa não tem uma casa nova, ela sabe onde fica a sua — e pode mexer nela.

> **Isso é importante:** funções que recebem vetores como parâmetro podem alterar o conteúdo original sem precisar de `return`. Temos que ter cuidado redobrado ao escrever essas funções, justamente por esse motivo.

---

## Capítulo 5 - Algoritmo Clássico: Soma e Média

Um dos primeiros algoritmos clássicos com vetores: percorrer todas as posições, acumulando uma soma, e depois dividir pela quantidade de elementos.

```java
public static double calcularMedia(int[] notas) {
    int soma = 0;
    for (int i = 0; i < notas.length; i++) {
        soma += notas[i];
    }
    return (double) soma / notas.length;
}

public static void main(String[] args) {
    int[] notas = {8, 7, 9, 6, 10};
    double media = calcularMedia(notas);
    System.out.println("A média é: " + media);
}
```

### Por que `(double) soma / notas.length`?

`soma` e `notas.length` são ambos `int`. Se dividíssemos `int` por `int` diretamente, o Java faria uma **divisão inteira**, descartando a parte decimal (ex: `40 / 5` daria `8`, mas `39 / 5` daria `7`, não `7.8`). O `(double)` na frente de `soma` força o Java a tratar essa divisão como uma divisão de ponto flutuante, preservando as casas decimais — a mesma técnica de conversão de tipo (`casting`) que já apareceu em aulas anteriores.

---

## Capítulo 6 - Algoritmo Clássico: Maior Valor e sua Posição (Revisitado)

Na Aula 4, resolvemos isso lendo valores um a um, sem guardar nada. Agora, com um vetor já preenchido, o algoritmo fica ainda mais direto — porque não precisamos mais nos preocupar com a leitura, só com a comparação:

```java
public static int[] encontrarMaior(int[] valores) {
    int maior = valores[0];
    int posicao = 0;

    for (int i = 1; i < valores.length; i++) {
        if (valores[i] > maior) {
            maior = valores[i];
            posicao = i;
        }
    }

    return new int[]{maior, posicao};
}

public static void main(String[] args) {
    int[] notas = {8, 7, 9, 6, 10};
    int[] resultado = encontrarMaior(notas);
    System.out.println("Maior valor: " + resultado[0] + ", na posição: " + resultado[1]);
}
```

### Por que começar com `valores[0]` em vez de `Integer.MIN_VALUE`?

Na Aula 4, usamos `Integer.MIN_VALUE` porque líamos os números um a um, sem tê-los todos disponíveis de antemão. Agora que **já temos o vetor inteiro pronto**, é mais natural (e mais seguro) assumir que a primeira posição é a maior, e comparar a partir da segunda (`i = 1`) — evitando comparar um valor com ele mesmo.

---

## Capítulo 7 - Algoritmo Clássico: Busca Linear

Dado um vetor e um valor procurado, como descobrir se ele existe ali dentro — e em qual posição?

```java
public static int buscarLinear(int[] valores, int procurado) {
    for (int i = 0; i < valores.length; i++) {
        if (valores[i] == procurado) {
            return i; // achou! devolve a posição na hora
        }
    }
    return -1; // percorreu tudo e não achou
}

public static void main(String[] args) {
    int[] notas = {8, 7, 9, 6, 10};
    int posicao = buscarLinear(notas, 9);

    if (posicao != -1) {
        System.out.println("Encontrado na posição " + posicao);
    } else {
        System.out.println("Valor não encontrado.");
    }
}
```

### Por que devolver -1?

`-1` nunca é um índice válido de vetor (índices começam em 0). Por isso, é usado universalmente como um "sinal" de que a busca falhou — sem precisar criar uma segunda variável só para indicar "achou ou não achou". Esse é o mesmo espírito do `return false` dentro de `ehPrimo`, na Aula 4: interromper a função assim que a resposta já é conhecida, sem continuar percorrendo o resto do vetor à toa.

Esse algoritmo se chama **busca linear** porque, no pior caso, você percorre o vetor inteiro, posição por posição, em linha reta — sem nenhum atalho.

---

## Capítulo 8 - Algoritmo Clássico: Inversão de Vetor

Inverter um vetor significa trocar `valores[0]` com `valores[último]`, `valores[1]` com `valores[penúltimo]`, e assim por diante, até se encontrarem no meio.

```java
public static void inverter(int[] valores) {
    int inicio = 0;
    int fim = valores.length - 1;

    while (inicio < fim) {
        int aux = valores[inicio];
        valores[inicio] = valores[fim];
        valores[fim] = aux;

        inicio++;
        fim--;
    }
}

public static void main(String[] args) {
    int[] numeros = {1, 2, 3, 4, 5};
    inverter(numeros);

    for (int numero : numeros) {
        System.out.print(numero + " ");
    }
    // 5 4 3 2 1
}
```

Repare que esse algoritmo reaproveita **exatamente** a técnica de troca de valores (swap) com variável auxiliar `aux`, que vimos no Capítulo 5 da Aula 4 — só que agora aplicada a duas posições de um mesmo vetor, em vez de duas variáveis separadas. E, como vimos no Capítulo 4 desta aula, como a função recebe o vetor por referência, a inversão acontece **direto no vetor original**, sem precisar de `return`.

---

## Capítulo 9 - Algoritmo Clássico: Ordenação (Bubble Sort)

Ordenar um vetor é, provavelmente, o algoritmo clássico mais famoso de todos. Vamos ver a versão mais didática: o **bubble sort** ("ordenação por bolha").

```java
public static void bubbleSort(int[] valores) {
    for (int i = 0; i < valores.length - 1; i++) {
        for (int j = 0; j < valores.length - 1 - i; j++) {
            if (valores[j] > valores[j + 1]) {
                int aux = valores[j];
                valores[j] = valores[j + 1];
                valores[j + 1] = aux;
            }
        }
    }
}

public static void main(String[] args) {
    int[] numeros = {5, 2, 9, 1, 6};
    bubbleSort(numeros);

    for (int numero : numeros) {
        System.out.print(numero + " ");
    }
    // 1 2 5 6 9
}
```

### Por que "bolha"?

A cada passagem do laço externo (`i`), o **maior valor ainda não ordenado** vai "borbulhando" até sua posição final, à direita — exatamente como uma bolha de ar sobe até a superfície da água. O laço interno (`j`) compara pares vizinhos e troca (usando swap, de novo!) sempre que o da esquerda for maior que o da direita.

### Por que `valores.length - 1 - i` no laço interno?

A cada passagem completa, o maior valor restante já "chegou" ao final — então não precisamos mais comparar aquela posição de novo. Subtrair `i` a cada rodada evita comparações desnecessárias com posições que já sabemos estar corretas.

> Bubble sort não é o algoritmo de ordenação mais eficiente que existe (para vetores grandes, existem opções bem mais rápidas, como quicksort e mergesort), mas é o mais didático para entender **a ideia** de ordenação através de comparações e trocas.

---

## Capítulo 10 - Vetores de Duas Dimensões (Matrizes)

Se um vetor comum é uma **fileira** de caixinhas, um vetor de duas dimensões é uma **tabela**, organizada em linhas e colunas — como um tabuleiro de jogo da velha ou uma planilha.

```java
int[][] tabuleiro = new int[3][3]; // 3 linhas, 3 colunas

tabuleiro[0][0] = 1;
tabuleiro[1][2] = 5;

for (int linha = 0; linha < tabuleiro.length; linha++) {
    for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
        System.out.print(tabuleiro[linha][coluna] + " ");
    }
    System.out.println();
}
```

Repare que percorrer uma matriz exige **dois `for`s aninhados** — um para as linhas, outro para as colunas — seguindo exatamente o mesmo padrão de laços aninhados que vimos na Aula 3.

---

## Capítulo 11 - Reescrevendo o Caixa Eletrônico com Vetores

Lembra do programa de saque da Aula 1, com aquela função `proximaNota` cheia de `if/else if`? Com um vetor, ela desaparece por completo:

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int saque = dado.nextInt();

        int[] notasDisponiveis = {100, 50, 20, 10, 5, 2, 1};
        int resto = saque;

        for (int i = 0; i < notasDisponiveis.length; i++) {
            int nota = notasDisponiveis[i];
            int qtd = resto / nota;
            resto = resto % nota;

            if (qtd > 0) {
                System.out.println(qtd + " nota(s) de R$ " + nota + ",00");
            }
        }
    }
}
```

**Compare com a versão original:** lá, adicionar uma nova nota (por exemplo, R$ 200) exigia editar a função `proximaNota` inteira, adicionando mais um `else if`. Aqui, basta adicionar `200` no início do vetor `notasDisponiveis`. Essa diferença — o quanto um código precisa mudar quando um requisito novo aparece — é um dos motivos pelos quais vetores costumam ser preferidos a longas cadeias de `if/else if` quando os dados são do mesmo tipo e seguem um padrão.

---

## Capítulo 12 - Armadilhas Comuns (e Como Evitá-las)

1. **Confundir o último índice válido** — o último elemento de um vetor de tamanho `n` está na posição `n - 1`, nunca em `n`. Acessar `vetor[vetor.length]` sempre gera `ArrayIndexOutOfBoundsException`.
2. **Esquecer que vetores são passados por referência** — diferente de `int`, `double` ou `boolean`, alterar um vetor dentro de uma função **altera o original**. Se isso não for intencional, cuidado.
3. **Misturar `.length` (vetor) com `.length()` (String)** — um é atributo (sem parênteses), o outro é método (com parênteses). O compilador aponta o erro, mas vale o alerta.
4. **Esquecer de atualizar `notas.length` manualmente** — não faça isso! Sempre use `vetor.length` dentro do `for`, nunca um número fixo — assim, o código continua correto mesmo que o tamanho do vetor mude.
5. **Tentar comparar vetores com `==`** — `vetor1 == vetor2` compara se são o **mesmo vetor na memória**, não se têm os mesmos valores. Para comparar conteúdo, é preciso percorrer posição por posição (ou usar `java.util.Arrays.equals()`, que ainda não vimos, mas fica como curiosidade).

---

## Capítulo 13 - Sabedoria de Quem Já Passou por Isso

> "Programas são feitos para serem lidos por humanos, e só incidentalmente para serem executados por máquinas." — **Harold Abelson**, cientista da computação, coautor de *Structure and Interpretation of Computer Programs*.

> "Mostre-me suas estruturas de dados sem suas funções, e eu continuarei intrigado. Mostre-me suas funções e eu provavelmente não precisarei nem olhar suas estruturas de dados: elas ficarão óbvias." — **Fred Brooks**, autor de *The Mythical Man-Month*.

> "Ordenar é um dos problemas mais estudados de toda a ciência da computação — não porque seja difícil de resolver, mas porque resolvê-lo bem, para milhões de elementos, exige entender profundamente como o tempo de execução cresce." — ideia amplamente discutida na literatura clássica de algoritmos.

O fio condutor: a forma como você organiza os dados (vetores, matrizes, e mais tarde outras estruturas) tem tanto impacto no seu programa quanto a forma como você organiza a lógica em funções — as duas coisas andam sempre juntas.

---

## Capítulo 14 - Para Continuar Estudando: Livros e Leituras

- **Ana Fernanda Gomes Ascencio e Edilene Aparecida Campos** — *Fundamentos de Programação de Computadores: Algoritmos, Pascal, C/C++ e Java*. Traz um capítulo inteiro dedicado a vetores e matrizes, com diversos exercícios resolvidos.
- **Deitel & Deitel** — *Java: Como Programar*. Tem um capítulo dedicado a arrays, incluindo `ArrayList` — uma versão "flexível" de vetor que veremos futuramente.
- **Thomas H. Cormen et al.** — *Introduction to Algorithms*. Referência clássica para quem quiser se aprofundar em algoritmos de busca e ordenação além do bubble sort apresentado aqui.

> Dica: procure esses títulos por nome e edição em sebos, bibliotecas universitárias ou livrarias — as edições variam bastante de ano para ano.

---

## Capítulo 15 - Resumo da Aula

- Vetores guardam **vários valores do mesmo tipo** numa única estrutura, organizados por posições numeradas (índices).
- A contagem de índices sempre começa em **0**; o último índice válido é `length - 1`.
- `.length` é um atributo (sem parênteses); percorrer com `for` clássico dá acesso ao índice, `for-each` só ao valor.
- Diferente dos tipos primitivos vistos na Aula 4, vetores são passados **por referência** para funções — alterações dentro da função afetam o vetor original.
- **Soma e média** acumulam valores num laço, com atenção ao casting para preservar casas decimais.
- **Maior valor e posição**, revisitado, fica mais simples quando o vetor já está todo disponível de antemão.
- **Busca linear** percorre o vetor até encontrar o valor (ou devolver `-1`, sinal universal de "não encontrado").
- **Inversão de vetor** reaproveita a técnica de swap com variável auxiliar, vista na Aula 4.
- **Bubble sort** ordena através de comparações e trocas sucessivas entre pares vizinhos.
- Vetores de duas dimensões (matrizes) exigem laços aninhados para serem percorridos.
- Reescrever o caixa eletrônico com vetor mostra como uma estrutura de dados bem escolhida pode substituir longas cadeias de `if/else if`.
