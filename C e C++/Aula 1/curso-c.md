# Curso Completo de C — Do Zero ao Avançado

> Curso teórico e prático da linguagem C, organizado em capítulos modulares, no espírito denso e sem atalhos de "Matemática para Vencer" (Laércio Vasconcelos). Ambiente de referência: **CLion (JetBrains)**.

---

## Índice Geral (planejado)

1. **Fundações, História e o Primeiro Contato** ✅ (neste arquivo)
2. Armazenamento, Tipos de Dados e Variáveis
3. Operações Básicas e Aritmética Computacional
4. *(capítulos seguintes serão adicionados nas próximas aulas: controle de fluxo, funções, arrays, ponteiros, strings, structs, alocação dinâmica, arquivos, etc.)*

---

# Capítulo 1 — Fundações, História e o Primeiro Contato

## 1.1 História e Filosofia do C

### 1.1.1 O nascimento nos laboratórios Bell

C nasceu entre 1969 e 1973 nos **Bell Telephone Laboratories** (AT&T), como fruto do trabalho de **Dennis Ritchie**, em conjunto com **Ken Thompson**. Não foi um projeto acadêmico abstrato: foi uma resposta a um problema de engenharia muito concreto — Thompson estava reescrevendo o sistema operacional **Unix**, que originalmente havia sido escrito em Assembly para o PDP-7, e precisava de uma linguagem que fosse portável entre arquiteturas de hardware diferentes, mas que ainda desse acesso quase direto à máquina (registradores, endereços de memória, bits).

Antes do C, Thompson criou uma linguagem chamada **B**, derivada da BCPL (Basic Combined Programming Language) de Martin Richards. B era tipada de forma muito fraca — praticamente tudo era uma "palavra de máquina". Ritchie pegou B, adicionou um sistema de tipos (o `char`, o `int`, mais tarde `struct`), e o resultado, por volta de 1972, foi batizado de **C** — a letra seguinte de B no alfabeto, e também a segunda letra de BCPL.

Em 1973, o Unix foi **reescrito quase inteiramente em C** (mantendo apenas uma pequena parte crítica em Assembly, como o *bootstrap* e trechos que manipulam registradores diretamente). Esse foi o evento fundador que definiu o destino do C: uma linguagem de sistemas que é, ao mesmo tempo, portável (o mesmo código-fonte compila em arquiteturas diferentes) e de baixo nível (dá controle fino sobre memória).

O artigo de referência histórica mais citado sobre esse período é:

> Ritchie, D. M. **"The Development of the C Language"**. Em *History of Programming Languages II* (HOPL-II), ACM, 1993.

Nesse artigo, o próprio Ritchie narra as decisões de design — por exemplo, por que ponteiros e arrays são tratados de forma tão entrelaçada em C (algo que discutiremos com profundidade no capítulo sobre ponteiros). Ele explica que muitas escolhas de C não foram "elegância teórica", mas sim **pragmatismo de engenharia**: o compilador precisava ser simples o suficiente para rodar em máquinas com pouquíssima memória (o PDP-11 original tinha a ordem de 64 KB de memória endereçável).

### 1.1.2 Por que o C continua sendo a base da computação moderna

Mais de 50 anos depois, C continua no núcleo da infraestrutura mundial pelos seguintes motivos estruturais:

1. **Proximidade do hardware sem ser Assembly.** C expõe ponteiros, endereços e manipulação de bits, mas com uma sintaxe portável entre arquiteturas (x86, ARM, RISC-V, etc.).
2. **Ausência de "runtime pesado".** Não existe coletor de lixo, não existe máquina virtual. Um binário compilado em C interage quase diretamente com o sistema operacional através de *syscalls*.
3. **É a linguagem em que os próprios sistemas operacionais são escritos.** Linux, Windows (núcleo, em grande parte), macOS/XNU, e praticamente todo firmware embarcado têm C em seu núcleo.
4. **É o "denominador comum" de interoperabilidade.** Quase toda linguagem moderna (Python, Java/JVM, Node.js, Rust) tem uma **FFI (Foreign Function Interface)** que fala C, porque o **ABI (Application Binary Interface)** do C é o padrão de fato para comunicação entre linguagens.

