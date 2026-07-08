var input = require('fs').readFileSync('/dev/stdin', 'utf8');
// O .split pode variar dependendo do ambiente (espaço ou quebra de linha)
// .split(/\s+/) lida com ambos
var lines = input.split('\n');

function Somar(num1, num2) {
    return num1 + num2;
}

// Corrigido: 'lines' em vez de 'line' e colchetes [] em vez de {}
let A = parseInt(lines[0]);
let B = parseInt(lines[1]);

let X = Somar(A, B);

console.log('X = ' + X);
