# Aula de Java — Matrizes e Técnicas com Matrizes

> ⚠️ **Aviso sobre citações:** ao longo desta aula eu cito livros, competições (OBI, ICPC, IOI) e problemas clássicos de referência. Eu não tenho acesso à internet nesta conversa, então **enunciados específicos de provas antigas podem estar levemente adaptados de memória** — trate-os como "inspirados em" e não como transcrição oficial. Sempre vale a pena conferir o enunciado original no site da [OBI](https://olimpiada.ic.unicamp.br/) ou no [beecrowd](https://www.beecrowd.com.br/) antes de usar em uma prova de verdade.

> Continuação da aula de [Vetores](../Aula%205/aula-java-vetores.md). Agora que já sabemos armazenar, percorrer, buscar e ordenar dados em uma dimensão, vamos dar um passo importante: trabalhar com **matrizes**, estruturas de duas dimensões organizadas em linhas e colunas. Nesta aula, vamos sair do simples `vetor[i]` e aprender a dominar `matriz[i][j]`, além de estudar diagonais, bordas, transposição, soma, média, busca, maior valor, multiplicação de matrizes e diversos padrões clássicos de programação competitiva — sempre conectando com matemática (Álgebra Linear), física, química e problemas de olimpíadas de informática.

🎯 **Objetivo desta aula:** sair sabendo declarar, ler, percorrer, somar, multiplicar, transpor e resolver problemas do mundo real com matrizes em Java — com confiança suficiente para encarar questões de olimpíada e de prova.

---

## Índice

1. [Introdução: de Vetores para Matrizes](#capítulo-1---introdução-de-vetores-para-matrizes)
2. [O que é uma Matriz?](#capítulo-2---o-que-é-uma-matriz)
3. [Criando uma Matriz em Java](#capítulo-3---criando-uma-matriz-em-java)
4. [Acessando Elementos](#capítulo-4---acessando-elementos)
5. [Percorrendo uma Matriz](#capítulo-5---percorrendo-uma-matriz)
6. [Lendo uma Matriz com Scanner](#capítulo-6---lendo-uma-matriz-com-scanner)
7. [Soma de Todos os Elementos](#capítulo-7---soma-de-todos-os-elementos)
8. [Média dos Elementos](#capítulo-8---média-dos-elementos)
9. [Maior e Menor Valor](#capítulo-9---maior-e-menor-valor)
10. [Busca em uma Matriz](#capítulo-10---busca-em-uma-matriz)
11. [Somando uma Linha](#capítulo-11---somando-uma-linha)
12. [Somando uma Coluna](#capítulo-12---somando-uma-coluna)
13. [Diagonal Principal](#capítulo-13---diagonal-principal)
14. [Diagonal Secundária](#capítulo-14---diagonal-secundária)
15. [Acima e Abaixo da Diagonal Principal](#capítulo-15---acima-e-abaixo-da-diagonal-principal)
16. [Triângulos e Regiões da Matriz](#capítulo-16---triângulos-e-regiões-da-matriz)
17. [Bordas da Matriz](#capítulo-17---bordas-da-matriz)
18. [Matriz Identidade](#capítulo-18---matriz-identidade)
19. [Transposta de uma Matriz](#capítulo-19---transposta-de-uma-matriz)
20. [Soma de Duas Matrizes](#capítulo-20---soma-de-duas-matrizes)
21. [Multiplicação de Matrizes](#capítulo-21---multiplicação-de-matrizes)
22. [Matriz Simétrica](#capítulo-22---matriz-simétrica)
23. [Matriz Esparsa](#capítulo-23---matriz-esparsa)
24. [Percurso em Quatro Direções](#capítulo-24---percurso-em-quatro-direções)
25. [Matriz como Tabuleiro](#capítulo-25---matriz-como-tabuleiro)
26. [Exercícios Propostos](#capítulo-26---exercícios-propostos)
27. [Problemas Clássicos de Programação Competitiva](#capítulo-27---problemas-clássicos-de-programação-competitiva)
28. [Armadilhas Comuns](#capítulo-28---armadilhas-comuns)
29. [Desafios Finais](#capítulo-29---desafios-finais)
30. [Resumo da Aula e Referências](#capítulo-30---resumo-da-aula-e-referências)

---

# Capítulo 1 - Introdução: de Vetores para Matrizes

Na aula anterior, aprendemos a trabalhar com **vetores**.

Um vetor permite armazenar vários valores em uma única dimensão:

```java
int[] vetor = {10, 20, 30, 40, 50};
```

Isso é ótimo para listas: nomes de alunos, notas de uma prova, temperaturas de uma semana. Mas o mundo real é cheio de dados organizados em **tabelas**, não em listas simples. Pense em:

- 📊 Uma **planilha do Excel**, com linhas e colunas.
- 🖼️ Uma **imagem digital**, onde cada pixel tem uma posição (linha, coluna) e um valor de cor.
- ♟️ Um **tabuleiro de xadrez** ou de jogo da velha, com 8×8 ou 3×3 casas.
- 🌡️ Uma **tabela de temperaturas**: uma linha por cidade, uma coluna por mês.
- 🧮 Uma **planilha de notas** de uma escola: uma linha por aluno, uma coluna por disciplina.
- ⚡ Um **circuito elétrico**, onde a Lei de Kirchhoff gera um sistema de equações que é resolvido com matrizes.

Para representar esse tipo de dado, um único índice `vetor[i]` não é suficiente. Precisamos de **dois índices**: um para a linha, outro para a coluna. É exatamente isso que uma **matriz** oferece:

```java
int[][] matriz = {
    {10, 20, 30},
    {40, 50, 60}
};
System.out.println(matriz[1][2]); // 60 → linha 1, coluna 2
```

> 💡 **Curiosidade histórica:** o uso de tabelas para resolver problemas matemáticos é muito mais antigo do que os computadores. O livro chinês *Os Nove Capítulos sobre a Arte Matemática* (entre o século X a.C. e o século II a.C.) já usava tabelas de bastonetes para resolver sistemas de equações — uma técnica quase idêntica à Eliminação de Gauss que aprenderemos mais à frente. O termo "matriz" (do latim *matrix*, "útero" ou "geradora") só foi cunhado por **James Joseph Sylvester** em 1850, e formalizado por **Arthur Cayley** a partir de 1855/1858 — ambos matemáticos britânicos. Ou seja: a ideia é antiquíssima, o nome é "recente" (para os padrões da matemática).

📚 Este material acompanha (e expande) o conteúdo de **Ascencio, A. F. G.; Campos, E. A. V. — *Fundamentos da programação de computadores: algoritmos, PASCAL, C/C++ (padrão ANSI) e JAVA*, 3ª ed., Pearson, 2012**, que dedica um capítulo inteiro a matrizes (Capítulo 7), e de **Deitel, H. M.; Deitel, P. J. — *Java: Como Programar*, 10ª ed., Pearson**, referência clássica para quem estuda Java do zero. Se você tiver acesso a esses livros, vale muito a pena complementar esta aula com eles.

---

# Capítulo 2 - O que é uma Matriz?

Uma **matriz** é um arranjo retangular de valores organizados em **linhas** e **colunas**. Matematicamente, escrevemos:

$$
A = \begin{bmatrix} a_{11} & a_{12} & a_{13} \\ a_{21} & a_{22} & a_{23} \end{bmatrix}
$$

Essa matriz tem **2 linhas** e **3 colunas** — dizemos que ela tem **dimensão (ou tamanho) $2 \times 3$**. Cada valor $a_{ij}$ está na **linha $i$, coluna $j$**.

> 🧠 **Regrinha de ouro (vale para matemática *e* para programação):** "**L**inha antes de **C**oluna" — pense em "**LC**D" ou em como você lê um endereço numa planilha: primeiro a linha (andar), depois a coluna (número da sala). Em Java, essa mesma regra vale: `matriz[linha][coluna]`.

Um exemplo prático — imagine que uma escola registra as notas de 3 alunos em 2 provas:

| Aluno | Prova 1 | Prova 2 |
|---|---|---|
| Ana | 8.5 | 7.0 |
| Bruno | 6.0 | 9.5 |
| Carla | 10.0 | 8.0 |

Essa tabela **é** uma matriz $3 \times 2$:

```java
double[][] notas = {
    {8.5, 7.0},
    {6.0, 9.5},
    {10.0, 8.0}
};
```

`notas[1][0]` é a nota da **linha 1** (Bruno, começando do índice 0), **coluna 0** (Prova 1) → `6.0`.

> 🔬 **Conexão com outras áreas:** essa mesma estrutura (linhas = observações, colunas = características) é exatamente como o **Machine Learning** organiza datasets inteiros — e como a **estatística** organiza matrizes de dados para calcular médias, variâncias e correlações. Se você já viu (ou vai ver) uma planilha de dados de uma pesquisa, um dataset do Kaggle, ou uma tabela de resultados de um experimento de física ou química — é uma matriz.

**Índices em Java sempre começam em 0**, diferente da matemática pura, que geralmente começa em 1 (como vimos em $a_{11}$). Isso é uma das primeiras armadilhas que vamos falar no Capítulo 28 — guarde essa observação.

---

# Capítulo 3 - Criando uma Matriz em Java

Em Java, uma matriz é, tecnicamente, um **"vetor de vetores"**: um array cujos elementos são, eles mesmos, arrays. Existem várias formas de declarar e inicializar uma:

### 3.1 — Declarando com tamanho fixo (tudo zerado)

```java
int[][] matriz1 = new int[3][4]; // 3 linhas, 4 colunas — tudo começa em 0
```

### 3.2 — Declarando e inicializando com valores literais

```java
int[][] matriz2 = {
    {1, 2, 3},
    {4, 5, 6}
};
```

### 3.3 — Matrizes de outros tipos primitivos

```java
double[][] notas = new double[5][2];
boolean[][] tabuleiroMinado = new boolean[8][8];
char[][] letras = new char[3][3];
String[][] planilha = new String[10][5];
```

### 3.4 — Matriz quadrada (mesmo número de linhas e colunas)

```java
int[][] quadrada = new int[4][4]; // ordem 4 — só matrizes quadradas têm diagonal, traço e determinante!
```

### 3.5 — Matrizes "triangulares" ou "irregulares" (*jagged arrays*)

Uma curiosidade do Java: como uma matriz é um array de arrays, **cada linha pode ter um tamanho diferente**! Isso não existe (facilmente) em C/C++ ou Pascal, mas é super comum em Java.

```java
int[][] triangular = new int[5][]; // define só o número de linhas
for (int i = 0; i < triangular.length; i++) {
    triangular[i] = new int[i + 1]; // linha 0 tem 1 elemento, linha 1 tem 2, etc.
}
```

Isso é útil, por exemplo, para representar um **Triângulo de Pascal** (veremos no Capítulo 16) sem desperdiçar memória com posições que nunca serão usadas.

> 📖 **Referência:** Deitel & Deitel chamam esses arrays de "*arrays of arrays*" e mostram exemplos parecidos no capítulo sobre arrays de *Java: Como Programar*. Já Ascencio & Campos (Capítulo 7) tratam matrizes de forma mais "matemática", sempre com dimensões fixas — o que é a norma em Pascal e C.

### 3.6 — Matrizes de 3 ou mais dimensões

Sim, Java permite! Um cubo de Rubik, por exemplo, poderia ser modelado como `int[3][3][3]` (face, linha, coluna). Não usaremos isso nesta aula, mas é bom saber que existe.

```java
int[][][] cubo = new int[3][3][3];
```

---

# Capítulo 4 - Acessando Elementos

Para ler ou alterar um elemento, usamos `matriz[linha][coluna]`:

```java
public class AcessandoMatriz {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(m[0][0]); // 1 → primeira linha, primeira coluna
        System.out.println(m[1][2]); // 6 → segunda linha, terceira coluna
        System.out.println(m[2][1]); // 8 → terceira linha, segunda coluna

        m[2][1] = 100; // alterando um valor
        System.out.println(m[2][1]); // 100
    }
}
```

> ⚠️ Se você tentar acessar `m[3][0]` nessa matriz 3×3, o programa lança `ArrayIndexOutOfBoundsException`, exatamente como acontecia com vetores. A matriz não "avisa" antes — ela quebra na hora. Sempre confira os limites!

Duas propriedades muito usadas:

```java
int numeroDeLinhas = m.length;        // 3
int numeroDeColunasDaLinha0 = m[0].length; // 3 (cuidado: cada linha pode ter tamanho diferente em jagged arrays!)
```

---

# Capítulo 5 - Percorrendo uma Matriz

Para "varrer" todos os elementos de uma matriz, usamos **dois laços `for` aninhados** — um para a linha, outro para a coluna.

```java
public class PercorrendoMatriz {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int i = 0; i < m.length; i++) {        // percorre as linhas
            for (int j = 0; j < m[i].length; j++) {  // percorre as colunas da linha i
                System.out.print(m[i][j] + " ");
            }
            System.out.println(); // pula linha ao terminar cada linha da matriz
        }
    }
}
```

Saída:
```
1 2 3 
4 5 6 
7 8 9 
```

> 🧠 **Por que usar `m[i].length` e não `m[0].length`?** Porque, em uma matriz "jagged" (irregular), cada linha pode ter um número diferente de colunas. Usar `m[i].length` é a forma **segura e genérica** de percorrer qualquer matriz, regular ou não.

Também é possível usar o `for-each` (aprendido na aula de vetores), mas com um "aninhamento":

```java
for (int[] linha : m) {
    for (int valor : linha) {
        System.out.print(valor + " ");
    }
    System.out.println();
}
```

O `for-each` é ótimo para **ler** valores, mas não serve para descobrir a posição `(i, j)` nem para alterar valores — para isso, prefira o `for` tradicional com índices.

---

# Capítulo 6 - Lendo uma Matriz com Scanner

Vamos ler os dados de uma matriz digitados pelo usuário:

```java
import java.util.Scanner;

public class LeMatriz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas linhas? ");
        int linhas = sc.nextInt();
        System.out.print("Quantas colunas? ");
        int colunas = sc.nextInt();

        int[][] m = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                m[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nMatriz digitada:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
```

> 💡 **Dica para Juízes Online (beecrowd, URI, SPOJ, UVa):** a maioria dos problemas de matriz em maratonas de programação (como a Maratona SBC citada no material de *Programação Competitiva*) informa primeiro o número de linhas e colunas (`N M`), e depois `N` linhas com `M` números cada. O padrão de leitura acima é praticamente universal — memorize-o, você vai usá-lo centenas de vezes.

---

# Capítulo 7 - Soma de Todos os Elementos

Percorremos a matriz inteira, acumulando os valores em uma variável:

```java
public class SomaMatriz {
    public static void main(String[] args) {
        int[][] m = {
            {5, 3, 8},
            {1, 9, 2},
            {7, 4, 6}
        };

        int soma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                soma += m[i][j];
            }
        }

        System.out.println("Soma de todos os elementos: " + soma);
    }
}
```

> 🌍 **Aplicação real:** lembra do exercício da empresa de tecnologia com 4 servidores e 3 tipos de tarefas (compressão, treinamento de modelos, indexação)? A matriz de carga de trabalho era:

```
A = [[560, 360, 380,   0],
     [340, 450, 420,  80],
     [280, 270, 210, 380]]
```

Somar todos os elementos dessa matriz responde à pergunta **"quantos processos, no total, foram concluídos por todos os servidores, em todas as tarefas, na semana?"** — um relatório gerencial típico. Isso é exatamente o mesmo `soma += m[i][j]` que acabamos de escrever.

---

# Capítulo 8 - Média dos Elementos

A média é simplesmente a soma dividida pela **quantidade total de elementos** (linhas × colunas):

```java
public class MediaMatriz {
    public static void main(String[] args) {
        double[][] notas = {
            {8.5, 7.0, 9.0},
            {6.0, 9.5, 7.5},
            {10.0, 8.0, 6.5}
        };

        double soma = 0;
        int quantidade = 0;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                soma += notas[i][j];
                quantidade++;
            }
        }

        double media = soma / quantidade;
        System.out.printf("Média geral: %.2f%n", media);
    }
}
```

> ⚠️ **Cuidado com divisão por inteiros!** Se `notas` fosse `int[][]` e você calculasse `soma / quantidade` com `soma` e `quantidade` do tipo `int`, o resultado seria truncado (ex: `7 / 2` = `3`, não `3.5`). Sempre garanta que pelo menos um dos operandos da divisão seja `double` quando quiser uma média com casas decimais.

---

# Capítulo 9 - Maior e Menor Valor

Guardamos o primeiro elemento como "candidato" inicial e vamos comparando com todos os outros — a mesma lógica usada em vetores, só que agora com dois índices.

```java
public class MaiorMenorMatriz {
    public static void main(String[] args) {
        int[][] m = {
            {12, 45, 3},
            {78, 5, 90},
            {23, 66, 1}
        };

        int maior = m[0][0];
        int menor = m[0][0];
        int linhaMaior = 0, colunaMaior = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > maior) {
                    maior = m[i][j];
                    linhaMaior = i;
                    colunaMaior = j;
                }
                if (m[i][j] < menor) {
                    menor = m[i][j];
                }
            }
        }

        System.out.println("Maior valor: " + maior + " na posição [" + linhaMaior + "][" + colunaMaior + "]");
        System.out.println("Menor valor: " + menor);
    }
}
```

> 🌍 **Conectando com o exemplo dos servidores:** para descobrir **qual servidor concluiu mais processos de uma tarefa específica**, ou **qual foi a combinação (tarefa, servidor) mais carregada da semana inteira**, é exatamente esse algoritmo que se usa — guardando também a posição `(i, j)` do valor máximo, não só o valor.

---

# Capítulo 10 - Busca em uma Matriz

### 10.1 — Busca sequencial (matriz sem ordenação especial)

```java
public class BuscaMatriz {
    public static void main(String[] args) {
        int[][] m = {
            {4, 8, 15},
            {16, 23, 42},
            {7, 1, 9}
        };

        int alvo = 23;
        boolean encontrado = false;

        for (int i = 0; i < m.length && !encontrado; i++) {
            for (int j = 0; j < m[i].length && !encontrado; j++) {
                if (m[i][j] == alvo) {
                    System.out.println("Encontrado em [" + i + "][" + j + "]");
                    encontrado = true;
                }
            }
        }

        if (!encontrado) System.out.println("Valor não encontrado.");
    }
}
```

### 10.2 — Busca "em escada" (matriz ordenada em linhas e colunas)

Este é um algoritmo elegante e muito cobrado em entrevistas e olimpíadas: se a matriz tem **cada linha crescente da esquerda pra direita** e **cada coluna crescente de cima pra baixo**, dá pra buscar em tempo $O(n + m)$ (bem mais rápido que $O(n \times m)$), começando pelo **canto superior direito**:

```java
public class BuscaEmEscada {
    public static boolean buscar(int[][] m, int alvo) {
        int linha = 0;
        int coluna = m[0].length - 1; // começa no canto superior direito

        while (linha < m.length && coluna >= 0) {
            if (m[linha][coluna] == alvo) {
                return true;
            } else if (m[linha][coluna] > alvo) {
                coluna--; // o valor é menor: descarta a coluna inteira, anda pra esquerda
            } else {
                linha++;  // o valor é maior: descarta a linha inteira, desce
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {
            {1,  4,  7, 11},
            {2,  5,  8, 12},
            {3,  6,  9, 16},
            {10, 13, 14, 17}
        };
        System.out.println(buscar(m, 5));  // true
        System.out.println(buscar(m, 20)); // false
    }
}
```

> 🏆 **De onde vem esse algoritmo?** Esse padrão é praticamente idêntico ao problema **"Search a 2D Matrix II"**, muito comum em plataformas como LeetCode e cobrado em entrevistas técnicas (o beecrowd e outras plataformas citadas no material de *Programação Competitiva* têm variações desse problema). A ideia de "descartar uma linha ou coluna inteira a cada passo" é um exemplo lindo de como uma observação matemática simples (a matriz é ordenada em duas direções) transforma um algoritmo de força bruta em algo muito mais eficiente.

---

# Capítulo 11 - Somando uma Linha

Para somar apenas **uma linha específica**, fixamos o índice `i` e variamos só `j`:

```java
public class SomaLinha {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int linhaEscolhida = 1; // vamos somar a linha 1: {4, 5, 6}
        int soma = 0;

        for (int j = 0; j < m[linhaEscolhida].length; j++) {
            soma += m[linhaEscolhida][j];
        }

        System.out.println("Soma da linha " + linhaEscolhida + ": " + soma); // 15
    }
}
```

### Bônus: soma de **todas** as linhas, guardada em um vetor

```java
int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
int[] somaPorLinha = new int[m.length];

for (int i = 0; i < m.length; i++) {
    int soma = 0;
    for (int j = 0; j < m[i].length; j++) {
        soma += m[i][j];
    }
    somaPorLinha[i] = soma;
}
// somaPorLinha = {6, 15, 24}
```

Isso conecta diretamente com o vetor da aula anterior: **cada linha de uma matriz, quando resumida, vira um valor de um vetor**. Esse é um dos padrões mais usados em análise de dados (agregação por linha, por exemplo: "total gasto por cliente" em uma planilha de compras).

---

# Capítulo 12 - Somando uma Coluna

Agora o inverso: fixamos a **coluna** `j` e variamos a linha `i`.

```java
public class SomaColuna {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int colunaEscolhida = 2; // vamos somar a coluna 2: {3, 6, 9}
        int soma = 0;

        for (int i = 0; i < m.length; i++) {
            soma += m[i][colunaEscolhida];
        }

        System.out.println("Soma da coluna " + colunaEscolhida + ": " + soma); // 18
    }
}
```

### Bônus: soma de todas as colunas

```java
int[] somaPorColuna = new int[m[0].length];

for (int j = 0; j < m[0].length; j++) {
    int soma = 0;
    for (int i = 0; i < m.length; i++) {
        soma += m[i][j];
    }
    somaPorColuna[j] = soma;
}
// somaPorColuna = {12, 15, 18}
```

> 🌍 **Exemplo real:** em uma planilha de vendas onde as linhas são meses e as colunas são produtos, `somaPorColuna` te dá o **total vendido de cada produto no ano inteiro**, e `somaPorLinha` te dá o **total vendido por mês**. É a mesma lógica de uma tabela dinâmica (*pivot table*) do Excel — só que feita "na mão" em Java.

---

# Capítulo 13 - Diagonal Principal

A **diagonal principal** de uma matriz quadrada é formada pelos elementos onde **linha == coluna**: `m[0][0], m[1][1], m[2][2], ...`

```java
public class DiagonalPrincipal {
    public static void main(String[] args) {
        int[][] m = {
            {4, 9, 1},
            {2, -3, 7},
            {8, 6, 5}
        };

        int soma = 0;
        for (int i = 0; i < m.length; i++) {
            soma += m[i][i]; // repare: o mesmo índice para linha e coluna!
            System.out.println("Diagonal[" + i + "] = " + m[i][i]);
        }

        System.out.println("Soma da diagonal principal (traço): " + soma);
    }
}
```

> 📐 **Conexão com Álgebra Linear:** essa soma da diagonal principal tem um nome na matemática: **traço da matriz** ($tr(A)$). O traço tem propriedades interessantes: $tr(A+B) = tr(A) + tr(B)$, e mesmo sabendo que, em geral, $AB \neq BA$ para matrizes, é sempre verdade que $tr(AB) = tr(BA)$! Essa propriedade é usada em física teórica e em provas de álgebra linear avançada. O traço também aparece em **estatística** (a soma da variância total de um conjunto de dados é o traço da matriz de covariância).

> ⚠️ Só faz sentido falar em "diagonal principal" para **matrizes quadradas** (mesmo número de linhas e colunas). Em uma matriz retangular, o `for` acima quebraria assim que `i` ultrapassasse o número de colunas.

---

# Capítulo 14 - Diagonal Secundária

A **diagonal secundária** vai do canto superior direito ao canto inferior esquerdo. A fórmula para encontrá-la é: **coluna = (número de colunas - 1) - linha**, ou seja, `j == n - 1 - i` (onde `n` é a ordem da matriz quadrada).

```java
public class DiagonalSecundaria {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int n = m.length;
        int soma = 0;

        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            soma += m[i][j];
            System.out.println("m[" + i + "][" + j + "] = " + m[i][j]);
        }

        System.out.println("Soma da diagonal secundária: " + soma); // 3 + 5 + 7 = 15
    }
}
```

Repare que, para a matriz do exemplo, a diagonal secundária é `3, 5, 7` — comece do canto superior direito (`m[0][2] = 3`) e desça para a esquerda.

---

# Capítulo 15 - Acima e Abaixo da Diagonal Principal

Muitos problemas pedem para processar só a parte de cima ou só a parte de baixo da matriz, em relação à diagonal principal.

- **Acima da diagonal** (triângulo superior): `j > i`
- **Abaixo da diagonal** (triângulo inferior): `j < i`
- **Na diagonal**: `j == i`

```java
public class AcimaAbaixoDiagonal {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Elementos ACIMA da diagonal principal:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (j > i) System.out.println(m[i][j]); // 2, 3, 6
            }
        }

        System.out.println("Elementos ABAIXO da diagonal principal:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (j < i) System.out.println(m[i][j]); // 4, 7, 8
            }
        }
    }
}
```

> 📐 **Conexão com Álgebra Linear:** uma matriz onde **todos os elementos abaixo da diagonal principal são zero** é chamada de **matriz triangular superior**; se todos os elementos **acima** são zero, é uma **matriz triangular inferior**. Essas matrizes são super importantes porque:
> 1. O **determinante** de uma matriz triangular é simplesmente o produto da sua diagonal principal (muito mais fácil de calcular!).
> 2. A **Eliminação de Gauss** (usada para resolver sistemas lineares) tem como objetivo justamente transformar uma matriz qualquer em uma forma triangular.

---

# Capítulo 16 - Triângulos e Regiões da Matriz

Vamos usar o que aprendemos para desenhar (e construir) padrões famosos — ótimo treino de lógica com condicionais dentro de laços aninhados.

### 16.1 — Triângulo de Pascal como matriz "jagged"

O Triângulo de Pascal contém os **coeficientes binomiais**, extremamente usados em combinatória (matemática) e em genética (para calcular proporções de cruzamentos, como nas leis de Mendel — cada linha do triângulo corresponde aos coeficientes de $(a+b)^n$).

```java
public class TrianguloDePascal {
    public static void main(String[] args) {
        int linhas = 6;
        int[][] pascal = new int[linhas][];

        for (int i = 0; i < linhas; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int[] linha : pascal) {
            for (int valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}
```

Saída:
```
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
```

### 16.2 — Desenhando um triângulo de asteriscos (padrão clássico de prova)

```java
public class TrianguloAsteriscos {
    public static void main(String[] args) {
        int n = 5;
        int[][] triangulo = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangulo[i][j] = 1; // marca como "preenchido"
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(triangulo[i][j] == 1 ? "* " : "  ");
            }
            System.out.println();
        }
    }
}
```

---

# Capítulo 17 - Bordas da Matriz

Um padrão muito comum em processamento de imagens e jogos (por exemplo, para desenhar a moldura de um tabuleiro): imprimir ou processar **apenas os elementos das bordas** — primeira/última linha e primeira/última coluna.

```java
public class BordaMatriz {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int linhas = m.length;
        int colunas = m[0].length;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                boolean naBorda = (i == 0 || i == linhas - 1 || j == 0 || j == colunas - 1);
                if (naBorda) {
                    System.out.print(m[i][j] + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
```

Saída:
```
1 2 3 4 
5 . . 8 
9 . . 12 
13 14 15 16 
```

> 🎮 **Aplicação real:** processamento de imagens usa exatamente esse tipo de verificação para detectar **bordas de objetos** (edge detection), e jogos de tabuleiro (como *Reversi/Otelo*) usam a mesma lógica para identificar "casas de canto" e "casas de borda", que costumam valer estratégias diferentes.

---

# Capítulo 18 - Matriz Identidade

A **matriz identidade** ($I$) é uma matriz quadrada com `1` na diagonal principal e `0` em todo o resto. Na Álgebra Linear, ela é o "número 1" das matrizes: $A \times I = A$, para qualquer matriz $A$ compatível.

### 18.1 — Criando uma matriz identidade

```java
public class MatrizIdentidade {
    public static void main(String[] args) {
        int n = 4;
        int[][] identidade = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                identidade[i][j] = (i == j) ? 1 : 0;
            }
        }

        for (int[] linha : identidade) {
            for (int valor : linha) System.out.print(valor + " ");
            System.out.println();
        }
    }
}
```

### 18.2 — Verificando se uma matriz é a identidade

```java
public static boolean ehIdentidade(int[][] m) {
    int n = m.length;
    for (int i = 0; i < n; i++) {
        if (m[i].length != n) return false; // precisa ser quadrada
        for (int j = 0; j < n; j++) {
            int esperado = (i == j) ? 1 : 0;
            if (m[i][j] != esperado) return false;
        }
    }
    return true;
}
```

> 📐 **Fato curioso:** a matriz identidade é, ao mesmo tempo, **diagonal**, **triangular superior**, **triangular inferior** e **simétrica** (veremos matriz simétrica no Capítulo 22) — ela é a matriz "camaleoa" que se encaixa em quase todas as categorias especiais que existem. Além disso, seu **determinante** vale sempre `1`, e seu **traço** vale sempre `n` (a ordem da matriz).

---

# Capítulo 19 - Transposta de uma Matriz

**Transpor** uma matriz é "girar" ela: as linhas viram colunas e as colunas viram linhas. Se $A$ tem tamanho $m \times n$, então $A^T$ tem tamanho $n \times m$.

```java
public class MatrizTransposta {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        }; // 2 linhas, 3 colunas

        int linhas = a.length;
        int colunas = a[0].length;

        int[][] transposta = new int[colunas][linhas]; // dimensões trocadas!

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta[j][i] = a[i][j]; // repare a inversão dos índices
            }
        }

        System.out.println("Matriz original:");
        for (int[] linha : a) {
            for (int v : linha) System.out.print(v + " ");
            System.out.println();
        }

        System.out.println("\nMatriz transposta:");
        for (int[] linha : transposta) {
            for (int v : linha) System.out.print(v + " ");
            System.out.println();
        }
    }
}
```

Saída:
```
Matriz original:
1 2 3 
4 5 6 

Matriz transposta:
1 4 
2 5 
3 6 
```

> 📸 **Aplicação real de fotografia/edição de imagem:** girar uma imagem 90° pode ser implementado como uma combinação de transposição + inversão de linhas ou colunas — o mesmo princípio matemático de $A^T$! Já em **estatística e Machine Learning**, quase toda fórmula de regressão linear usa transpostas — a fórmula dos mínimos quadrados é $\hat\beta = (X^TX)^{-1}X^Ty$, algo que você vai encontrar de novo se estudar ciência de dados no futuro.

---

# Capítulo 20 - Soma de Duas Matrizes

Duas matrizes só podem ser somadas se tiverem **exatamente o mesmo tamanho**. A soma é feita **posição a posição**.

```java
public class SomaDeMatrizes {
    public static void main(String[] args) {
        int[][] a = {
            {2, 3},
            {1, 4}
        };
        int[][] b = {
            {5, -1},
            {0, 2}
        };

        int linhas = a.length;
        int colunas = a[0].length;

        // Antes de somar, sempre verifique a compatibilidade!
        if (linhas != b.length || colunas != b[0].length) {
            System.out.println("Erro: as matrizes precisam ter o mesmo tamanho!");
            return;
        }

        int[][] soma = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                soma[i][j] = a[i][j] + b[i][j];
            }
        }

        for (int[] linha : soma) {
            for (int v : linha) System.out.print(v + " ");
            System.out.println();
        }
        // Resultado: {7, 2} / {1, 6}
    }
}
```

> ⚠️ **Erro clássico de prova:** tentar somar `[1, 2] + [1, 2, 3]` não é "erro de conta" — é **impossível**, como somar maçã com laranja. Sempre valide as dimensões antes de somar, subtrair ou multiplicar matrizes.

---

# Capítulo 21 - Multiplicação de Matrizes

Essa é a operação que costuma assustar todo mundo na primeira vez — mas segue uma regra bem específica.

### A regra de compatibilidade

Para multiplicar $A \times B$: o **número de colunas de A** precisa ser igual ao **número de linhas de B**. O resultado tem o número de linhas de $A$ e o número de colunas de $B$.

$$A_{(m \times r)} \cdot B_{(r \times n)} = (AB)_{(m \times n)}$$

### Como calcular cada posição

Cada elemento do resultado $(AB)_{ij}$ é o **produto escalar** entre a linha $i$ de $A$ e a coluna $j$ de $B$: multiplica posição a posição e soma tudo.

```java
public class MultiplicacaoDeMatrizes {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2},
            {3, 4}
        }; // 2x2

        int[][] b = {
            {5, 6},
            {7, 8}
        }; // 2x2

        int linhasA = a.length;
        int colunasA = a[0].length;
        int linhasB = b.length;
        int colunasB = b[0].length;

        if (colunasA != linhasB) {
            System.out.println("Multiplicação impossível: colunas de A != linhas de B");
            return;
        }

        int[][] resultado = new int[linhasA][colunasB];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                int soma = 0;
                for (int k = 0; k < colunasA; k++) { // percorre a "linha de A" e a "coluna de B" ao mesmo tempo
                    soma += a[i][k] * b[k][j];
                }
                resultado[i][j] = soma;
            }
        }

        for (int[] linha : resultado) {
            for (int v : linha) System.out.print(v + " ");
            System.out.println();
        }
        // Resultado esperado: {19, 22} / {43, 50}
    }
}
```

> 🚨 **A multiplicação de matrizes NÃO é comutativa!** $AB \neq BA$, em geral — bem diferente do que acontece com números reais. Pense em "vestir meia, depois sapato" versus "vestir sapato, depois meia": a ordem muda completamente o resultado.
>
> ⚛️ **Curiosidade de física quântica:** em 1925, **Werner Heisenberg, Max Born e Pascual Jordan** criaram a "Mecânica Matricial" — a primeira formulação matemática rigorosa da física quântica, na qual grandezas como posição ($\hat{x}$) e momento ($\hat{p}$) de uma partícula são representadas por matrizes, e $\hat{x}\hat{p} \neq \hat{p}\hat{x}$. Essa não-comutatividade é a **origem matemática do Princípio da Incerteza de Heisenberg**! Um dos conceitos mais profundos da física do século XX nasce exatamente dessa propriedade de matrizes que você acabou de programar.

### Complexidade computacional

O algoritmo acima tem três laços aninhados: sua complexidade é $O(n^3)$ para matrizes quadradas de ordem $n$. Existem algoritmos mais rápidos (como o **algoritmo de Strassen**, de 1969, que atinge aproximadamente $O(n^{2.807})$), mas eles fogem do escopo desta aula — vale a pena saber que eles existem, especialmente se você for estudar Análise de Algoritmos mais a fundo (recomendo **Cormen, Leiserson, Rivest, Stein — *Introduction to Algorithms*, MIT Press**, para aprofundar).

---

# Capítulo 22 - Matriz Simétrica

Uma matriz é **simétrica** quando ela é igual à sua transposta: $A = A^T$, ou seja, `m[i][j] == m[j][i]` para todo `i` e `j`.

```java
public class MatrizSimetrica {
    public static boolean ehSimetrica(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            if (m[i].length != n) return false; // precisa ser quadrada
            for (int j = 0; j < n; j++) {
                if (m[i][j] != m[j][i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {2, 5, 6},
            {3, 6, 9}
        };
        System.out.println(ehSimetrica(a)); // true
    }
}
```

> 🕸️ **Aplicação real fortíssima em Ciência da Computação:** a **matriz de adjacência** de um **grafo não-direcionado** é sempre simétrica! Se existe uma conexão entre o nó `i` e o nó `j` (por exemplo, uma amizade em uma rede social, ou uma estrada entre duas cidades), colocamos `1` em `m[i][j]` e, automaticamente, `m[j][i]` também deve ser `1`, porque a conexão vale nos dois sentidos. Esse é o princípio por trás de algoritmos como busca em largura (BFS), busca em profundidade (DFS), e até do **PageRank**, algoritmo criado por Larry Page e Sergey Brin (fundadores do Google) para ranquear páginas da web.
>
> 🔬 Em **física**, tensores de tensão (usados em mecânica dos materiais e engenharia estrutural) também são representados por matrizes simétricas.

---

# Capítulo 23 - Matriz Esparsa

Uma **matriz esparsa** é uma matriz onde a **grande maioria dos elementos é zero**. Armazenar todos esses zeros em uma matriz `int[][]` normal é um desperdício de memória — imagine uma matriz $10.000 \times 10.000$ com apenas 50 valores diferentes de zero: seriam 100 milhões de posições guardadas, quando só 50 importam de verdade!

### Representação eficiente: lista de coordenadas

```java
import java.util.ArrayList;
import java.util.List;

public class MatrizEsparsa {
    static class Elemento {
        int linha, coluna, valor;
        Elemento(int linha, int coluna, int valor) {
            this.linha = linha;
            this.coluna = coluna;
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        List<Elemento> matriz = new ArrayList<>();

        // Simula uma matriz gigante 1000x1000 onde só 3 posições têm valor
        matriz.add(new Elemento(5, 200, 7));
        matriz.add(new Elemento(999, 0, -3));
        matriz.add(new Elemento(120, 850, 42));

        for (Elemento e : matriz) {
            System.out.println("Posição (" + e.linha + ", " + e.coluna + ") = " + e.valor);
        }
    }
}
```

> 🌍 **Onde isso é usado de verdade:**
> - **Motores de busca** (Google, Bing): a "matriz termo-documento" que relaciona palavras com páginas da web é gigantesca e extremamente esparsa (a maioria das palavras não aparece na maioria das páginas).
> - **Redes sociais**: a matriz de adjacência de uma rede com bilhões de usuários é esparsa — a maioria das pessoas não é amiga da maioria das outras pessoas.
> - **Física e Engenharia**: o **Método dos Elementos Finitos** (usado para simular estruturas, fluidos e calor) gera sistemas lineares gigantescos e esparsos, resolvidos com técnicas especiais de álgebra linear numérica.
> - **Machine Learning**: dados de recomendação (tipo "quais filmes cada usuário assistiu") formam matrizes extremamente esparsas.

---

# Capítulo 24 - Percurso em Quatro Direções

Um padrão fundamental para problemas de **grafos em grade** (labirintos, jogos, mapas) é percorrer os "vizinhos" de uma célula: cima, baixo, esquerda e direita. Usamos dois vetores auxiliares `dl` (delta linha) e `dc` (delta coluna):

```java
public class Vizinhos {
    static int[] dl = {-1, 1, 0, 0}; // cima, baixo, ---, ---
    static int[] dc = {0, 0, -1, 1}; // ---, ---, esquerda, direita

    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int linha = 1, coluna = 1; // vamos ver os vizinhos do centro (valor 5)

        for (int d = 0; d < 4; d++) {
            int novaLinha = linha + dl[d];
            int novaColuna = coluna + dc[d];

            // sempre verifique se a nova posição está dentro dos limites!
            if (novaLinha >= 0 && novaLinha < m.length && novaColuna >= 0 && novaColuna < m[0].length) {
                System.out.println("Vizinho: " + m[novaLinha][novaColuna]);
            }
        }
    }
}
```

### Aplicação clássica: contar "ilhas" (regiões conectadas) — flood fill / BFS

Este é um dos problemas mais cobrados em maratonas de programação e entrevistas técnicas — muito próximo do que aparece em provas da **OBI** envolvendo grades/labirintos, e é o mesmo princípio do famoso problema **"Number of Islands"**:

```java
public class ContarIlhas {
    static int[][] grade;
    static boolean[][] visitado;
    static int[] dl = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void inundar(int linha, int coluna) {
        // condição de parada: saiu do mapa, já visitou, ou é água (0)
        if (linha < 0 || linha >= grade.length || coluna < 0 || coluna >= grade[0].length) return;
        if (visitado[linha][coluna] || grade[linha][coluna] == 0) return;

        visitado[linha][coluna] = true; // marca como visitado

        for (int d = 0; d < 4; d++) {
            inundar(linha + dl[d], coluna + dc[d]); // chama recursivamente para os 4 vizinhos
        }
    }

    public static void main(String[] args) {
        grade = new int[][] {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        };
        visitado = new boolean[grade.length][grade[0].length];

        int ilhas = 0;
        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[0].length; j++) {
                if (grade[i][j] == 1 && !visitado[i][j]) {
                    inundar(i, j); // "afoga" toda a ilha conectada
                    ilhas++;
                }
            }
        }

        System.out.println("Número de ilhas: " + ilhas); // 4
    }
}
```

> 🏆 **Por que isso importa para OBI/ICPC:** grades (matrizes) representando mapas, labirintos ou tabuleiros são **um dos temas mais recorrentes** em olimpíadas de programação em todos os níveis, da OBI ao ICPC (competição citada no material *Programação Competitiva* que acompanha essa aula). Dominar o padrão "matriz + BFS/DFS com vetores de direção" resolve uma fração enorme dos problemas de nível iniciante/intermediário nessas provas.

---

# Capítulo 25 - Matriz como Tabuleiro

### 25.1 — Jogo da Velha: verificando o vencedor

```java
public class JogoDaVelha {
    public static char verificarVencedor(char[][] tabuleiro) {
        int n = tabuleiro.length;

        // verifica linhas
        for (int i = 0; i < n; i++) {
            if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0];
            }
        }

        // verifica colunas
        for (int j = 0; j < n; j++) {
            if (tabuleiro[0][j] != '-' && tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]) {
                return tabuleiro[0][j];
            }
        }

        // diagonal principal
        if (tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0];
        }

        // diagonal secundária
        if (tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2];
        }

        return '-'; // ninguém venceu ainda
    }

    public static void main(String[] args) {
        char[][] tabuleiro = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'O', 'X'}
        };
        System.out.println("Vencedor: " + verificarVencedor(tabuleiro)); // X
    }
}
```

### 25.2 — Colorindo um tabuleiro de xadrez (padrão par/ímpar)

```java
for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
        String cor = ((i + j) % 2 == 0) ? "branca" : "preta";
        System.out.print(cor.charAt(0) + " ");
    }
    System.out.println();
}
```

> ♟️ O truque `(i + j) % 2` é usadíssimo em jogos: define o padrão xadrez, mas também aparece em algoritmos de coloração de grafos e no famoso **Jogo da Vida de Conway**, que veremos no Capítulo 27.

---

# Capítulo 26 - Exercícios Propostos

> 🧠 Tente resolver **no papel primeiro**, depois no computador. É clichê, mas é assim que o assunto realmente "gruda" — igual recomendado no material de exercícios de Álgebra Linear que acompanha esta aula.

**🟢 Fácil**

1. Leia uma matriz $4 \times 4$ de inteiros e imprima quantos números pares e quantos números ímpares ela contém.
2. Dada uma matriz de notas ($n$ alunos × 3 provas), calcule a média de cada aluno (por linha) e imprima em um vetor.
3. Verifique se uma matriz quadrada é **diagonal** (todos os elementos fora da diagonal principal são zero).
4. Some duas matrizes $3 \times 3$ digitadas pelo usuário.

**🟡 Médio**

5. Escreva um programa que receba uma matriz e devolva uma nova matriz onde cada elemento é o dobro do original.
6. Verifique se uma matriz quadrada é **triangular superior**.
7. Dada uma matriz $n \times n$, troque a linha `i` pela linha `j` (dado pelo usuário) — útil, inclusive, para a operação elementar $L_i \leftrightarrow L_j$ usada na Eliminação de Gauss.
8. Implemente a rotação de uma matriz quadrada em **90 graus no sentido horário**, sem usar uma matriz auxiliar (rotação *in-place*). Dica: pense em transpor e depois inverter cada linha.
9. Dada uma matriz de temperaturas (linhas = cidades, colunas = meses), descubra a cidade com a **maior variação de temperatura** no ano (maior valor − menor valor da linha).

**🔴 Difícil**

10. Implemente a **multiplicação de duas matrizes de tamanhos quaisquer**, validando a compatibilidade antes.
11. Implemente um verificador de **Quadrado Mágico**: uma matriz $n \times n$ onde a soma de cada linha, cada coluna e as duas diagonais é sempre a mesma.
12. Dada uma matriz representando um labirinto (`0` = livre, `1` = parede), encontre o **caminho mais curto** entre dois pontos usando BFS (Busca em Largura). Este é um clássico de olimpíada!
13. Implemente uma função que verifica se uma matriz representa uma **solução válida de Sudoku** (linhas, colunas e blocos $3\times3$ sem repetição).

---

# Capítulo 27 - Problemas Clássicos de Programação Competitiva

Aqui vamos resolver alguns problemas mais elaborados, no estilo do que você encontra em plataformas de juízes online (beecrowd, SPOJ, UVa, Codeforces, HackerRank — todas citadas no material *Lições de Programação: Programação Competitiva*) e em provas de olimpíadas nacionais e internacionais (OBI, ICPC, IOI). Vamos também conectar com Física, Química e Matemática, mostrando como matrizes aparecem "escondidas" em disciplinas que parecem não ter nada a ver com programação.

## 27.1 — Maior soma de submatriz retangular (Algoritmo de Kadane em 2D)

**Problema:** dada uma matriz de inteiros (que pode ter valores negativos), encontre a soma máxima possível de uma submatriz retangular contígua.

Este é um problema clássico de programação dinâmica, uma extensão em duas dimensões do famoso **Algoritmo de Kadane** (usado para o problema 1D de "maior soma de subvetor contíguo").

```java
public class MaiorSubmatriz {

    // Algoritmo de Kadane 1D — encontra a maior soma de um subvetor contíguo
    static int kadane1D(int[] vetor) {
        int melhorAteAgora = vetor[0];
        int melhorGlobal = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            melhorAteAgora = Math.max(vetor[i], melhorAteAgora + vetor[i]);
            melhorGlobal = Math.max(melhorGlobal, melhorAteAgora);
        }
        return melhorGlobal;
    }

    public static int maiorSomaSubmatriz(int[][] m) {
        int linhas = m.length;
        int colunas = m[0].length;
        int melhorResultado = Integer.MIN_VALUE;

        // Fixamos um par de linhas (linhaTopo, linhaBase) e "achatamos" as colunas nesse intervalo
        for (int linhaTopo = 0; linhaTopo < linhas; linhaTopo++) {
            int[] somaColunas = new int[colunas];

            for (int linhaBase = linhaTopo; linhaBase < linhas; linhaBase++) {
                for (int c = 0; c < colunas; c++) {
                    somaColunas[c] += m[linhaBase][c];
                }
                // agora aplicamos Kadane 1D no vetor "achatado"
                melhorResultado = Math.max(melhorResultado, kadane1D(somaColunas));
            }
        }
        return melhorResultado;
    }

    public static void main(String[] args) {
        int[][] m = {
            {1, -2, -1, 4},
            {-8, 3, 4, 2},
            {3, 8, 10, -8},
            {-4, -1, 1, 7}
        };
        System.out.println("Maior soma de submatriz: " + maiorSomaSubmatriz(m));
    }
}
```

> 🏆 Esse padrão — "fixar duas linhas e reduzir o problema a uma dimensão" — é uma técnica poderosíssima de programação competitiva chamada **redução de dimensão**, e aparece em vários problemas de nível avançado da ICPC e em olimpíadas internacionais como a IOI.

## 27.2 — Rotação de matriz 90° e a fotografia digital

**Problema (estilo OBI/prova prática):** dada uma imagem representada como matriz de inteiros (níveis de cinza), gire-a 90° no sentido horário sem usar memória extra além da própria matriz.

```java
public class RotacaoDeImagem {
    public static void rotacionar90(int[][] m) {
        int n = m.length;

        // Passo 1: transpor a matriz (m[i][j] <-> m[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }

        // Passo 2: inverter cada linha
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = m[i][j];
                m[i][j] = m[i][n - 1 - j];
                m[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotacionar90(m);
        for (int[] linha : m) {
            for (int v : linha) System.out.print(v + " ");
            System.out.println();
        }
        // Esperado:
        // 7 4 1
        // 8 5 2
        // 9 6 3
    }
}
```

## 27.3 — O Jogo da Vida de Conway (matrizes + biologia + computação)

O **Jogo da Vida**, criado pelo matemático John Conway em 1970, é um autômato celular: cada célula de uma matriz está "viva" (1) ou "morta" (0), e o estado da próxima geração depende apenas do número de vizinhos vivos. É um exemplo lindo de como regras simples geram comportamentos complexos — usado até como analogia para sistemas biológicos e como material de estudo em complexidade computacional.

Regras:
- Uma célula viva com 2 ou 3 vizinhos vivos **continua viva**.
- Uma célula viva com menos de 2 ou mais de 3 vizinhos **morre**.
- Uma célula morta com exatamente 3 vizinhos vivos **nasce**.

```java
public class JogoDaVida {
    static int[] dl = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int contarVizinhosVivos(int[][] m, int i, int j) {
        int total = 0;
        for (int d = 0; d < 8; d++) {
            int ni = i + dl[d];
            int nj = j + dc[d];
            if (ni >= 0 && ni < m.length && nj >= 0 && nj < m[0].length) {
                total += m[ni][nj];
            }
        }
        return total;
    }

    public static int[][] proximaGeracao(int[][] atual) {
        int linhas = atual.length;
        int colunas = atual[0].length;
        int[][] proxima = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                int vizinhos = contarVizinhosVivos(atual, i, j);
                if (atual[i][j] == 1) {
                    proxima[i][j] = (vizinhos == 2 || vizinhos == 3) ? 1 : 0;
                } else {
                    proxima[i][j] = (vizinhos == 3) ? 1 : 0;
                }
            }
        }
        return proxima;
    }

    public static void main(String[] args) {
        int[][] mundo = {
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        }; // um "piscador" (blinker)

        for (int geracao = 0; geracao < 3; geracao++) {
            System.out.println("Geração " + geracao + ":");
            for (int[] linha : mundo) {
                for (int v : linha) System.out.print(v == 1 ? "■ " : "· ");
                System.out.println();
            }
            System.out.println();
            mundo = proximaGeracao(mundo);
        }
    }
}
```

## 27.4 — Balanceando Equações Químicas com Matrizes (Química + Álgebra Linear)

Você sabia que **balancear uma equação química** é, matematicamente, resolver um **sistema linear**? Cada elemento químico gera uma equação (a quantidade de átomos de cada elemento deve ser igual dos dois lados da reação), e resolvemos usando **Eliminação de Gauss** (a mesma técnica descrita no material de Álgebra Linear que acompanha esta aula).

Exemplo: balancear $C_2H_6 + O_2 \rightarrow CO_2 + H_2O$ (combustão do etano). Chamando os coeficientes de $x_1, x_2, x_3, x_4$:

- Carbono: $2x_1 = x_3$
- Hidrogênio: $6x_1 = 2x_4$
- Oxigênio: $2x_2 = 2x_3 + x_4$

Isso vira um sistema linear que pode ser resolvido usando o mesmo processo de escalonamento visto na aula de Sistemas Lineares. Aqui está uma implementação simplificada de **Eliminação de Gauss** genérica em Java, aplicável a qualquer sistema $Ax = b$ (incluindo circuitos elétricos, como veremos a seguir):

```java
public class EliminacaoDeGauss {
    public static double[] resolver(double[][] a, double[] b) {
        int n = a.length;
        double[][] m = new double[n][n + 1]; // matriz aumentada [A | b]

        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, m[i], 0, n);
            m[i][n] = b[i];
        }

        // Escalonamento (forma parecida com a vista na nota "09 - Eliminação de Gauss e Gauss-Jordan")
        for (int pivo = 0; pivo < n; pivo++) {
            for (int linha = pivo + 1; linha < n; linha++) {
                double fator = m[linha][pivo] / m[pivo][pivo];
                for (int coluna = pivo; coluna <= n; coluna++) {
                    m[linha][coluna] -= fator * m[pivo][coluna];
                }
            }
        }

        // Substituição reversa (de baixo para cima)
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double soma = m[i][n];
            for (int j = i + 1; j < n; j++) {
                soma -= m[i][j] * x[j];
            }
            x[i] = soma / m[i][i];
        }
        return x;
    }

    public static void main(String[] args) {
        // Exemplo: sistema 2x + 3y = 8 ; x - y = 1  (resolvido no material de Álgebra Linear)
        double[][] a = {
            {2, 3},
            {1, -1}
        };
        double[] b = {8, 1};

        double[] solucao = resolver(a, b);
        for (double valor : solucao) {
            System.out.printf("%.2f%n", valor);
        }
        // Esperado: x = 2.2, y = 1.2
    }
}
```

> 🧪 **Física — Lei de Kirchhoff em circuitos elétricos:** o mesmíssimo código acima resolve sistemas de equações que aparecem ao analisar circuitos elétricos com múltiplas malhas. As Leis de Kirchhoff (das correntes e das tensões) geram um sistema linear onde as incógnitas são as correntes em cada malha, e resolvemos usando a mesma Eliminação de Gauss. É por isso que engenheiros elétricos estudam Álgebra Linear tão a fundo — e é por isso que a mesma função Java que criamos para balancear uma equação química serve para calcular correntes elétricas, sem mudar uma linha de código.

## 27.5 — Exponenciação de Matrizes: Fibonacci em $O(\log n)$

Este é um dos truques mais elegantes que existem, muito usado em problemas avançados de olimpíada (aparece em variações em provas do ICPC e da IOI). A sequência de Fibonacci pode ser calculada usando a seguinte identidade matricial:

$$
\begin{bmatrix} F(n+1) \\ F(n) \end{bmatrix} = \begin{bmatrix} 1 & 1 \\ 1 & 0 \end{bmatrix}^n \begin{bmatrix} F(1) \\ F(0) \end{bmatrix}
$$

Ou seja, elevar a matriz $\begin{bmatrix}1&1\\1&0\end{bmatrix}$ à potência $n$ nos dá o $n$-ésimo Fibonacci — e podemos calcular potências de matrizes em $O(\log n)$ usando **exponenciação rápida** (a mesma técnica de "dividir a potência ao meio" usada para calcular $x^n$ rapidamente), muito mais rápido que a recursão ingênua $O(2^n)$ ou até a iterativa $O(n)$.

```java
public class FibonacciComMatrizes {

    static int[][] multiplicar(int[][] a, int[][] b) {
        int n = a.length;
        int[][] resultado = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    resultado[i][j] += a[i][k] * b[k][j];
        return resultado;
    }

    static int[][] potenciaDeMatriz(int[][] base, int expoente) {
        int n = base.length;
        int[][] resultado = new int[n][n];
        for (int i = 0; i < n; i++) resultado[i][i] = 1; // começa como matriz identidade

        while (expoente > 0) {
            if (expoente % 2 == 1) {
                resultado = multiplicar(resultado, base);
            }
            base = multiplicar(base, base);
            expoente /= 2;
        }
        return resultado;
    }

    public static long fibonacci(int n) {
        if (n == 0) return 0;
        int[][] matrizBase = {{1, 1}, {1, 0}};
        int[][] potencia = potenciaDeMatriz(matrizBase, n - 1);
        return potencia[0][0];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        // 1 1 2 3 5 8 13 21 34 55
    }
}
```

> 🤯 Esse é o tipo de solução que "ganha ponto extra" em uma prova de olimpíada quando $n$ pode ser gigantesco (como $10^{18}$), pois o método iterativo simples ($O(n)$) seria tempo demais, e a exponenciação de matriz resolve em $O(\log n)$.

## 27.6 — Quadrado Mágico (Matemática recreativa)

**Problema (estilo OBI nível iniciante):** verifique se uma matriz $n \times n$ é um **quadrado mágico** — a soma de cada linha, cada coluna, e das duas diagonais deve ser sempre igual.

```java
public class QuadradoMagico {
    public static boolean ehQuadradoMagico(int[][] m) {
        int n = m.length;
        int somaEsperada = 0;
        for (int j = 0; j < n; j++) somaEsperada += m[0][j]; // soma da primeira linha como referência

        // verifica todas as linhas
        for (int i = 0; i < n; i++) {
            int soma = 0;
            for (int j = 0; j < n; j++) soma += m[i][j];
            if (soma != somaEsperada) return false;
        }

        // verifica todas as colunas
        for (int j = 0; j < n; j++) {
            int soma = 0;
            for (int i = 0; i < n; i++) soma += m[i][j];
            if (soma != somaEsperada) return false;
        }

        // diagonal principal
        int somaDiagPrincipal = 0;
        for (int i = 0; i < n; i++) somaDiagPrincipal += m[i][i];
        if (somaDiagPrincipal != somaEsperada) return false;

        // diagonal secundária
        int somaDiagSecundaria = 0;
        for (int i = 0; i < n; i++) somaDiagSecundaria += m[i][n - 1 - i];
        if (somaDiagSecundaria != somaEsperada) return false;

        return true;
    }

    public static void main(String[] args) {
        int[][] m = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
        }; // o famoso quadrado mágico de ordem 3 (soma 15 em tudo)
        System.out.println(ehQuadradoMagico(m)); // true
    }
}
```

> 📜 **Curiosidade histórica:** o quadrado mágico de ordem 3 usado no exemplo é conhecido como **Lo Shu**, um dos artefatos matemáticos mais antigos documentados, associado a uma lenda chinesa de mais de 2000 anos — outra prova de que "matriz" é uma ideia bem mais antiga do que o computador que você está usando agora.

---

# Capítulo 28 - Armadilhas Comuns

Esses são os erros mais frequentes que estudantes cometem ao trabalhar com matrizes em Java — vale a pena ler com atenção antes de uma prova.

1. **Trocar linha por coluna.** `matriz[coluna][linha]` em vez de `matriz[linha][coluna]` é o erro número 1. Sempre revise a ordem: primeiro linha, depois coluna.

2. **`ArrayIndexOutOfBoundsException`.** Acontece quando os laços `for` usam `<=` em vez de `<`, ou quando você não confere os limites antes de acessar vizinhos (como no Capítulo 24).

3. **Assumir que toda matriz é quadrada.** Nem toda matriz tem `m.length == m[0].length`. Diagonal, traço e determinante só existem para matrizes **quadradas** — tentar calcular a diagonal de uma matriz $3 \times 5$ vai gerar índices inválidos.

4. **Confundir `m[i].length` com `m[0].length`.** Em matrizes "jagged" (irregulares), cada linha pode ter um tamanho diferente. Sempre use `m[i].length` dentro do laço da linha `i` para não quebrar em matrizes irregulares.

5. **Cópia rasa (*shallow copy*) de matrizes.** `int[][] copia = matrizOriginal.clone();` **NÃO** faz uma cópia de verdade! Ele copia apenas as referências das linhas — se você alterar `copia[0][0]`, `matrizOriginal[0][0]` também muda! Para copiar de verdade, você precisa copiar linha por linha:
```java
int[][] copiaDeVerdade = new int[matrizOriginal.length][];
for (int i = 0; i < matrizOriginal.length; i++) {
    copiaDeVerdade[i] = matrizOriginal[i].clone(); // clone funciona bem para arrays 1D
}
```

6. **Comparar matrizes com `==`.** Assim como em vetores, `matrizA == matrizB` compara **referências de memória**, não o conteúdo. Use `java.util.Arrays.deepEquals(matrizA, matrizB)` para comparar o conteúdo de matrizes multidimensionais.

7. **Overflow em somas grandes.** Se você está somando muitos números grandes em uma matriz `int[][]`, o resultado pode "estourar" o limite do `int` (cerca de 2.1 bilhões). Use `long` para acumuladores quando a matriz for grande ou os valores forem altos.

8. **Multiplicar matrizes incompatíveis sem checar antes.** Sempre valide `colunasDeA == linhasDeB` antes de multiplicar — senão você acessa índices inválidos.

9. **Esquecer que a Regra de Cramer e a expansão de cofatores ficam impraticáveis para matrizes grandes.** Se um exercício pedir o determinante de uma matriz $10 \times 10$ "na mão" usando cofatores, desconfie — o custo cresce em fatorial! Para matrizes grandes, use Eliminação de Gauss (transformar em triangular e multiplicar a diagonal).

---

# Capítulo 29 - Desafios Finais

Agora que você já viu muitos padrões, tente resolver estes desafios sem espiar a solução — a ideia é te dar só uma **dica**, não a resposta pronta:

1. **Matriz em Espiral:** imprima os elementos de uma matriz $n \times n$ seguindo um caminho em espiral (de fora para dentro). *Dica: mantenha quatro variáveis de controle (topo, base, esquerda, direita) e vá "encolhendo" a área ainda não visitada a cada volta.*

2. **Zerar Linhas e Colunas:** dada uma matriz, se um elemento for `0`, toda a linha e toda a coluna dele devem virar `0`. *Dica: marque quais linhas/colunas precisam ser zeradas antes de realmente zerá-las — senão você vai propagar zeros indevidamente.*

3. **Verificador de Sudoku Completo:** valide se uma matriz $9\times9$ representa um Sudoku correto (sem repetição em linhas, colunas e nos nove blocos $3\times3$).

4. **Caminho de Custo Mínimo em uma Grade:** dada uma matriz de custos, encontre o caminho do canto superior esquerdo até o canto inferior direito que minimiza a soma dos custos, movendo-se apenas para baixo ou para a direita (isso é **Programação Dinâmica**, um assunto que veremos com mais calma em uma aula futura!).

5. **Matriz Estocástica (Física/Matemática):** verifique se uma matriz quadrada é **estocástica** (todos os valores são não-negativos e a soma de cada linha é exatamente 1) — esse tipo de matriz é usado para modelar **Cadeias de Markov**, que aparecem em previsão de tempo, genética populacional, finanças e até no próprio algoritmo PageRank do Google.

---

# Capítulo 30 - Resumo da Aula e Referências

## 🗂️ Tabela-cola de padrões com matrizes

| Padrão | Ideia central |
|---|---|
| Percorrer tudo | `for (i) { for (j) { ... m[i][j] ... } }` |
| Percorrer uma linha | fixar `i`, variar `j` |
| Percorrer uma coluna | fixar `j`, variar `i` |
| Diagonal principal | `i == j` → `m[i][i]` |
| Diagonal secundária | `j == n - 1 - i` |
| Acima da diagonal | `j > i` |
| Abaixo da diagonal | `j < i` |
| Bordas | `i == 0 \|\| i == n-1 \|\| j == 0 \|\| j == m-1` |
| Vizinhos (4 direções) | vetores `dl = {-1,1,0,0}` e `dc = {0,0,-1,1}` |
| Transposta | `transposta[j][i] = original[i][j]` |
| Soma de matrizes | mesma dimensão, soma posição a posição |
| Multiplicação de matrizes | colunas de A == linhas de B; três laços aninhados |
| Matriz simétrica | `m[i][j] == m[j][i]` |

## 🧠 O que você aprendeu nesta aula

- Declarar, inicializar e acessar matrizes em Java (`int[][]`, matrizes irregulares/*jagged*).
- Percorrer matrizes com laços aninhados, tanto com `for` tradicional quanto com `for-each`.
- Ler matrizes digitadas pelo usuário com `Scanner`.
- Calcular soma, média, maior/menor valor, busca (inclusive a busca "em escada" $O(n+m)$).
- Trabalhar com linhas, colunas, diagonais, triângulos e bordas.
- Construir e verificar matriz identidade, transposta, matrizes simétricas e esparsas.
- Somar e multiplicar matrizes, entendendo a regra de compatibilidade e a não-comutatividade.
- Usar matrizes para representar tabuleiros de jogos (jogo da velha, xadrez).
- Resolver problemas clássicos de programação competitiva: maior submatriz (Kadane 2D), rotação de imagem, Jogo da Vida de Conway, balanceamento de equações químicas via Eliminação de Gauss, Fibonacci por exponenciação de matrizes e Quadrado Mágico.
- Reconhecer armadilhas comuns (cópia rasa, comparação com `==`, matrizes irregulares, overflow).

## 📚 Referências e leituras recomendadas

> ⚠️ Como mencionado no início, não tenho acesso à internet nesta conversa — confira sempre a edição/ano exatos antes de citar formalmente em um trabalho.

- **ASCENCIO, A. F. G.; CAMPOS, E. A. V.** *Fundamentos da programação de computadores: algoritmos, PASCAL, C/C++ (padrão ANSI) e JAVA.* 3. ed. São Paulo: Pearson Education do Brasil, 2012. — Capítulo 7 (Matriz) e Capítulo 6 (Vetor) são a base clássica em português para este assunto.
- **DEITEL, H. M.; DEITEL, P. J.** *Java: Como Programar.* 10. ed. São Paulo: Pearson Prentice Hall, 2015 (edições variam). — Referência de mercado para Java, com ótimos capítulos sobre arrays multidimensionais.
- **PIVA JUNIOR, D. et al.** *Algoritmos e programação de computadores.* 2. ed. Rio de Janeiro: Elsevier, 2019.
- **CORMEN, T. H.; LEISERSON, C. E.; RIVEST, R. L.; STEIN, C.** *Introduction to Algorithms.* MIT Press. — Para aprofundar em complexidade de algoritmos com matrizes (incluindo o algoritmo de Strassen).
- **SKIENA, S.; REVILLA, M.** *Programming Challenges: the programming contest training manual.* New York: Springer-Verlag, 2003. — Citado no material de Programação Competitiva; excelente fonte de problemas práticos, muitos envolvendo matrizes/grades.
- **POLYA, G.** *A arte de resolver problemas.* Rio de Janeiro: Interciência, 1995. — Sobre a metodologia geral de resolução de problemas (as 4 fases: análise, desenvolvimento, implementação, testes) usada como base do material *Lições de Programação: Programação Competitiva*.

## 🏆 Onde praticar

Assim como recomendado no material de *Programação Competitiva* que acompanha esta aula, a melhor forma de fixar tudo isso é **praticar em juízes online**:

- **[beecrowd](https://www.beecrowd.com.br/)** (antigo URI Online Judge) — categorias específicas sobre matrizes e vetores, com correção automática e mais de 2 mil problemas.
- **[OBI — Olimpíada Brasileira de Informática](https://olimpiada.ic.unicamp.br/)** — ótimas provas antigas com problemas de grade/matriz em todos os níveis.
- **SPOJ, UVa Online Judge, CodeChef, Codeforces** — para quando você quiser subir de nível e encarar problemas ao estilo ICPC/IOI.

## ➡️ Próximos passos

Agora que você domina vetores e matrizes, os próximos temas naturais são: **recursão**, **programação dinâmica** (usada no desafio do "caminho de custo mínimo" acima) e **estruturas de dados** como pilhas, filas e grafos — todos eles, cedo ou tarde, voltam a usar matrizes como estrutura de apoio. 🚀

Bons estudos! 🎓