### 1.1.3 A filosofia de design: "confie no programador"

Diferente de linguagens modernas com *guard rails* (verificação de limites de array, tipagem forte em tempo de execução, gerenciamento automático de memória), C parte de uma filosofia deliberada: **o compilador confia que você sabe o que está fazendo**. Isso significa:

- Não há verificação automática de limites de array (*bounds checking*) — acessar `vetor[10]` em um vetor de tamanho 5 não gera erro imediato, gera **comportamento indefinido** (*undefined behavior*, UB).
- A memória alocada dinamicamente não é liberada automaticamente — você é responsável por `free()`.
- Conversões de tipo (*casts*) podem ser feitas mesmo quando são perigosas.

Essa filosofia é, ao mesmo tempo, a maior força e a maior fraqueza histórica de C: força, porque dá desempenho e controle máximos; fraqueza, porque é fonte histórica da maioria das vulnerabilidades de segurança de software (buffer overflows, use-after-free, etc.) catalogadas em bancos como o CVE (Common Vulnerabilities and Exposures). Vamos tratar esse tema com seriedade técnica ao longo do curso — não como nota de rodapé, mas como parte central de "pensar em C".

---

## 1.2 Ecossistema e Ferramentas

### 1.2.1 O papel do compilador

Um compilador de C traduz código-fonte (texto legível por humanos) em código de máquina (instruções binárias executáveis pela CPU). Os dois compiladores dominantes hoje são:

| Compilador | Origem | Observação |
|---|---|---|
| **GCC** (GNU Compiler Collection) | Projeto GNU, 1987 | Padrão em distribuições Linux; extremamente maduro |
| **Clang** (parte do projeto LLVM) | Apple/comunidade LLVM, 2007 | Mensagens de erro mais legíveis; base de muitas ferramentas de análise estática |

No Windows, também existe o **MSVC** (Microsoft Visual C++ compiler), e no mundo embarcado há compiladores especializados por fabricante (IAR, Keil). O CLion, que você está usando, normalmente se integra ao **GCC/Clang via MinGW ou WSL no Windows**, ou diretamente ao GCC/Clang nativo em Linux/macOS.

### 1.2.2 O processo de compilação em 4 etapas

Um erro comum de iniciante é achar que "compilar" é um passo único. Na realidade, são **quatro fases distintas**, e entender cada uma delas é fundamental para depurar erros com precisão:

```
arquivo.c
   │
   ▼
┌─────────────────────┐
│ 1. PRÉ-PROCESSAMENTO │  → resolve #include, #define, #ifdef
└─────────────────────┘
   │  (gera um .i, código C "expandido")
   ▼
┌─────────────────────┐
│ 2. COMPILAÇÃO         │  → traduz C para Assembly
└─────────────────────┘
   │  (gera um .s, código Assembly)
   ▼
┌─────────────────────┐
│ 3. MONTAGEM (Assembly)│  → traduz Assembly para código de máquina
└─────────────────────┘
   │  (gera um .o ou .obj, "código objeto")
   ▼
┌─────────────────────┐
│ 4. LINKAGEM (Linking) │  → junta seu .o com bibliotecas (ex: printf vem da libc)
└─────────────────────┘
   │
   ▼
executável final (ex: a.out, programa.exe)
```

**Detalhe de cada fase:**

1. **Pré-processamento:** o pré-processador é literalmente um substituidor de texto. Quando você escreve `#include <stdio.h>`, ele copia e cola o conteúdo do arquivo `stdio.h` no topo do seu arquivo, antes de qualquer compilação real acontecer. `#define` funciona da mesma forma — substituição textual pura, sem entender tipos.
2. **Compilação:** o compilador propriamente dito analisa a sintaxe (parsing), verifica tipos, e gera código Assembly equivalente para a arquitetura alvo.
3. **Montagem:** o *assembler* traduz o Assembly (ainda legível por humanos) para bytes de instrução de máquina reais, produzindo um arquivo objeto — mas esse arquivo ainda tem "buracos" (referências a funções externas como `printf`, que ainda não foram resolvidas).
4. **Linkagem:** o *linker* resolve esses buracos, conectando seu código objeto às bibliotecas necessárias (estaticamente, copiando o código, ou dinamicamente, apenas referenciando uma `.so`/`.dll` que será carregada em tempo de execução) e produz o executável final.

