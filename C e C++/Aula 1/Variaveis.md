# Aula: Variáveis, Tipos e Operadores em C e C++

## 1. Variáveis
Variáveis são espaços de memória usados para armazenar valores que podem mudar durante a execução de um programa. Ao contrário do JavaScript, C e C++ são linguagens de tipagem estática, o que significa que você deve obrigatoriamente especificar o tipo de dado que a variável irá armazenar no momento de sua declaração.

**Exemplos:**
* `int idade = 20;`
* `float media = 8.5;`
* `char letra = 'A';`

**Diferença importante entre C e C++ (Textos):**
A linguagem C não possui um tipo de dado primitivo específico para armazenar palavras ou textos (strings). Para isso, utiliza-se um vetor de caracteres que termina obrigatoriamente com um caractere nulo `\0`. 
* *Exemplo em C:* `char nome[40] = "Ana";`

A linguagem C++ facilita esse processo oferecendo a classe `std::string`. 
* *Exemplo em C++:* `std::string nome = "Ana";`

**Boas práticas:**
* usar nomes claros (`quantidadeAlunos`, `notaFinal`);
* inicializar variáveis antes de usar (em C/C++, variáveis não inicializadas guardam "lixo de memória");
* usar `const` (ou `#define` para constantes globais em C) para valores que não devem ser alterados;
* evitar palavras reservadas da linguagem como nome de variável;
* evitar nomes genéricos como `x`, `y` quando o contexto não for estritamente matemático.

### 1.1 Palavras reservadas (principais)
Palavras reservadas não devem ser usadas como identificadores (nome de variável, função, classe etc.).

**Lista principal em C e C++:**
* `int`, `float`, `double`, `char`, `void`
* `if`, `else`, `switch`, `case`, `default`
* `for`, `while`, `do`, `break`, `continue`
* `return`, `sizeof`, `struct`, `typedef`
* *Adicionais exclusivas do C++:* `class`, `public`, `private`, `protected`, `new`, `delete`, `namespace`, `using`, `template`.

---

## 2. Tipos de variáveis
O tipo define quais valores uma variável pode guardar e quais operações são permitidas, além de determinar a quantidade de memória alocada.

**Principais tipos:**
* `int`: números inteiros (`-3`, `0`, `42`).
* `float` e `double`: números reais ou decimais (`3.14`, `-0.5`).
* `char`: um único caractere (`'A'`, `'?'`).

**Diferença importante entre C e C++ (Booleanos):**
Tradicionalmente, a linguagem C não possui um tipo de dado booleano nativo; ela considera o número `0` como falso e qualquer valor diferente de zero como verdadeiro. A linguagem C++ introduziu o tipo nativo `bool`, que aceita os valores `true` ou `false`.

**Importância em Ciência da Computação:**
* influencia o uso de memória do sistema;
* exige atenção para evitar *overflow* (estourar o limite numérico de um tipo);
* dita as regras de conversão (ex.: dividir dois inteiros em C/C++ resulta em um número inteiro, perdendo a parte decimal).

---

## 3. Operadores
Operadores permitem manipular e comparar dados.

### 3.1 Atribuição
Usado para conceder valores a variáveis.
* `=` atribui o valor da direita à variável da esquerda.
* `+=`, `-=`, `*=`, `/=` atualizam com base no valor atual.
*Exemplo:* `contador += 1;`

### 3.2 Relacionais/comparação
Comparam valores e retornam verdadeiro ou falso. *(Nota: em C/C++, não existe o operador `===` do JavaScript).*
* `==` igualdade.
* `!=` diferente.
* `>` maior que.
* `<` menor que.
* `>=` maior ou igual.
* `<=` menor ou igual.

*Exemplo:* `idade >= 18` retorna verdadeiro se a idade for 18 ou mais.

### 3.3 Lógicos
Combinam expressões booleanas.
* `&&` (E): retorna verdadeiro se ambas as condições forem verdadeiras.
* `||` (OU): retorna verdadeiro se ao menos uma condição for verdadeira.
* `!` (NÃO): inverte o valor lógico da condição.

