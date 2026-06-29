var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

const A = parseInt(lines[0]);
const B = parseInt(lines[1]);

// Realiza a multiplicação entre os dois valores
let PROD = A * B;

// Exibe o resultado conforme a formatação exigida pelo Beecrowd
console.log("PROD = "+ PROD); 
### Fluxograma da Solução
```mermaid
flowchart TD
    A([Início]) --> B[/Ler A/]
    B --> C[/Ler B/]
    C --> D[PROD = A * B]
    D --> E[/Exibir PROD/]
    E --> F([Fim])
``` 