Você pode ver cada fase manualmente usando o GCC pelo terminal:

```bash
gcc -E main.c -o main.i      # só pré-processamento
gcc -S main.i -o main.s      # só compilação (gera Assembly)
gcc -c main.s -o main.o      # só montagem (gera código objeto)
gcc main.o -o main           # só linkagem (gera executável)
```

Ou, no dia a dia, tudo isso de uma vez:

```bash
gcc main.c -o main
```

### 1.2.3 Referência científica: o impacto do C na engenharia de compiladores

Um marco importante nessa área é o próprio livro que formalizou a linguagem:

> Kernighan, B. W.; Ritchie, D. M. **"The C Programming Language"** (2ª edição, 1988) — conhecido informalmente como **"K&R"**.

Esse livro, além de ser a referência canônica da linguagem, popularizou o próprio "Hello World" como exemplo introdutório padrão em ciência da computação — uma convenção que se espalhou para praticamente toda linguagem criada depois.

---

## 1.3 Guia Prático do CLion

### 1.3.1 Criando um projeto do zero

1. Abra o CLion e clique em **New Project**.
2. No painel esquerdo, selecione **C Executable** (não "C++ Executable" — preste atenção, pois o CLion é uma IDE compartilhada entre C e C++, e é fácil selecionar o template errado).
3. Escolha o local do projeto e o **Language Standard** (padrão da linguagem). Para este curso, recomendo **C17** (o padrão estável mais recente amplamente suportado) — evite "C11" apenas se seu professor/ambiente exigir compatibilidade específica.
4. Clique em **Create**.

O CLion vai gerar automaticamente dois arquivos:

- `main.c` — seu código-fonte.
- `CMakeLists.txt` — o arquivo de configuração de build.

### 1.3.2 Entendendo o CMakeLists.txt básico

O CLion **não usa o GCC diretamente de forma "solta"** — ele usa o **CMake** como sistema de build (um "gerador de instruções de compilação"). Um `CMakeLists.txt` mínimo se parece com isto:

```cmake
cmake_minimum_required(VERSION 3.28)
project(meu_curso_c C)

set(CMAKE_C_STANDARD 17)

add_executable(meu_curso_c main.c)
```

- `project(meu_curso_c C)` — declara o nome do projeto e que a linguagem usada é C (não C++).
- `set(CMAKE_C_STANDARD 17)` — fixa o padrão da linguagem em C17.
- `add_executable(...)` — diz ao CMake quais arquivos `.c` compõem o executável final. **Sempre que você criar um novo arquivo `.c`, precisa adicioná-lo aqui** (o CLion geralmente sugere isso automaticamente, mas é importante entender que não é mágica).

### 1.3.3 Atalhos essenciais

| Ação | Windows/Linux | macOS |
|---|---|---|
| Executar (Run) | `Shift + F10` | `Ctrl + R` |
| Depurar (Debug) | `Shift + F9` | `Ctrl + D` |
| Adicionar breakpoint | Clique na margem esquerda da linha | Clique na margem esquerda da linha |
| Step Over (próxima linha, sem entrar em função) | `F8` | `F8` |
| Step Into (entrar dentro da função chamada) | `F7` | `F7` |
| Step Out (sair da função atual) | `Shift + F8` | `Shift + F8` |
| Reformatar código | `Ctrl + Alt + L` | `Cmd + Alt + L` |
| Buscar em todo o projeto | `Ctrl + Shift + F` | `Cmd + Shift + F` |
| Renomear símbolo com segurança (refatoração) | `Shift + F6` | `Shift + F6` |

### 1.3.4 Depuração (debugging) na prática

O debugger do CLion é uma das razões pelas quais vale a pena usar uma IDE em vez de apenas terminal + editor de texto. Fluxo básico:

