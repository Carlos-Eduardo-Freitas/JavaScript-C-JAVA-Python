var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');
let raio = parseFloat(lines[0]);
const π = 3.14159;
let area = π * raio * raio;
console.log("A=" + area.toFixed(4));
