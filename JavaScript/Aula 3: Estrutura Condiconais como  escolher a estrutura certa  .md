### 1. Como escolher a estrutura certa
Use esta regra pratica:

1. Use `if` quando so existe acao para o caso verdadeiro.
2. Use `if...else` quando existem exatamente dois caminhos (verdadeiro ou falso).
3. Use `if...else if...else` quando ha tres ou mais condicoes diferentes (faixas, categorias, validacoes em sequencia).
4. Use `switch...case` quando a decisao depende do valor exato de uma unica variavel com varias opcoes discretas.

### 2. `if` (condicional simples)
Quando usar:
- para validar uma condicao unica;
- quando nao e necessario tratar explicitamente o caso falso.

Sintaxe:
```js
if (condicao) {
  console.log("Condicao verdadeira");
}
```

Exemplo:
```js
let temperatura = 32;

if (temperatura > 30) {
  console.log("Dia quente");
}

console.log("Verificacao concluida");
```

### 3. `if...else` (dois caminhos)
Quando usar:
- quando sempre deve acontecer uma entre duas acoes;
- para decisoes binarias (sim/nao, aprovado/reprovado, par/impar).

Sintaxe:
```js
if (condicao) {
  console.log("Caminho A");
} else {
  console.log("Caminho B");
}
```

Exemplo:
```js
let nota = 6.5;

if (nota >= 7) {
  console.log("Aprovado");
} else {
  console.log("Reprovado");
}
```

### 4. `if...else if...else` (multiplas condicoes)
Quando usar:
- para classificar por faixas de valor;
- quando as condicoes precisam ser testadas em ordem de prioridade;
- quando so um bloco deve ser executado.

Sintaxe:
```js
if (condicao1) {
  console.log("Bloco 1");
} else if (condicao2) {
  console.log("Bloco 2");
} else {
  console.log("Bloco final");
}
```

Exemplo:
```js
let media = 8.2;

if (media >= 9) {
  console.log("Conceito A");
} else if (media >= 7) {
  console.log("Conceito B");
} else if (media >= 5) {
  console.log("Conceito C");
} else {
  console.log("Conceito D");
}
```

Observacao:
- a ordem importa: da condicao mais restritiva para a mais ampla.

### 5. `switch...case` (comparacao por valor exato)
Quando usar:
- quando uma variavel pode assumir varios valores fixos (dia da semana, opcao de menu, codigo de status);
- quando ha muitos `else if` comparando igualdade na mesma variavel.

Sintaxe:
```js
switch (expressao) {
  case valor1:
    console.log("Bloco 1");
    break;
  case valor2:
    console.log("Bloco 2");
    break;
  default:
    console.log("Sem correspondencia");
}
```

Exemplo:
```js
let dia = 3;

switch (dia) {
  case 1:
    console.log("Domingo");
    break;
  case 2:
    console.log("Segunda-feira");
    break;
  case 3:
    console.log("Terca-feira");
    break;
  case 4:
    console.log("Quarta-feira");
    break;
  case 5:
    console.log("Quinta-feira");
    break;
  case 6:
    console.log("Sexta-feira");
    break;
  case 7:
    console.log("Sabado");
    break;
  default:
    console.log("Dia invalido");
}
```

Pontos de atencao:
- `break` evita executar os proximos casos (fall-through);
- `default` funciona como "senao" do `switch`.

### 6. Comparativo rapido

| Estrutura | Melhor uso | Exemplo de problema |
| --- | --- | --- |
| `if` | acao unica no caso verdadeiro | "Se estoque < 5, avisar reposicao" |
| `if...else` | duas alternativas obrigatorias | "Se idade >= 18, maior; senao, menor" |
| `if...else if...else` | varias condicoes com ordem | "Classificar nota em A, B, C ou D" |
| `switch...case` | varios valores exatos da mesma variavel | "Mapear opcao do menu (1,2,3,4)" |

### 7. Erros comuns
1. Usar varios `if` independentes quando apenas uma opcao deveria executar.
2. Escrever `switch` sem `break` e gerar saidas inesperadas.
3. Colocar condicoes de faixa fora de ordem no `else if`.
4. Usar `switch` para condicoes complexas (como `idade > 18 && renda > 2000`), caso em que `if` e melhor.

### 8. Fechamento
Nesta aula, voce aprendeu a selecionar a estrutura condicional adequada ao tipo de decisao. Escolher bem entre `if`, `if...else`, `else if` e `switch...case` deixa o algoritmo mais legivel, correto e facil de manter.

### Saiba mais
- MDN - if...else: https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Statements/if...else
- MDN - switch: https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Statements/switch
