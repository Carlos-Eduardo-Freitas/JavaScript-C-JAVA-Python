# Aula de Java para Iniciantes

> Um guia introdutório e organizado em capítulos, cobrindo os primeiros passos com a linguagem Java: desde a configuração do ambiente até a leitura e exibição de dados no terminal.

---

## Índice

1. [Introdução ao Java](#capítulo-1---introdução-ao-java)
2. [Configurando o Ambiente](#capítulo-2---configurando-o-ambiente)
3. [Estrutura Básica de um Programa Java](#capítulo-3---estrutura-básica-de-um-programa-java)
4. [Variáveis e Tipos de Dados](#capítulo-4---variáveis-e-tipos-de-dados)
5. [Declarando e Inicializando Variáveis](#capítulo-5---declarando-e-inicializando-variáveis)
6. [Bibliotecas e Imports](#capítulo-6---bibliotecas-e-imports)
7. [Exibindo Dados no Terminal](#capítulo-7---exibindo-dados-no-terminal)
8. [Lendo Dados do Usuário (Scanner)](#capítulo-8---lendo-dados-do-usuário-scanner)
9. [Operadores Básicos](#capítulo-9---operadores-básicos)
10. [Exemplo Prático Completo](#capítulo-10---exemplo-prático-completo)
11. [Exercícios Propostos](#capítulo-11---exercícios-propostos)

---

## Capítulo 1 - Introdução ao Java

Java é uma linguagem de programação orientada a objetos, criada pela Sun Microsystems (hoje mantida pela Oracle). Ela é muito usada no mercado para desenvolvimento de sistemas corporativos, aplicativos Android, sistemas backend e muito mais.

### Por que Java é diferente de outras linguagens?

Java segue o princípio **"Write Once, Run Anywhere"** (escreva uma vez, rode em qualquer lugar). Isso é possível graças a dois componentes fundamentais:

- **JDK (Java Development Kit):** o kit de ferramentas para desenvolver programas Java. Inclui o compilador (`javac`), a JVM e outras utilidades.
- **JVM (Java Virtual Machine):** a máquina virtual que executa o código Java. Ela traduz o "bytecode" (código intermediário gerado pelo compilador) para instruções que o sistema operacional entende.

Ou seja: você escreve o código `.java`, o compilador (`javac`) transforma esse código em bytecode (`.class`), e a JVM executa esse bytecode em qualquer sistema operacional que tenha uma JVM instalada.

```
Código-fonte (.java) → Compilador (javac) → Bytecode (.class) → JVM → Execução
```

### Características principais

- **Orientada a objetos:** tudo em Java gira em torno de classes e objetos.
- **Fortemente tipada:** toda variável precisa ter um tipo definido antes de ser usada.
- **Compilada e interpretada:** o código é compilado para bytecode, e depois interpretado pela JVM.
- **Multiplataforma:** roda em Windows, Linux, macOS, etc.

---

## Capítulo 2 - Configurando o Ambiente

Antes de escrever qualquer código, você precisa ter o **JDK** instalado na sua máquina.

### Passo a passo

1. Baixe o JDK (recomenda-se a versão LTS mais recente, como o JDK 21) no site da Oracle ou use uma distribuição gratuita como o **Eclipse Temurin (Adoptium)**.
2. Instale o JDK seguindo o instalador do seu sistema operacional.
3. Verifique se a instalação funcionou abrindo o terminal e digitando:

```bash
java -version
javac -version
```

Se aparecerem as versões instaladas, está tudo certo.

### Editor de código

Você pode escrever Java em qualquer editor de texto, mas o ideal é usar uma IDE (Ambiente de Desenvolvimento Integrado) que facilita muito o trabalho, como:

- **IntelliJ IDEA** (Community Edition é gratuita)
- **Eclipse**
- **VS Code** (com a extensão "Extension Pack for Java")

### Compilando e executando pelo terminal

Supondo que você tenha um arquivo chamado `Main.java`:

```bash
javac Main.java   # gera o arquivo Main.class (bytecode)
java Main         # executa o programa
```

---

## Capítulo 3 - Estrutura Básica de um Programa Java

Todo programa Java precisa, no mínimo, de uma classe e de um método `main`, que é o ponto de entrada da execução.

```java
public class Main {
    public static void main(String[] args) {
        // seu código vai aqui
    }
}
```

### Explicando cada parte

| Parte | O que significa |
|---|---|
| `public class Main` | Declara uma classe pública chamada `Main`. O nome da classe **precisa** ser igual ao nome do arquivo (`Main.java`). |
| `public static void main(String[] args)` | Método principal, ponto de partida do programa. É sempre executado primeiro. |
| `public` | O método pode ser acessado de fora da classe. |
| `static` | O método pertence à classe, não é necessário criar um objeto para executá-lo. |
| `void` | Indica que o método não retorna nenhum valor. |
| `String[] args` | Permite receber argumentos passados pela linha de comando. |

> **Importante:** em Java, cada instrução termina com ponto e vírgula (`;`), e blocos de código ficam entre chaves (`{ }`).

---

## Capítulo 4 - Variáveis e Tipos de Dados

Variáveis são espaços na memória usados para armazenar valores. Em Java, toda variável precisa de um **tipo** definido.

### Tipos primitivos

| Tipo | Descrição | Exemplo de valor | Tamanho |
|---|---|---|---|
| `int` | Números inteiros | `10`, `-5` | 4 bytes |
| `long` | Inteiros muito grandes | `10000000000L` | 8 bytes |
| `float` | Números decimais (menor precisão) | `3.14f` | 4 bytes |
| `double` | Números decimais (maior precisão) | `3.14159` | 8 bytes |
| `char` | Um único caractere | `'A'` | 2 bytes |
| `boolean` | Verdadeiro ou falso | `true`, `false` | 1 bit |
| `byte` | Inteiro pequeno | `127` | 1 byte |
| `short` | Inteiro curto | `32000` | 2 bytes |

### Tipo não-primitivo importante: String

`String` não é um tipo primitivo, é uma classe. Ela representa uma sequência de caracteres (texto).

```java
String nome = "Carlos";
```

> **Dica:** valores do tipo `float` precisam do sufixo `f` (ex: `3.14f`), e valores do tipo `long` precisam do sufixo `L` (ex: `1000000000L`), caso contrário o compilador pode gerar erro ou interpretar o valor como outro tipo.

---

## Capítulo 5 - Declarando e Inicializando Variáveis

### Sintaxe geral

```java
tipo nomeDaVariavel = valor;
```

### Exemplos

```java
int idade = 25;
double altura = 1.75;
char inicial = 'C';
boolean estudando = true;
String cidade = "Fortaleza";
```

### Declaração sem inicialização

É possível declarar uma variável sem atribuir um valor imediatamente, mas ela precisa ser inicializada antes de ser usada:

```java
int nota;
nota = 8; // agora sim pode ser usada
```

### Declarando múltiplas variáveis do mesmo tipo

```java
int a = 1, b = 2, c = 3;
```

### Constantes

Quando um valor não deve mudar durante a execução, usa-se a palavra-chave `final`:

```java
final double PI = 3.14159;
```

### Boas práticas de nomenclatura

- Variáveis: **camelCase** (ex: `minhaVariavel`)
- Constantes: **MAIÚSCULAS** com underline (ex: `VALOR_MAXIMO`)
- Classes: **PascalCase** (ex: `MinhaClasse`)

---

## Capítulo 6 - Bibliotecas e Imports

Para usar funcionalidades que não fazem parte do núcleo básico da linguagem, é preciso **importar** bibliotecas (pacotes) do Java.

### Sintaxe de import

```java
import nome.do.pacote.Classe;
```

### Biblioteca essencial para iniciantes: Scanner

Para ler dados digitados pelo usuário no terminal, usamos a classe `Scanner`, que fica dentro do pacote `java.util`:

```java
import java.util.Scanner;
```

Esse import deve ficar **antes** da declaração da classe:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // ...
    }
}
```

> **Observação:** classes do pacote `java.lang` (como `String`, `System`, `Math`) são importadas automaticamente pelo Java, por isso não precisamos escrever `import java.lang.System`.

---

## Capítulo 7 - Exibindo Dados no Terminal

A classe `System.out` é usada para exibir informações no console.

### Principais métodos

| Método | O que faz |
|---|---|
| `System.out.println()` | Imprime o texto e pula para a próxima linha |
| `System.out.print()` | Imprime o texto sem pular linha |
| `System.out.printf()` | Imprime texto formatado |

### Exemplos

```java
System.out.println("Olá, mundo!");
System.out.print("Sem pular linha ");
System.out.print("continua aqui");
```

### Concatenando texto com variáveis

```java
String nome = "Carlos";
int idade = 20;
System.out.println("Nome: " + nome + ", Idade: " + idade);
```

### Formatando saída com printf

O `printf` permite controlar casas decimais, alinhamento e tipo de dado exibido:

```java
double media = 6.431818;
System.out.printf("MEDIA = %.2f%n", media); // MEDIA = 6.43
```

| Especificador | Significado |
|---|---|
| `%d` | número inteiro |
| `%f` | número decimal |
| `%.2f` | número decimal com 2 casas |
| `%s` | texto (String) |
| `%n` | quebra de linha |

---

## Capítulo 8 - Lendo Dados do Usuário (Scanner)

Depois de importar e instanciar o `Scanner`, podemos usar seus métodos para capturar dados digitados pelo usuário.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = entrada.nextInt();

        System.out.println("Olá, " + nome + "! Você tem " + idade + " anos.");
    }
}
```

### Principais métodos do Scanner

| Método | Tipo lido |
|---|---|
| `nextInt()` | número inteiro |
| `nextFloat()` | número decimal (float) |
| `nextDouble()` | número decimal (double) |
| `nextLine()` | texto (linha inteira) |
| `next()` | uma palavra (sem espaços) |

> **Cuidado comum:** se você usar `nextInt()` (ou `nextDouble()`) seguido de `nextLine()`, o `nextLine()` pode "pular" e capturar uma string vazia. Isso acontece porque `nextInt()` não consome a quebra de linha deixada no buffer. Uma solução comum é adicionar um `entrada.nextLine()` extra logo após o `nextInt()` para "limpar" o buffer.

---

## Capítulo 9 - Operadores Básicos

### Operadores aritméticos

| Operador | Significado | Exemplo |
|---|---|---|
| `+` | soma | `a + b` |
| `-` | subtração | `a - b` |
| `*` | multiplicação | `a * b` |
| `/` | divisão | `a / b` |
| `%` | resto da divisão (módulo) | `a % b` |

### Operadores de atribuição

| Operador | Equivalente |
|---|---|
| `+=` | `a = a + b` |
| `-=` | `a = a - b` |
| `*=` | `a = a * b` |
| `/=` | `a = a / b` |

### Operadores relacionais (retornam boolean)

| Operador | Significado |
|---|---|
| `==` | igual a |
| `!=` | diferente de |
| `>` | maior que |
| `<` | menor que |
| `>=` | maior ou igual |
| `<=` | menor ou igual |

### Operadores lógicos

| Operador | Significado |
|---|---|
| `&&` | E (AND) |
| \|\| | OU (OR) |
| `!` | negação (NOT) |

---

## Capítulo 10 - Exemplo Prático Completo

Juntando tudo o que vimos até aqui, um programa completo que lê dois valores e calcula uma média ponderada, exibindo o resultado formatado:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double a = dado.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double b = dado.nextDouble();

        double media = ((a * 3.5) + (b * 7.5)) / (3.5 + 7.5);

        System.out.printf("MEDIA = %.5f%n", media);
    }
}
```

### O que esse programa faz, passo a passo

1. Importa a classe `Scanner` para poder ler dados do teclado.
2. Cria um objeto `Scanner` chamado `dado`, associado à entrada padrão (`System.in`).
3. Lê dois valores `double` digitados pelo usuário.
4. Calcula a média ponderada, dividindo pela soma dos pesos (`3.5 + 7.5`).
5. Exibe o resultado formatado com 5 casas decimais.

---

## Capítulo 11 - Exercícios Propostos

1. Crie um programa que leia o nome e a idade do usuário e exiba uma mensagem de boas-vindas.
2. Crie um programa que leia dois números inteiros e exiba a soma, subtração, multiplicação e divisão entre eles.
3. Crie um programa que leia três notas de um aluno e calcule a média aritmética simples, exibindo com 2 casas decimais.
4. Crie um programa que leia o raio de um círculo e calcule sua área (`Math.PI * raio * raio`).
5. Crie um programa que leia um valor em Celsius e converta para Fahrenheit (`F = C * 9/5 + 32`).

---

## Resumo do Capítulo

- Java é uma linguagem orientada a objetos, compilada para bytecode e executada pela JVM.
- Todo programa precisa de uma classe com um método `main`.
- Variáveis precisam de um tipo definido antes de serem usadas.
- A classe `Scanner` (do pacote `java.util`) é usada para ler dados do usuário.
- `System.out.println`, `print` e `printf` são usados para exibir dados no terminal.
- `printf` com `%.Nf` permite controlar casas decimais na exibição de números.