1. Clique na margem esquerda de uma linha para adicionar um **breakpoint** (um ponto vermelho aparece).
2. Rode em modo **Debug** (`Shift + F9`).
3. O programa vai pausar exatamente naquela linha, **antes** de executá-la.
4. No painel inferior, você verá a aba **Variables**, mostrando o valor atual de cada variável em memória naquele instante — isso é extremamente valioso em C, onde "o que está na memória agora" é frequentemente a origem dos bugs.
5. Use `F8` para avançar linha por linha, observando como os valores mudam.

> **Boa prática específica de CLion:** ative a opção **"Show hexadecimal values"** no painel de variáveis quando estiver trabalhando com ponteiros — isso vai facilitar (nos próximos capítulos) visualizar endereços de memória reais.

---

## 1.4 Projetos Reais Escritos em C

### 1.4.1 O Kernel do Linux

O kernel Linux, iniciado por **Linus Torvalds** em 1991, é escrito majoritariamente em C (com pequenas partes em Assembly para código específico de arquitetura, como o `boot/`). Alguns fatos técnicos relevantes para um iniciante entender a escala:

- O kernel Linux tem dezenas de milhões de linhas de código C.
- Ele segue um guia de estilo rígido, documentado no próprio repositório em `Documentation/process/coding-style.rst`, que enfatiza legibilidade e consistência — algo que reforça, na prática, por que boas práticas de nomenclatura (que veremos no Capítulo 2) não são "frescura acadêmica", mas necessidade de engenharia em escala.
- O kernel usa C com extensões específicas do GCC/Clang (como atributos `__attribute__`), então tecnicamente não é "C puro" no sentido do padrão ISO, mas sim "C do GNU" (GNU C).

### 1.4.2 O Git

O **Git**, criado também por Linus Torvalds em 2005 (para substituir o BitKeeper como sistema de controle de versão do próprio kernel Linux), é escrito em C. É um excelente estudo de caso porque:

- É relativamente mais compacto que o kernel (algumas centenas de milhares de linhas), o que o torna mais abordável para estudo.
- Faz uso intensivo de manipulação de arquivos, hashing (SHA-1/SHA-256) e estruturas de dados como árvores e grafos — tudo implementado "na mão", sem bibliotecas externas pesadas, característico do estilo de programação em C.

### 1.4.3 Outros exemplos notáveis

- **Redis** — banco de dados em memória, C puro, famoso pela simplicidade e performance de seu código-fonte.
- **SQLite** — o banco de dados mais implantado do mundo (está em praticamente todo smartphone), inteiramente em C, com uma das suítes de teste mais rigorosas da história do software.
- **Servidores web como o nginx** — C, otimizado para lidar com dezenas de milhares de conexões simultâneas usando I/O não bloqueante.

---

## 1.5 O Primeiro Programa: "Hello, World!" Dissecado

### 1.5.1 O código completo

```c
#include <stdio.h>

int main() {
    printf("Ola, mundo!\n");
    return 0;
}
```

### 1.5.2 Dissecação linha por linha

**Linha 1: `#include <stdio.h>`**

- `#include` é uma **diretiva de pré-processador** (lembra da Fase 1 da compilação, seção 1.2.2?). Ela instrui o pré-processador a copiar o conteúdo do arquivo de cabeçalho (*header*) `stdio.h` para dentro do seu código, antes de qualquer compilação real acontecer.
- `stdio.h` significa **"Standard Input/Output Header"**. É onde estão as **declarações** (não as implementações) de funções como `printf`, `scanf`, `fopen`, etc.
- Os sinais `< >` (em vez de aspas `" "`) indicam ao compilador para procurar esse arquivo nos diretórios padrão do sistema (onde a biblioteca padrão do C fica instalada), e não na pasta do seu próprio projeto.

**Linha 3: `int main() {`**

- Toda execução de um programa em C começa pela função `main`. É o **ponto de entrada obrigatório** — sem uma função `main`, o linker (Fase 4) falha, porque não sabe onde começar a executar.
- `int` antes de `main` significa que essa função **retorna um número inteiro** para o sistema operacional quando termina. Esse número é chamado de **código de saída** (*exit code*) e é usado por outros programas (ou scripts) para saber se o programa terminou com sucesso ou com erro.
- Os parênteses vazios `()` indicam que, nessa versão, `main` não recebe argumentos de linha de comando (existe uma variação `int main(int argc, char *argv[])`, que veremos mais adiante no curso).
- A chave `{` abre o **bloco de código** do corpo da função.

