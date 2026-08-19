# Aula de Java — Matrizes e Técnicas com Matrizes

> Continuação da aula de [Vetores](../Aula%205/aula-java-vetores.md). Agora que já sabemos armazenar, percorrer, buscar e ordenar dados em uma dimensão, vamos dar um passo importante: trabalhar com **matrizes**, estruturas de duas dimensões organizadas em linhas e colunas. Nesta aula, vamos sair do simples `vetor[i]` e aprender a dominar `matriz[i][j]`, além de estudar diagonais, bordas, transposição, soma, média, busca, maior valor, multiplicação de matrizes e diversos padrões clássicos de programação competitiva.

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
29. [Desafios](#capítulo-29---desafios)
30. [Resumo da Aula](#capítulo-30---resumo-da-aula)

---

# Capítulo 1 - Introdução: de Vetores para Matrizes

Na aula anterior, aprendemos a trabalhar com **vetores**.

Um vetor permite armazenar vários valores em uma única dimensão:

```java
int[] vetor = {10, 20, 30, 40, 50};
