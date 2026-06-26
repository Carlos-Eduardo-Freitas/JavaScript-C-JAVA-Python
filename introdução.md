### 1. Variáveis
Variáveis são espaços de memória usados para armazenar valores que podem mudar durante a execução de um algoritmo.

Exemplos:
- `let idade = 20;`
- `let media = 8.5;`
- `const nome = "Ana";`

Boas práticas:
- usar nomes claros (`quantidadeAlunos`, `notaFinal`);
- inicializar variáveis antes de usar;
- preferir `const` por padrão e `let` quando houver mudança de valor;
- evitar palavras reservadas da linguagem como nome de variável;
- evitar nomes genéricos como `x`, `y` quando o contexto não for matemático.

#### 1.1 Palavras reservadas (principais)
Palavras reservadas nao devem ser usadas como identificadores (nome de variavel, funcao, classe etc.).

Lista principal em JavaScript:
- `let`, `const`, `var`
- `if`, `else`, `switch`, `case`, `default`
- `for`, `while`, `do`, `break`, `continue`
- `function`, `return`
- `class`, `extends`, `constructor`, `super`
- `try`, `catch`, `finally`, `throw`
- `new`, `this`, `typeof`, `instanceof`, `delete`
- `import`, `export`, `from`
- `async`, `await`
- `true`, `false`, `null`

### 2. Tipos de variáveis
O tipo define quais valores uma variável pode guardar e quais operações são permitidas.

Principais tipos em JavaScript:
- `number`: inteiros e decimais (`-3`, `0`, `3.14`);
- `string`: textos (`"Computação"`, `'A'`);
- `boolean`: `true` ou `false`;
- `undefined`: valor padrão de variável não inicializada;
- `null`: ausência intencional de valor.

Importância em Ciência da Computação:
- influencia uso de memória;
- impacta desempenho;
- evita erros de processamento (ex.: concatenar texto e número sem querer).

### 3. Operadores
Operadores permitem manipular e comparar dados.

#### 3.1 Atribuição
Usado para armazenar valor em variável.
- `=` atribui valor
- `+=`, `-=`, `*=`, `/=` atualizam com base no valor atual
Exemplo: `contador += 1;`

#### 3.2 Relacionais/comparação
Retornam valor booleano.
- `===` estritamente igual (valor e tipo)
- `!==` estritamente diferente
- `>` maior que
- `<` menor que
- `>=` maior ou igual
- `<=` menor ou igual

Exemplo:
`idade >= 18` retorna `true` se a idade for 18 ou mais.

#### 3.3 Lógicos
Combinam expressões booleanas.
- `&&` (E): `true` se ambas forem verdadeiras
- `||` (OU): `true` se ao menos uma for verdadeira
- `!` (NÃO): inverte o valor lógico

Exemplo:
`(nota >= 6.0) && (frequencia >= 75)`

#### 3.3.1 Tabela-verdade
**`&&` (E)**

| A | B | A && B (A e B) |
|---|---|--------|
| `false` | `false` | `false` |
| `false` | `true`  | `false` |
| `true`  | `false` | `false` |
| `true`  | `true`  | `true`  |

**`||` (OU)**

| A | B | A \|\| B (A ou B) |
|---|---|----------|
| `false` | `false` | `false` |
| `false` | `true`  | `true`  |
| `true`  | `false` | `true`  |
| `true`  | `true`  | `true`  |

**`!` (NEGAÇÃO)**

| A | !A (nega A) |
|---|----|
| `false` | `true`  |
| `true`  | `false` |

### Exemplo integrado (JavaScript)
```js
// Entrada
const idade = 19;
const nota = 7.2;

// Processamento
const aprovado = (idade >= 18) && (nota >= 6.0);

// Saída
console.log(aprovado); // true
```

### Fechamento
Nesta aula, vimos como:
1. declarar e usar variáveis;
2. escolher tipos adequados de dados;
3. aplicar operadores para criar expressões em algoritmos.

Esses conceitos são base para estruturas de decisão (`if`), repetição (`for`, `while`) e funções em JavaScript.

### Saiba mais
- Documentacao JavaScript (MDN): https://developer.mozilla.org/pt-BR/docs/Web/JavaScript
- Especificacao ECMAScript (ECMA-262): https://tc39.es/ecma262/