**Linha 4: `printf("Ola, mundo!\n");`**

- `printf` é uma função declarada em `stdio.h` (cuja implementação real está na **biblioteca padrão do C**, a *libc*, que será conectada ao seu programa na Fase 4 — linkagem).
- `"Ola, mundo!\n"` é uma **string literal** — uma sequência de caracteres entre aspas duplas.
- `\n` é uma **sequência de escape**: representa um único caractere especial (quebra de linha, *newline*), não dois caracteres `\` e `n`. O compilador interpreta essa sequência de dois símbolos no código-fonte como um único byte (0x0A em ASCII) no binário final.
- O `;` no final é **obrigatório** — em C, o ponto e vírgula marca o fim de uma instrução (*statement*). Esquecê-lo é o erro de sintaxe mais comum entre iniciantes.

**Linha 5: `return 0;`**

- Devolve o valor `0` como código de saída da função `main` para o sistema operacional.
- Por convenção quase universal em sistemas Unix/Linux (e adotada também no Windows), **`0` significa "sucesso"**, e qualquer valor diferente de zero significa algum tipo de erro (o valor específico pode ser usado para indicar *qual* erro, dependendo da convenção do programa).
- Você pode verificar esse valor no terminal logo após rodar o programa, no Linux/macOS, digitando `echo $?`.

**Linha 6: `}`**

- Fecha o bloco de código da função `main`, correspondente à chave aberta na linha 3.

### 1.5.3 O que acontece "por baixo dos panos" quando você roda `printf`

Isso é importante entender desde já, mesmo em nível introdutório: `printf` **não é uma instrução mágica da linguagem** — é uma função normal, como qualquer outra que você vai aprender a escrever. Ela está definida na *libc* (biblioteca padrão C), e o que ela faz, resumidamente, é:

1. Interpretar a string de formato (procurando por especificadores como `%d`, `%s`, que veremos no Capítulo 2).
2. Montar a saída final como uma sequência de bytes.
3. Fazer uma chamada de sistema (*syscall*) — no Linux, tipicamente `write()` — para entregar esses bytes ao **descritor de arquivo 1** (`stdout`, a saída padrão), que o terminal está "escutando" e exibe na tela.

Ou seja: escrever na tela **não é instantâneo nem "mágico"** — é uma cadeia de chamadas que termina em uma interação real com o sistema operacional.

---

## 1.6 Exercícios Resolvidos

### Exercício 1 — Saudação simples

**Enunciado:** Escreva um programa que exiba "Bem-vindo ao curso de C!" no terminal.

```c
#include <stdio.h>

int main() {
    printf("Bem-vindo ao curso de C!\n");
    return 0;
}
```

**Comentário sobre a lógica:** exercício direto de fixação da estrutura mínima de um programa C. O ponto de atenção é não esquecer o `\n` no final — sem ele, o prompt do terminal apareceria colado ao final da sua frase na próxima linha, o que é um erro estético comum.

---

### Exercício 2 — Múltiplas linhas com `print` vs `printf`

**Enunciado:** Exiba três frases em três linhas separadas, usando apenas uma chamada de `printf`.

```c
#include <stdio.h>

int main() {
    printf("Primeira linha\nSegunda linha\nSegunda linha\n");
    return 0;
}
```

**Comentário sobre a lógica:** demonstra que `\n` pode ser inserido em qualquer ponto dentro da string, quantas vezes for necessário, sem precisar de múltiplas chamadas à função. Isso reforça que a string é apenas uma sequência de bytes interpretada de uma vez.

---

### Exercício 3 — Exibindo aspas dentro de uma string

**Enunciado:** Exiba a frase: `Ele disse: "Ola, mundo!"` (com aspas duplas dentro da string).

```c
#include <stdio.h>

