# Aula de Java — Técnicas com Vetores

> Complemento das aulas anteriores: [Aula de Java para Iniciantes](../Aula%201/aula-java-basico.md), [Estruturas Condicionais](../Aula%202/aula-java-condicionais.md), [Estruturas de Repetição](../Aula%203/aula-java-laços.md), [Funções e Algoritmos Clássicos](../Aula%204/aula-java-funcoes.md) e [Vetores](../Aula%205/aula-java-vetores.md). Agora que já sabemos guardar e percorrer vetores, vamos aplicar **técnicas clássicas** sobre essa sequência de valores: trocar posições, inverter, buscar, medir eficiência e ordenar de várias formas diferentes.

---

## Índice

1. [Introdução: De Guardar Dados para Aplicar Algoritmos](#capítulo-1---introdução-de-guardar-dados-para-aplicar-algoritmos)
2. [Revisão: Troca de Valores com aux](#capítulo-2---revisão-troca-de-valores-com-aux)
3. [Algoritmo Clássico: Inversão de Vetor](#capítulo-3---algoritmo-clássico-inversão-de-vetor)
4. [O Problema da Busca](#capítulo-4---o-problema-da-busca)
5. [Algoritmo Clássico: Busca Linear](#capítulo-5---algoritmo-clássico-busca-linear)
6. [Contando Ocorrências e Buscando Todas as Posições](#capítulo-6---contando-ocorrências-e-buscando-todas-as-posições)
7. [Algoritmo Clássico: Busca Binária](#capítulo-7---algoritmo-clássico-busca-binária)
8. [Busca Binária Recursiva (Bônus)](#capítulo-8---busca-binária-recursiva-bônus)
9. [Medindo Eficiência: Uma Introdução à Notação Big O](#capítulo-9---medindo-eficiência-uma-introdução-à-notação-big-o)
10. [O Problema da Ordenação](#capítulo-10---o-problema-da-ordenação)
11. [Algoritmo Clássico: Selection Sort](#capítulo-11---algoritmo-clássico-selection-sort)
12. [Algoritmo Clássico: Bubble Sort](#capítulo-12---algoritmo-clássico-bubble-sort)
13. [Bubble Sort Otimizado com flag](#capítulo-13---bubble-sort-otimizado-com-flag)
14. [Algoritmo Clássico: Insertion Sort (Bônus)](#capítulo-14---algoritmo-clássico-insertion-sort-bônus)
15. [Comparando os Algoritmos de Ordenação](#capítulo-15---comparando-os-algoritmos-de-ordenação)
16. [Combinando Tudo: Ordenar e Depois Buscar](#capítulo-16---combinando-tudo-ordenar-e-depois-buscar)
17. [Exercícios Propostos](#capítulo-17---exercícios-propostos)
18. [Armadilhas Comuns (e Como Evitá-las)](#capítulo-18---armadilhas-comuns-e-como-evitá-las)
19. [Sabedoria de Quem Já Passou por Isso](#capítulo-19---sabedoria-de-quem-já-passou-por-isso)
20. [Para Continuar Estudando: Livros e Leituras](#capítulo-20---para-continuar-estudando-livros-e-leituras)
21. [Resumo da Aula](#capítulo-21---resumo-da-aula)

---

## Capítulo 1 - Introdução: De Guardar Dados para Aplicar Algoritmos

Na Aula 5, aprendemos a **guardar** vários valores num vetor e a **percorrê-lo** com `for`. Isso já resolve bastante coisa, mas surge uma pergunta natural: e se eu precisar saber se um valor **existe** dentro do vetor? E se eu quiser os valores **em ordem**? E se eu precisar **inverter** a sequência? E, entre duas formas diferentes de resolver o mesmo problema, qual delas é **mais rápida**?

Essas perguntas não são sobre *onde guardar* os dados — são sobre *o que fazer* com eles, e *quão bem* fazer isso. É exatamente essa a diferença entre **dado armazenado** e **algoritmo aplicado ao dado**, e é o fio condutor desta aula.

> Nem toda técnica pode ser usada em qualquer vetor. A busca binária, por exemplo, só funciona corretamente quando o vetor já está **ordenado** — veremos o porquê no Capítulo 7.

Nesta aula, vamos estudar uma família bem mais completa de técnicas clássicas, todas construídas em cima do que já vimos em aulas anteriores:

- **troca de valores**, revisando o `aux` da Aula 4;
- **inversão de vetor**, usando trocas entre posições opostas;
- **busca linear**, incluindo contagem de ocorrências e busca de todas as posições;
- **busca binária**, iterativa e recursiva;
- uma introdução leve à **notação Big O**, para comparar algoritmos de forma mais rigorosa;
- três algoritmos de ordenação: **selection sort**, **bubble sort** (com otimização) e **insertion sort**;
- como **combinar** ordenação e busca binária num único programa;
- uma lista de **exercícios propostos** para praticar sozinho.

É uma aula mais longa que as anteriores — de propósito. Os temas aqui são a base de praticamente qualquer entrevista técnica de programação e de disciplinas futuras como Estrutura de Dados.

---

## Capítulo 2 - Revisão: Troca de Valores com aux

Lá na Aula 4 (Capítulo 5), vimos como trocar o valor de duas variáveis usando uma variável auxiliar. A mesma ideia se aplica a **duas posições de um vetor**:

```java
int[] valores = {12, 7};

int aux = valores[0];
valores[0] = valores[1];
valores[1] = aux;

System.out.println(valores[0]); // 7
System.out.println(valores[1]); // 12
```

Sem o `aux`, o primeiro valor seria perdido antes de ser salvo em algum lugar — exatamente a mesma armadilha que vimos na Aula 4:

```java
valores[0] = valores[1]; // agora valores[0] vale 7... mas o 12 original já se foi
valores[1] = valores[0]; // isso só copia o 7 de volta, valores[1] continua 7
```

> **Pense assim:** trocar a água de dois copos sem um terceiro copo é impossível — você derramaria um deles antes de conseguir. `aux` é justamente esse "terceiro copo" temporário.

Diferente de JavaScript, Java não tem uma sintaxe de desestruturação (`[a, b] = [b, a]`) para arrays primitivos — por isso, em Java, a variável `aux` continuará sendo nossa ferramenta principal de troca ao longo de toda esta aula. Vamos usá-la, sem exceção, na inversão, no selection sort e no bubble sort.

### Uma função reutilizável de troca

Como vamos trocar posições de vetor várias vezes nesta aula, vale a pena isolar isso numa função:

```java
public static void trocar(int[] arr, int i, int j) {
    int aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
}
```

Como vetores são passados por referência (Aula 5, Capítulo 4), essa função altera o vetor original diretamente — sem precisar de `return`. Vamos reaproveitar `trocar` em vários algoritmos ao longo da aula, para não repetir o mesmo bloco de três linhas o tempo todo.

---

## Capítulo 3 - Algoritmo Clássico: Inversão de Vetor

Inverter um vetor significa trocar o primeiro elemento com o último, o segundo com o penúltimo, e assim por diante, até se encontrarem no meio.

```text
Antes:  [12, 45, 7, 89, 23]
Depois: [23, 89, 7, 45, 12]
```

### Duas abordagens possíveis

**1. Criar outro vetor**, preenchendo do fim para o começo:

```java
public static int[] criarVetorInvertido(int[] arr) {
    int[] invertido = new int[arr.length];
    int j = arr.length - 1;

    for (int i = 0; i < arr.length; i++) {
        invertido[j] = arr[i];
        j--;
    }

    return invertido;
}
```

**2. Trocar elementos no próprio vetor**, usando o meio como limite, e reaproveitando a função `trocar` do Capítulo 2:

```java
public static void inverterNoMesmoVetor(int[] arr) {
    int n = arr.length;
    int meio = n / 2;

    for (int i = 0; i < meio; i++) {
        trocar(arr, i, n - 1 - i);
    }
}
```

A primeira abordagem preserva o vetor original, mas gasta memória com um vetor novo — ela custa espaço extra proporcional a `n`, um conceito que veremos com calma no Capítulo 9. A segunda altera o vetor original diretamente e não gasta memória extra — e, como vimos na Aula 5 (Capítulo 4), isso é possível porque vetores são passados **por referência** para funções.

### Por que `n / 2`, e não `(n / 2) + 1` ou algo do tipo?

Se o vetor tem quantidade **ímpar** de elementos, como `{12, 45, 7, 89, 23}` (`n = 5`), existe um elemento central (`7`, no índice 2) que não precisa trocar com ninguém. `5 / 2` em Java é `2` (divisão inteira) — exatamente o número de trocas necessárias, sem tocar no elemento do meio.

Se o vetor tem quantidade **par**, como `{12, 45, 7, 89}` (`n = 4`), não existe um único centro. `4 / 2 = 2` trocas: índice `0` com `3`, e índice `1` com `2`. Ou seja, `meio` aqui não representa "o elemento do meio" — representa **até onde as trocas devem ir**.

### Testando a inversão com vetor de tamanho 1 e vazio

Vale a pena verificar mentalmente casos extremos (chamados de *casos de borda*):

- vetor vazio (`n = 0`): `meio = 0`, o `for` nem executa — nada acontece, o que está correto, pois não há nada para inverter.
- vetor de um elemento (`n = 1`): `meio = 0`, o `for` também não executa — um único elemento já está "invertido" em relação a si mesmo.

Programadores experientes sempre testam esses casos de borda antes de considerar um algoritmo pronto.

---

## Capítulo 4 - O Problema da Busca

Buscar significa verificar se um valor está presente numa coleção de dados, e, se estiver, descobrir em qual posição.

```java
int[] valores = {12, 45, 7, 89, 23};
```

Perguntas que a busca responde:

- o valor `89` existe no vetor?
- em qual índice está o valor `7`?
- quantas vezes o valor `20` aparece?
- o valor procurado não existe?

Esse tipo de problema aparece o tempo todo fora da sala de aula: procurar o código de um produto numa lista, verificar se uma matrícula existe, localizar uma nota específica dentro de um conjunto de notas, verificar se um número já foi sorteado numa loteria.

---

## Capítulo 5 - Algoritmo Clássico: Busca Linear

A **busca linear** percorre o vetor do início ao fim, comparando um elemento por vez com o valor procurado — na ordem natural dos índices: `0, 1, 2, 3...`

```java
public static int buscaLinear(int[] arr, int alvo) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == alvo) {
            return i; // achou! sai da função na hora
        }
    }
    return -1; // percorreu tudo e não achou
}

public static void main(String[] args) {
    int[] valores = {12, 45, 7, 89, 23};
    int indice = buscaLinear(valores, 7);

    if (indice != -1) {
        System.out.println("Valor encontrado no índice " + indice);
    } else {
        System.out.println("Valor não encontrado");
    }
}
```

### Simulando a busca do valor 89

| Comparação | Índice testado | Valor no vetor | Encontrou? |
|---|---|---|---|
| 1 | 0 | 12 | não |
| 2 | 1 | 45 | não |
| 3 | 2 | 7 | não |
| 4 | 3 | 89 | sim |

### Por que devolver -1?

`-1` nunca é um índice válido de vetor (índices começam em `0`). Por isso, é usado como sinal universal de "não encontrado" — o mesmo padrão que já usamos na Aula 5, no algoritmo de busca linear daquele capítulo.

### O return corta o laço, e o break também poderia

Repare que `return i;` dentro do `if` já interrompe a função **imediatamente**, sem precisar de um `break` — o mesmo comportamento que vimos com `ehPrimo`, na Aula 4. Se a busca linear fosse escrita sem função, dentro do `main`, aí sim usaríamos `break` para sair do laço assim que encontrasse o valor:

```java
int indice = -1;
for (int i = 0; i < valores.length; i++) {
    if (valores[i] == 7) {
        indice = i;
        break;
    }
}
```

### Quando a busca linear é adequada?

- o vetor está desordenado;
- o vetor é pequeno;
- a busca será feita poucas vezes;
- não vale a pena ordenar antes de buscar.

No pior caso — quando o valor procurado está na última posição, ou não existe — a busca linear precisa verificar **todos** os elementos.

---

## Capítulo 6 - Contando Ocorrências e Buscando Todas as Posições

A busca linear do Capítulo 5 devolve apenas **a primeira** ocorrência do valor. Mas, e se o valor aparecer várias vezes, e quisermos saber **quantas** vezes e **onde**?

### Contando ocorrências

```java
public static int contarOcorrencias(int[] arr, int alvo) {
    int contador = 0;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == alvo) {
            contador++;
        }
    }

    return contador;
}
```

Repare a diferença em relação à busca linear: aqui **não usamos `return` dentro do laço**, porque não queremos parar na primeira ocorrência — precisamos continuar até o fim do vetor, contando todas.

### Devolvendo todas as posições

Para devolver **todas** as posições onde o valor aparece, precisamos de uma estrutura que "caiba" exatamente a quantidade de ocorrências. Ainda não vimos `ArrayList` nesta aula (fica para uma aula futura), então vamos resolver isso em duas passagens: uma para contar quantas ocorrências existem, outra para preencher um vetor do tamanho exato.

```java
public static int[] buscarTodasPosicoes(int[] arr, int alvo) {
    int quantidade = contarOcorrencias(arr, alvo);
    int[] posicoes = new int[quantidade];
    int indicePosicoes = 0;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == alvo) {
            posicoes[indicePosicoes] = i;
            indicePosicoes++;
        }
    }

    return posicoes;
}

public static void main(String[] args) {
    int[] valores = {10, 20, 30, 20, 40, 20};
    int[] posicoes = buscarTodasPosicoes(valores, 20);

    System.out.print("Ocorrências de 20 nos índices: ");
    for (int posicao : posicoes) {
        System.out.print(posicao + " ");
    }
    // Ocorrências de 20 nos índices: 1 3 5
}
```

### Por que duas passagens, e não uma só?

Em Java, o tamanho de um vetor é **fixo** desde a criação (Aula 5, Capítulo 2) — não é possível "crescer" um vetor já criado. Por isso, a estratégia mais simples com o que já vimos é: primeiro descobrir **quantas** posições vamos precisar (`contarOcorrencias`), criar o vetor `posicoes` já com esse tamanho exato, e só então preenchê-lo. Essa técnica de "contar primeiro, alocar depois" é bastante comum quando se trabalha com vetores de tamanho fixo.

---

## Capítulo 7 - Algoritmo Clássico: Busca Binária

A **busca binária** é uma técnica mais eficiente, mas com uma condição obrigatória:

> O vetor precisa estar ordenado.

Se o vetor não estiver ordenado, a busca binária pode descartar a metade errada e devolver uma resposta incorreta.

### Ideia principal

Em vez de testar elemento por elemento desde o início, a busca binária testa o elemento do **meio** da região pesquisada. Se o valor procurado for menor, a busca continua na metade esquerda; se for maior, continua na metade direita; se for igual, encontrou.

```java
public static int buscaBinaria(int[] arr, int alvo) {
    int inicio = 0;
    int fim = arr.length - 1;

    while (inicio <= fim) {
        int meio = (inicio + fim) / 2;

        if (alvo == arr[meio]) {
            return meio;
        } else if (alvo > arr[meio]) {
            inicio = meio + 1;
        } else {
            fim = meio - 1;
        }
    }

    return -1;
}

public static void main(String[] args) {
    int[] vetor = {7, 12, 23, 45, 89}; // já ordenado!
    int indice = buscaBinaria(vetor, 45);

    if (indice != -1) {
        System.out.println("Valor encontrado no índice " + indice);
    } else {
        System.out.println("Valor não encontrado");
    }
}
```

### Simulando com o valor 45

| Passo | início | fim | meio | valor no meio | decisão |
|---|---|---|---|---|---|
| 1 | 0 | 4 | 2 | 23 | procurar à direita |
| 2 | 3 | 4 | 3 | 45 | encontrou |

### Simulando com um valor que não existe (valor 50)

| Passo | início | fim | meio | valor no meio | decisão |
|---|---|---|---|---|---|
| 1 | 0 | 4 | 2 | 23 | procurar à direita |
| 2 | 3 | 4 | 3 | 45 | procurar à direita |
| 3 | 4 | 4 | 4 | 89 | procurar à esquerda |
| 4 | 4 | 3 | — | — | `inicio > fim`, laço para |

Quando `inicio` ultrapassa `fim`, isso significa que a região de busca "encolheu até desaparecer" — sinal de que o valor não está no vetor. É por isso que a condição do `while` é `inicio <= fim`, e não `inicio < fim`.

### Por que essa técnica se chama "binária"?

Porque, a cada repetição, a área de busca é **dividida ao meio** — exatamente como o laço `while (true)` com `break` da Aula 4 (Capítulo 7) repete até uma condição aparecer, só que aqui a condição de parada está entrelaçada com uma redução constante do problema. Um vetor de 1000 elementos precisa de, no máximo, **10 comparações** para a busca binária concluir (porque `2^10 = 1024`) — bem menos que as até 1000 comparações que a busca linear poderia exigir no pior caso.

> **Cuidado com vetor desordenado:** aplicar busca binária em `{12, 45, 7, 89, 23}` (fora de ordem) pode descartar exatamente a metade onde o valor procurado está, e devolver `-1` mesmo que o valor exista no vetor.

---

## Capítulo 8 - Busca Binária Recursiva (Bônus)

Lembra da recursão que vimos com fatorial, na Aula 4 (Capítulo 8)? A busca binária é um excelente segundo exemplo, porque sua própria definição já é recursiva: "procure no meio; se não for, procure recursivamente na metade esquerda ou direita".

```java
public static int buscaBinariaRecursiva(int[] arr, int alvo, int inicio, int fim) {
    if (inicio > fim) {
        return -1; // caso base: região de busca vazia, não encontrou
    }

    int meio = (inicio + fim) / 2;

    if (alvo == arr[meio]) {
        return meio; // caso base: encontrou
    } else if (alvo > arr[meio]) {
        return buscaBinariaRecursiva(arr, alvo, meio + 1, fim); // metade direita
    } else {
        return buscaBinariaRecursiva(arr, alvo, inicio, meio - 1); // metade esquerda
    }
}

public static void main(String[] args) {
    int[] vetor = {7, 12, 23, 45, 89};
    int indice = buscaBinariaRecursiva(vetor, 45, 0, vetor.length - 1);
    System.out.println(indice); // 3
}
```

### Comparando com a versão iterativa

A versão iterativa (Capítulo 7) usa um `while` e duas variáveis (`inicio`, `fim`) que mudam a cada repetição. A versão recursiva não tem laço nenhum — em vez disso, a própria função **se chama de novo**, passando uma região de busca menor a cada chamada, até atingir um **caso base** (região vazia, ou valor encontrado).

Tal como vimos no fatorial recursivo, cada chamada recursiva empilha uma nova "camada" de execução — mas, como a região de busca cai pela metade a cada chamada, a busca binária recursiva empilha poucas camadas mesmo para vetores grandes.

---

## Capítulo 9 - Medindo Eficiência: Uma Introdução à Notação Big O

Até agora, comparamos busca linear e busca binária "no olho": uma percorre tudo, a outra divide pela metade. Existe uma forma mais formal (e muito usada no mercado) de expressar isso: a **notação Big O**, que descreve como o **tempo de execução** de um algoritmo cresce conforme o **tamanho da entrada** (`n`) aumenta.

Não vamos nos aprofundar na matemática por trás disso — o objetivo aqui é só apresentar o vocabulário, para você reconhecê-lo quando aparecer em outros materiais.

| Notação | Nome | O que significa | Exemplo desta aula |
|---|---|---|---|
| `O(1)` | tempo constante | não depende do tamanho do vetor | acessar `arr[i]` diretamente |
| `O(log n)` | tempo logarítmico | cresce bem devagar; cada passo elimina metade do problema | busca binária |
| `O(n)` | tempo linear | cresce proporcionalmente ao tamanho do vetor | busca linear, inversão, soma |
| `O(n²)` | tempo quadrático | cresce proporcionalmente ao **quadrado** do tamanho | bubble sort, selection sort, insertion sort |

### Por que isso importa na prática?

Imagine um vetor com 1 milhão de elementos:

- um algoritmo `O(log n)` (busca binária) resolve em, no máximo, cerca de **20 comparações**;
- um algoritmo `O(n)` (busca linear) pode precisar de até **1 milhão de comparações**;
- um algoritmo `O(n²)` (bubble sort) pode precisar de até **1 trilhão de comparações**.

Essa é a razão pela qual, no Capítulo 15, veremos que os três algoritmos de ordenação desta aula (todos `O(n²)`) não são usados em sistemas reais com grandes volumes de dados — e por que, sempre que possível, vale a pena ordenar um vetor uma única vez para depois poder usar busca binária (`O(log n)`) repetidamente, em vez de busca linear (`O(n)`) a cada consulta.

> Big O descreve o **pior caso**, ou o comportamento geral do algoritmo — não o tempo exato em segundos, que depende do computador, da linguagem e de outros fatores.

---

## Capítulo 10 - O Problema da Ordenação

Ordenar significa reorganizar os elementos de um vetor segundo algum critério — nesta aula, sempre em ordem crescente.

```text
Antes:  [12, 45, 7, 89, 23]
Depois: [7, 12, 23, 45, 89]
```

Ordenar é importante porque facilita a visualização dos dados, permite encontrar menores e maiores com mais facilidade (Aula 5, Capítulo 6), e — como veremos no Capítulo 16 — **prepara o vetor para a busca binária**.

Vamos estudar três algoritmos clássicos de ordenação, do mais simples de entender ao mais eficiente entre os três para vetores quase ordenados: **selection sort**, **bubble sort** e **insertion sort**.

---

## Capítulo 11 - Algoritmo Clássico: Selection Sort

O **selection sort** (ordenação por seleção) segue uma lógica bem direta: a cada passagem, encontre o **menor valor** ainda não ordenado, e o coloque na posição correta.

```java
public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int indiceMenor = i;

        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[indiceMenor]) {
                indiceMenor = j;
            }
        }

        trocar(arr, i, indiceMenor);
    }
}
```

### Simulando com {12, 45, 7, 89, 23}

| Passagem | Região ainda não ordenada | Menor encontrado | Vetor após a troca |
|---|---|---|---|
| 1 | `[12, 45, 7, 89, 23]` | 7 (índice 2) | `[7, 45, 12, 89, 23]` |
| 2 | `[45, 12, 89, 23]` | 12 (índice 2) | `[7, 12, 45, 89, 23]` |
| 3 | `[45, 89, 23]` | 23 (índice 4) | `[7, 12, 23, 89, 45]` |
| 4 | `[89, 45]` | 45 (índice 4) | `[7, 12, 23, 45, 89]` |

### Comparando com o Capítulo 6 da Aula 5

Repare que o laço interno do selection sort — encontrar o menor (ou maior) valor de uma região — é **exatamente** o algoritmo de "maior valor e posição" que vimos na Aula 4 e revisitamos na Aula 5, só que aplicado repetidamente a regiões cada vez menores do vetor. Entender bem aquele algoritmo torna o selection sort quase óbvio.

### Por que "seleção"?

Porque, a cada passagem, o algoritmo **seleciona** explicitamente o menor elemento da região restante — diferente do bubble sort, que descobre o menor/maior de forma indireta, através de várias trocas entre vizinhos.

---

## Capítulo 12 - Algoritmo Clássico: Bubble Sort

O **bubble sort** (ordenação por bolha) percorre o vetor várias vezes, comparando pares vizinhos: se estiverem fora de ordem, troca; se não, segue em frente. A cada passagem, o maior valor ainda não ordenado "borbulha" até sua posição final, à direita — como uma bolha de ar subindo na água.

```java
public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                trocar(arr, j, j + 1);
            }
        }
    }
}

public static void main(String[] args) {
    int[] numeros = {12, 45, 7, 89, 23};
    bubbleSort(numeros);

    for (int numero : numeros) {
        System.out.print(numero + " ");
    }
    // 7 12 23 45 89
}
```

### Simulando a primeira passagem

Vetor inicial: `[12, 45, 7, 89, 23]`

| Comparação | Par comparado | Troca? | Vetor após |
|---|---|---|---|
| 1 | 12 e 45 | não | `[12, 45, 7, 89, 23]` |
| 2 | 45 e 7 | sim | `[12, 7, 45, 89, 23]` |
| 3 | 45 e 89 | não | `[12, 7, 45, 89, 23]` |
| 4 | 89 e 23 | sim | `[12, 7, 45, 23, 89]` |

Ao final da primeira passagem, o maior valor (`89`) já está na posição correta, no final do vetor.

### Por que `arr.length - 1 - i` no laço interno?

Cada passagem completa "resolve" a posição de um valor a mais no final do vetor — não precisamos mais comparar posições que já sabemos estar corretas. Subtrair `i` a cada rodada evita comparações redundantes.

> Bubble sort não é o algoritmo mais eficiente que existe (para vetores grandes, quicksort e mergesort são bem mais rápidos), mas é o mais didático para entender a ideia de ordenar através de comparações e trocas sucessivas.

---

## Capítulo 13 - Bubble Sort Otimizado com flag

Se, numa passagem inteira, **nenhuma troca** aconteceu, isso significa que o vetor já está ordenado — não há motivo para continuar repetindo. Podemos detectar isso com uma variável de controle chamada `flag`:

```java
public static void bubbleSortOtimizado(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        boolean flag = false;

        for (int j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                trocar(arr, j, j + 1);
                flag = true;
            }
        }

        if (!flag) {
            break; // nenhuma troca nessa passagem: já está ordenado
        }
    }
}
```

Esse `break` é o mesmo padrão do Capítulo 7 da Aula 4: interromper um laço assim que uma condição inesperada (aqui, "não houve troca") é detectada, em vez de continuar repetindo à toa.

### Contando comparações e trocas

Para enxergar o ganho da otimização, podemos contar quantas comparações e trocas o algoritmo realmente fez:

```java
public static void main(String[] args) {
    int[] vetor = {20, 35, 18, 8, 14, 41, 3, 39};
    int comparacoes = 0;
    int trocas = 0;

    for (int i = 0; i < vetor.length - 1; i++) {
        boolean flag = false;

        for (int j = 0; j < vetor.length - 1 - i; j++) {
            comparacoes++;

            if (vetor[j] > vetor[j + 1]) {
                trocar(vetor, j, j + 1);
                trocas++;
                flag = true;
            }
        }

        if (!flag) {
            break;
        }
    }

    System.out.println("Comparações: " + comparacoes);
    System.out.println("Trocas: " + trocas);
}
```

Para esse vetor de exemplo, o resultado é: **28 comparações** e **15 trocas** — números que ajudam a visualizar concretamente o "custo" do algoritmo, além da notação Big O vista no Capítulo 9.

---

## Capítulo 14 - Algoritmo Clássico: Insertion Sort (Bônus)

O terceiro algoritmo de ordenação desta aula segue uma lógica bem parecida com a forma como a maioria das pessoas organiza cartas de baralho na mão: pega-se uma carta de cada vez, e ela é **inserida** na posição correta entre as cartas já organizadas.

```java
public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int atual = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > atual) {
            arr[j + 1] = arr[j]; // empurra o elemento maior uma posição à frente
            j--;
        }

        arr[j + 1] = atual; // insere o valor na posição correta
    }
}
```

### Simulando com {12, 45, 7, 89, 23}

| Passo | Elemento a inserir | Vetor após inserir |
|---|---|---|
| início | — | `[12, 45, 7, 89, 23]` |
| 1 | 45 | `[12, 45, 7, 89, 23]` (já estava na posição certa) |
| 2 | 7 | `[7, 12, 45, 89, 23]` |
| 3 | 89 | `[7, 12, 45, 89, 23]` (já estava na posição certa) |
| 4 | 23 | `[7, 12, 23, 45, 89]` |

### Por que esse algoritmo não usa a função trocar?

Repare que o insertion sort não troca pares de posições como o bubble sort e o selection sort — em vez disso, ele **desloca** elementos maiores uma posição para a frente (`arr[j + 1] = arr[j]`), abrindo espaço para o elemento atual ser inserido no lugar certo. Essa diferença de estratégia é o que torna o insertion sort, na prática, um pouco mais eficiente que o bubble sort para vetores quase ordenados — quando poucos deslocamentos são necessários.

---

## Capítulo 15 - Comparando os Algoritmos de Ordenação

| Critério | Selection Sort | Bubble Sort | Bubble Sort Otimizado | Insertion Sort |
|---|---|---|---|---|
| Ideia principal | seleciona o menor a cada passagem | troca vizinhos fora de ordem | igual, mas para cedo se já estiver ordenado | insere cada elemento na posição correta |
| Complexidade (pior caso) | `O(n²)` | `O(n²)` | `O(n²)` | `O(n²)` |
| Bom para vetor quase ordenado? | não (sempre revisa tudo) | um pouco melhor | sim (para cedo) | sim (poucos deslocamentos) |
| Quantidade de trocas | poucas (uma por passagem) | pode ser muitas | pode ser muitas | poucos deslocamentos |
| Mais didático para... | entender "encontrar o menor" | entender comparação + troca | entender otimização de laço | entender inserção ordenada |

Nenhum dos três é usado em sistemas reais de grande escala — linguagens como Java já trazem algoritmos de ordenação prontos e muito mais eficientes (como o `Arrays.sort()`, baseado em variações de quicksort e mergesort). Mas entender esses três algoritmos "na unha" é o que ensina, de verdade, como comparação, troca e deslocamento de elementos funcionam por dentro — a mesma filosofia que já guiou toda esta aula.

---

## Capítulo 16 - Combinando Tudo: Ordenar e Depois Buscar

Agora podemos conectar as técnicas: ler um vetor, ordená-lo com `bubbleSort` (ou qualquer um dos outros dois), e então aplicar `buscaBinaria` no resultado.

```java
import java.util.Scanner;

public class Main {

    public static void trocar(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    trocar(arr, j, j + 1);
                }
            }
        }
    }

    public static int buscaBinaria(int[] arr, int alvo) {
        int inicio = 0;
        int fim = arr.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (alvo == arr[meio]) {
                return meio;
            } else if (alvo > arr[meio]) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int[] vetor = {12, 45, 7, 89, 23};

        System.out.print("Digite o valor procurado: ");
        int valorProcurado = dado.nextInt();

        bubbleSort(vetor);
        int indice = buscaBinaria(vetor, valorProcurado);

        System.out.println("Vetor ordenado:");
        for (int numero : vetor) {
            System.out.print(numero + " ");
        }
        System.out.println();

        if (indice != -1) {
            System.out.println("Valor encontrado no índice " + indice + " do vetor ordenado");
        } else {
            System.out.println("Valor não encontrado");
        }
    }
}
```

### Ponto de atenção: o índice muda depois de ordenar!

```text
Antes:  [12, 45, 7, 89, 23]
Depois: [7, 12, 23, 45, 89]
```

O valor `45` estava no índice `1` antes da ordenação, e passa para o índice `3` depois. O índice que `buscaBinaria` devolve se refere sempre ao **vetor ordenado**, não à posição original de entrada.

### Vale a pena ordenar antes de buscar?

Como vimos no Capítulo 9, isso depende de quantas buscas serão feitas. Para uma única busca num vetor pequeno, a busca linear direta (`O(n)`) costuma ser mais simples e suficiente — ordenar primeiro custaria `O(n²)`, um trabalho desproporcional para uma única consulta. Para muitas buscas num vetor grande, ordenar uma vez (`O(n²)`, pago uma única vez) e usar busca binária repetidamente (`O(log n)` por consulta) compensa bastante o investimento inicial.

---

## Capítulo 17 - Exercícios Propostos

Para fixar o conteúdo desta aula, tente resolver os exercícios abaixo antes de seguir para as próximas aulas. Todos podem ser resolvidos reaproveitando funções já apresentadas aqui.

1. **Verificar se um vetor já está ordenado.** Escreva uma função `boolean estaOrdenado(int[] arr)` que devolve `true` se `arr[i] <= arr[i + 1]` para todo `i`, e `false` caso contrário.
2. **Encontrar o segundo menor valor.** Sem ordenar o vetor inteiro, escreva uma função que encontre o segundo menor valor, percorrendo o vetor apenas uma vez (dica: mantenha duas variáveis, `menor` e `segundoMenor`).
3. **Remover duplicatas de um vetor ordenado.** Dado um vetor já ordenado, devolva um novo vetor apenas com os valores distintos (dica: use a técnica de "contar primeiro, alocar depois", do Capítulo 6).
4. **Busca linear que devolve a última ocorrência.** Adapte `buscaLinear` para devolver o índice da **última** vez que o valor aparece, em vez da primeira.
5. **Selection sort em ordem decrescente.** Modifique o `selectionSort` do Capítulo 11 para ordenar do maior para o menor, em vez do menor para o maior.
6. **Contar quantas trocas o selection sort realiza.** Adicione um contador de trocas ao `selectionSort` e compare com o total de trocas do bubble sort, para o mesmo vetor de entrada.
7. **Desafio:** implemente uma função `int[] intersecao(int[] a, int[] b)` que devolva os valores presentes em **ambos** os vetores `a` e `b` (dica: ordene os dois primeiro, depois pense em como percorrê-los "lado a lado", de forma parecida com o `while` da busca binária).

> Não existe gabarito único aqui de propósito — o objetivo é que você combine as técnicas desta aula (troca, busca, ordenação, contagem) para resolver problemas novos, e não apenas reconhecer problemas já vistos.

---

## Capítulo 18 - Armadilhas Comuns (e Como Evitá-las)

1. **Usar busca binária em vetor desordenado** — o algoritmo pode descartar a metade errada e devolver `-1` mesmo com o valor presente.
2. **Esquecer o `aux` na troca** — sem ele, o primeiro valor é sobrescrito antes de ser salvo (mesma armadilha da Aula 4).
3. **Confundir `meio` com "o elemento central"** — em vetores de tamanho par, `meio` é o limite das trocas na inversão, não uma posição especial.
4. **Achar que o bubble sort ou o selection sort fazem apenas uma passagem** — são necessárias, no pior caso, `n - 1` passagens completas.
5. **Esquecer que o índice encontrado após ordenar não é o índice original** — se a posição original importa, ela precisa ser guardada antes da ordenação.
6. **Usar `i <= arr.length` em vez de `i < arr.length`** — igual vimos na Aula 5, isso sempre gera `ArrayIndexOutOfBoundsException`.
7. **Esquecer o caso base numa função recursiva de busca** — como vimos no Capítulo 8, sem `if (inicio > fim) return -1;`, a busca binária recursiva nunca para, gerando `StackOverflowError`.
8. **Confundir insertion sort com bubble sort** — no insertion sort, elementos são **deslocados** (`arr[j + 1] = arr[j]`), não trocados par a par; misturar as duas lógicas costuma gerar bugs sutis.
9. **Achar que Big O mede tempo em segundos** — Big O descreve como o número de operações **cresce** com `n`, não quantos milissegundos um algoritmo específico vai levar numa máquina específica.

---

## Capítulo 19 - Sabedoria de Quem Já Passou por Isso

> "Um algoritmo deve ser visto para ser acreditado." — **Donald Knuth**, autor de *The Art of Computer Programming*, referência máxima em algoritmos de busca e ordenação.

> "Nem todo problema que pode ser resolvido precisa ser resolvido da forma mais rápida possível — mas todo programador deveria saber por que uma forma é mais rápida que outra." — ideia amplamente discutida na literatura clássica de algoritmos.

> "A busca binária é um dos algoritmos mais simples de descrever e um dos mais fáceis de implementar errado." — observação recorrente em cursos introdutórios de ciência da computação, por causa dos detalhes de índice que ela exige.

> "Prematuramente otimizar é a raiz de todo mal." — frase amplamente atribuída a **Donald Knuth**, frequentemente usada para lembrar que entender e escrever um algoritmo correto vem antes de se preocupar com sua eficiência máxima.

O fio condutor: entender **por que** um algoritmo funciona (e sob quais condições) é mais importante do que decorar o código pronto — é isso que separa quem resolve um problema novo de quem só reconhece um problema já visto antes.

---

## Capítulo 20 - Para Continuar Estudando: Livros e Leituras

- **Ana Fernanda Gomes Ascencio e Edilene Aparecida Campos** — *Fundamentos de Programação de Computadores: Algoritmos, Pascal, C/C++ e Java*. Traz seções dedicadas a busca e ordenação com exercícios resolvidos.
- **Deitel & Deitel** — *Java: Como Programar*. Aborda busca linear, busca binária e diversos algoritmos de ordenação com arrays em Java, incluindo o uso de `Arrays.sort()`.
- **Thomas H. Cormen et al.** — *Introduction to Algorithms*. Referência clássica para se aprofundar em algoritmos de busca e ordenação além dos apresentados aqui, com análise formal de complexidade (incluindo quicksort, mergesort e a base matemática da notação Big O).
- **Robert Sedgewick e Kevin Wayne** — *Algorithms*. Traz implementações e visualizações muito didáticas de ordenação e busca, com exemplos próximos aos desta aula.

> Dica: procure esses títulos por nome e edição em sebos, bibliotecas universitárias ou livrarias — as edições variam bastante de ano para ano.

---

## Capítulo 21 - Resumo da Aula

- Esta aula aplica **algoritmos** sobre vetores já vistos na Aula 5 — a diferença entre dado armazenado e algoritmo aplicado ao dado.
- **Troca de valores** com `aux`, revisada da Aula 4, é a base da inversão, do selection sort e do bubble sort — e foi isolada numa função `trocar` reutilizável.
- **Inversão de vetor** troca elementos das extremidades em direção ao centro, usando `n / 2` como limite, com atenção a casos de borda (vetor vazio ou de um elemento).
- **Busca linear** percorre o vetor do início ao fim; devolve `-1` quando não encontra; pode ser adaptada para contar ocorrências ou devolver todas as posições de um valor.
- **Busca binária** exige vetor ordenado, mas é muito mais eficiente — divide a área de busca pela metade a cada repetição; existe tanto em versão iterativa quanto recursiva.
- A **notação Big O** (`O(1)`, `O(log n)`, `O(n)`, `O(n²)`) descreve como o custo de um algoritmo cresce com o tamanho da entrada, e explica por que busca binária supera busca linear em vetores grandes.
- **Selection sort**, **bubble sort** (com otimização por `flag`) e **insertion sort** são três formas clássicas — todas `O(n²)` — de ordenar um vetor, cada uma com uma estratégia diferente: selecionar, trocar vizinhos, ou inserir na posição correta.
- Ordenar antes de buscar só compensa quando há **muitas buscas** — e o índice encontrado depois de ordenar se refere ao vetor ordenado, não à ordem original.
- Os exercícios propostos no Capítulo 17 combinam as técnicas desta aula para resolver problemas novos, preparando o terreno para as próximas aulas sobre estruturas de dados.
