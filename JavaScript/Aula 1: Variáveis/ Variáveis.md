# Aula: Variáveis, Tipos e Operadores em JavaScript

## Introdução

Pense na memória do computador como um armário cheio de caixas vazias. Para guardar um valor ali dentro, você precisa colar uma etiqueta na caixa — esse é o papel de uma **variável**: um nome que aponta para um valor guardado na memória, e que pode (ou não) mudar durante a execução do programa.

Este material reúne teoria, exemplos e exercícios em JavaScript sobre variáveis, tipos de dados e operadores.

---

## 1. Variáveis

Em JavaScript, existem duas formas recomendadas de declarar uma variável:

- **`const`** — para valores que **não mudam** depois de definidos.
- **`let`** — para valores que **podem mudar** ao longo da execução.

```javascript
const pi = 3.14159;      // valor fixo — tentar reatribuir gera erro
let temperatura = 22.5;  // valor pode ser alterado depois
```

> Existe também a palavra `var`, mais antiga. Ela ainda funciona, mas tem comportamentos que causam bugs sutis (como não respeitar o escopo de blocos `{ }`). Por isso, hoje em dia se prefere sempre `const` ou `let`.

### "=" não é igualdade matemática

Se você já estudou álgebra, pode estranhar uma linha como:

```javascript
contador = contador + 1;
```

Na programação, `=` é o operador de **atribuição**, não de igualdade. Leia essa linha como: *"pegue o valor que está em `contador`, some 1, e guarde o resultado de volta em `contador`"*.

### Boas práticas de nomenclatura

- Use **camelCase**: primeira palavra minúscula, as seguintes começando com maiúscula (`quantidadeAlunos`, `notaFinal`).
- Use nomes que descrevam o conteúdo: `let x = 9.8;` é menos claro que `let aceleracaoGravidade = 9.8;`.
- Inicialize a variável antes de usá-la.
- Evite nomes genéricos como `x`, `y`, `dado1`, a menos que o contexto seja realmente matemático.

### Palavras reservadas

Essas palavras já têm um significado especial na linguagem e **não podem** ser usadas como nome de variável, função ou classe:

| Controle de fluxo | Funções e estrutura | Tipos e estado |
|---|---|---|
| `if`, `else`, `switch`, `case`, `default` | `function`, `return`, `class`, `extends`, `constructor`, `super` | `true`, `false`, `null`, `undefined` |
| `for`, `while`, `do`, `break`, `continue` | `import`, `export`, `from`, `async`, `await` | `typeof`, `instanceof`, `new`, `this`, `delete` |
| `const`, `let`, `var` | `try`, `catch`, `finally`, `throw` | |

---

## 2. Tipos de dados

O tipo de uma variável define quais valores ela pode guardar e quais operações são permitidas com ela. Em JavaScript, o tipo é definido automaticamente conforme o valor atribuído (**tipagem dinâmica**), mas os tipos em si são bem definidos:

- **`number`** — qualquer valor numérico, inteiro ou decimal. JavaScript não diferencia `int` de `float`: `10` e `10.00` são do mesmo tipo.
- **`string`** — texto, delimitado por aspas simples ou duplas. Ex: `"Ana"`, `"0.0025"` (atenção: isso é texto, não número!).
- **`boolean`** — só existem dois valores possíveis: `true` ou `false`.
- **`undefined`** — variável que foi declarada, mas ainda não recebeu nenhum valor.
- **`null`** — ausência de valor definida de propósito pelo programador.

### Por que isso importa na prática

```javascript
let amostraA = "20"; // tipo: string
let amostraB = 10;   // tipo: number

let resultado = amostraA + amostraB;
console.log(resultado); // "2010" — e não 30!
```

O operador `+`, quando encontra uma `string`, deixa de somar e passa a **concatenar** (juntar textos). Misturar tipos sem perceber é uma das causas mais comuns de bugs para quem está começando — por isso vale sempre checar o tipo de uma variável com `typeof` quando algo parecer estranho.

---

## 3. Operadores

### 3.1 Atribuição

- `=` atribui um valor.
- `+=`, `-=`, `*=`, `/=` atualizam o valor atual de forma resumida.

```javascript
contador += 1; // equivale a: contador = contador + 1;
massa *= 2;    // equivale a: massa = massa * 2;
```

### 3.2 Relacionais (comparação)

Comparam dois valores e retornam sempre `true` ou `false`.

| Operador | Significado |
|---|---|
| `===` | estritamente igual (mesmo valor **e** mesmo tipo) |
| `!==` | estritamente diferente |
| `>` | maior que |
| `<` | menor que |
| `>=` | maior ou igual |
| `<=` | menor ou igual |

> **Prefira sempre `===` em vez de `==`.** O `==` compara tentando "adivinhar" o tipo (`"10" == 10` dá `true`), o que costuma causar bugs difíceis de rastrear. O `===` só é verdadeiro se valor e tipo forem iguais (`"10" === 10` dá `false`).

Exemplo: `idade >= 18` retorna `true` se `idade` for 18 ou mais.

### 3.3 Lógicos

Combinam expressões booleanas.

- **`&&` (E)** — só é `true` se **todas** as condições forem verdadeiras.
- **`||` (OU)** — é `true` se **pelo menos uma** condição for verdadeira.
- **`!` (NÃO)** — inverte o valor lógico.

**Tabela-verdade — `&&` (E)**

| A | B | A && B |
|---|---|---|
| `false` | `false` | `false` |
| `false` | `true`  | `false` |
| `true`  | `false` | `false` |
| `true`  | `true`  | `true`  |

**Tabela-verdade — `||` (OU)**

| A | B | A \|\| B |
|---|---|---|
| `false` | `false` | `false` |
| `false` | `true`  | `true`  |
| `true`  | `false` | `true`  |
| `true`  | `true`  | `true`  |

**Tabela-verdade — `!` (NÃO)**

| A | !A |
|---|---|
| `false` | `true`  |
| `true`  | `false` |

Exemplo: `(nota >= 6.0) && (frequencia >= 75)` só é `true` se as duas condições forem satisfeitas ao mesmo tempo.

---

## Exemplo integrado

Um cadastro só é liberado se a pessoa tiver idade mínima **e** tiver aceitado os termos de uso:

```javascript
// Entrada
const idadeMinima = 18;
let idade = 19;
let aceitouTermos = true;

// Processamento
const cadastroLiberado = (idade >= idadeMinima) && (aceitouTermos === true);

// Saída
console.log("Cadastro liberado?");
console.log(cadastroLiberado); // true
```

---

## Fechamento

Nesta aula, vimos como:

1. declarar e nomear variáveis corretamente (`const`, `let`, camelCase, palavras reservadas);
2. reconhecer os tipos de dados de JavaScript e evitar erros de mistura de tipos;
3. usar operadores de atribuição, comparação e lógicos para construir expressões.

Esses conceitos são a base para estruturas de decisão (`if`), repetição (`for`, `while`) e funções — assunto das próximas aulas.

---

## Saiba mais

- [Documentação JavaScript (MDN)](https://developer.mozilla.org/pt-BR/docs/Web/JavaScript)
- [Especificação ECMAScript (ECMA-262)](https://tc39.es/ecma262/)