int main() {
    printf("Ele disse: \"Ola, mundo!\"\n");
    return 0;
}
```

**Comentário sobre a lógica:** aqui entra outra sequência de escape, `\"`, que representa o caractere de aspas dupla **literal**, dentro de uma string que já é delimitada por aspas duplas. Sem o `\`, o compilador interpretaria a segunda aspas como o **fim** da string, gerando um erro de sintaxe logo em seguida.

---

### Exercício 4 — Código de saída customizado

**Enunciado:** Escreva um programa que exiba uma mensagem e retorne o código de saída `1` (em vez de `0`), e depois verifique esse valor no terminal.

```c
#include <stdio.h>

int main() {
    printf("Este programa vai terminar com erro proposital.\n");
    return 1;
}
```

No terminal (Linux/macOS), após compilar e rodar:

```bash
gcc exercicio4.c -o exercicio4
./exercicio4
echo $?
```

**Comentário sobre a lógica:** o objetivo é tornar tangível o conceito da seção 1.5.2 — o valor de retorno de `main` não é "decorativo", ele é efetivamente lido pelo shell. Esse mecanismo é usado extensivamente em scripts de automação (ex: `if meu_programa; then ... fi`).

---

### Exercício 5 — Comentários em C

**Enunciado:** Reescreva o "Hello World" adicionando um comentário de uma linha explicando o `#include`, e um comentário de bloco (múltiplas linhas) explicando o `main`.

```c
#include <stdio.h> // importa as funcoes de entrada e saida padrao

/*
 * A funcao main e o ponto de entrada do programa.
 * Tudo que esta dentro dela sera executado quando o
 * programa for iniciado pelo sistema operacional.
 */
int main() {
    printf("Ola, mundo!\n");
    return 0;
}
```

**Comentário sobre a lógica:** apresenta as duas formas de comentário em C — `//` (linha única, a partir do C99) e `/* ... */` (bloco, existente desde o C original de 1972/1978). Comentários são **completamente removidos na Fase 1 (pré-processamento)** e não têm nenhum efeito no binário final — servem apenas para humanos.

---

## 1.7 Exercícios Propostos

**Fácil**

1. Escreva um programa que exiba seu nome completo e o nome da sua universidade em duas linhas separadas.
2. Escreva um programa que exiba a arte ASCII de um quadrado simples usando apenas caracteres `*`, com uma única chamada de `printf` (use `\n` para separar as linhas).

**Médio**

3. Escreva um programa que use `printf` para exibir uma frase contendo tanto aspas duplas quanto uma barra invertida literal (`\`) — pesquise qual sequência de escape representa a barra invertida.
4. Compile um programa usando os quatro comandos manuais da seção 1.2.2 (`-E`, `-S`, `-c`, e a linkagem final) em vez de `gcc main.c -o main` direto. Abra o arquivo `.i` gerado em um editor de texto e observe o que aconteceu com a linha `#include <stdio.h>`.

**Difícil**

5. No CLion, coloque um breakpoint na linha do `printf` do "Hello World", rode em modo Debug, e use o painel de variáveis para confirmar que — nesse programa específico — não há variáveis locais declaradas ainda (isso prepara terreno conceitual para o Capítulo 2, onde isso vai mudar).

---

## Resumo do Capítulo 1

- C foi criado por Dennis Ritchie (com Ken Thompson) entre 1969–1973, nos Bell Labs, para reescrever o Unix de forma portável.
- A filosofia de C é "confiar no programador": controle máximo, verificação mínima em tempo de execução.
- A compilação em C acontece em quatro fases distintas: pré-processamento, compilação, montagem e linkagem.
- CLion usa CMake (via `CMakeLists.txt`) como sistema de build por trás dos panos.
- Linux, Git, Redis e SQLite são exemplos reais e estudáveis de grandes sistemas escritos em C.
- `main` é o ponto de entrada obrigatório; seu valor de retorno é o código de saída do processo.
- `printf` não é mágica de linguagem — é uma função da biblioteca padrão que, no fim, chama uma *syscall* de escrita.

---

*Próxima aula: Capítulo 2 — Armazenamento, Tipos de Dados e Variáveis (memória, endereços, `int`/`float`/`double`/`char`, `scanf`, e o padrão ANSI C).*
