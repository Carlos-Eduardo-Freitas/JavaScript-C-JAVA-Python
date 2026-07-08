# Exercícios — Variáveis, Tipos e Operadores

## Nível 1 — Fixação

**1.1** Declare três variáveis: `nome` (string), `idade` (number) e `estudante` (boolean). Imprima cada uma com `console.log`.

**1.2** Identifique qual das declarações abaixo está incorreta e explique o motivo:
```js
let 1nome = "Carlos";
const idade = 20;
let for = "loop";
```

**1.3** Use `typeof` para descobrir o tipo de cada valor:
```js
let a = 10;
let b = "10";
let c = true;
let d;
let e = null;
```

## Nível 2 — Operadores

**2.1** Dadas as variáveis `notaProva = 8.0` e `notaTrabalho = 6.5`, calcule a média e verifique se o aluno está aprovado (média >= 7).

**2.2** Escreva uma expressão que retorne `true` somente se a idade for maior ou igual a 18 **e** menor que 65.

**2.3** Complete a tabela-verdade manualmente (sem rodar código) para:
```js
(5 > 3) && (2 === 2)
(5 > 3) || (2 !== 2)
!(5 > 10)
```

## Nível 3 — Aplicação

**3.1** Crie um pequeno script que receba (via variáveis fixas no código) `idade` e `possuiCNH` (boolean) e informe, usando `&&`, se a pessoa pode dirigir (idade >= 18 e possuiCNH === true).

**3.2** Refatore o trecho abaixo trocando os nomes genéricos por nomes claros e usando `const`/`let` corretamente:
```js
var x = 10;
var y = "João";
var z = x >= 18;
```

**3.3 (desafio)** Escreva uma expressão lógica única que verifique se um aluno está apto a colar grau, considerando:
- frequência mínima de 75%
- média final >= 6.0
- não possuir pendências financeiras (`pendenciaFinanceira === false`)

---

> 💡 Dica: tente resolver primeiro sem rodar o código, apenas "no papel", para treinar a leitura de expressões booleanas.