#### 3.3.1 Tabelas-verdade

**`&&` (E)**

| A | B | A && B |
|---|---|---|
| Falso | Falso | Falso |
| Falso | Verdadeiro | Falso |
| Verdadeiro | Falso | Falso |
| Verdadeiro | Verdadeiro | Verdadeiro |

**`||` (OU)**

| A | B | A \|\| B |
|---|---|---|
| Falso | Falso | Falso |
| Falso | Verdadeiro | Verdadeiro |
| Verdadeiro | Falso | Verdadeiro |
| Verdadeiro | Verdadeiro | Verdadeiro |

**`!` (NEGAÇÃO)**

| A | !A |
|---|---|
| Falso | Verdadeiro |
| Verdadeiro | Falso |

---

## 4. Exemplo integrado
Abaixo, a mesma lógica resolvida nas duas linguagens para evidenciar as diferenças de saída (I/O) e o tratamento de textos e booleanos.

### Em C:
```c
#include <stdio.h>

int main() {
    // Entrada
    int idade = 19;
    float nota = 7.2;
    
    // Processamento (Em C, usamos int no lugar de booleanos puros)
    int aprovado = (idade >= 18) && (nota >= 6.0);
    
    // Saída
    if (aprovado) {
        printf("Resultado: Aprovado (1)\n");
    } else {
        printf("Resultado: Reprovado (0)\n");
    }
    
    return 0;
}

```
### Em C++:
```c++
#include <iostream>

int main() {
    // Entrada
    int idade = 19;
    float nota = 7.2;
    
    // Processamento
    bool aprovado = (idade >= 18) && (nota >= 6.0);
    
    // Saída
    if (aprovado) {
        std::cout << "Resultado: Aprovado (true)\n";
    } else {
        std::cout << "Resultado: Reprovado (false)\n";
    }
    
    return 0;
}
```

## 5. Fechamento
Nesta aula, vimos como:

declarar tipos estáticos e usar variáveis em C e C++;

escolher os tipos adequados (lidando com strings e booleanos de forma diferente em cada linguagem);

aplicar operadores para criar expressões lógicas e aritméticas.

Esses conceitos são a base para o controle de fluxo (if, while, for) e para a construção de sistemas eficientes e de alto desempenho nestas linguagens.

## 6. Saiba Mais (Livros e Sites Recomendados)
Para consolidar os estudos, os materiais a seguir são amplamente reconhecidos pela comunidade de desenvolvedores:

Sites e Documentações (O "MDN" do C/C++):

LearnCpp.com: Uma plataforma interativa, gratuita e constantemente atualizada, ideal para iniciantes em C++ moderno. 
https://www.learncpp.com/

cppreference.com: A documentação mais completa e precisa sobre C e C++. Funciona como um guia definitivo para explorar a fundo como cada variável, operador e função operam internamente.
https://cppreference.com/cpp/compiler_support/29

cplusplus.com: Excelente para iniciantes buscarem tutoriais rápidos e exemplos práticos da biblioteca padrão.
https://cplusplus.com/doc/tutorial/

Livros Altamente Recomendados:

Programming: Principles and Practice Using C++ (Bjarne Stroustrup): Escrito pelo criador do C++, foca em programação fundamental e resolução de problemas, sendo voltado para o iniciante absoluto.
https://turan-edu.uz/media/books/2024/05/29/d9116f36-40ed-4147-86c6-47657eca6c64.pdf

C++ Primer (Stanley B. Lippman, Josée Lajoie, Barbara E. Moo): Um guia abrangente e didático que aborda desde a sintaxe central até a biblioteca padrão. Ideal para transitar do nível iniciante para o intermediário.
https://zhjwpku.com/assets/pdf/books/C++.Primer.5th.Edition_2013.pdf

C Completo e Total (Herbert Schildt): Uma referência clássica e tradicional em língua portuguesa para quem deseja dominar as nuances e os fundamentos da linguagem C.
https://www.inf.ufpr.br/lesoliveira/download/c-completo-total.pdf

Linguagem C++- Notas de Aula
https://www.inf.ufpr.br/ci208/NotasAula.pdf
