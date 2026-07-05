// Entrada e Converção para inteiro
let a = parseInt(prompt('Digite um numero: '));
let b = parseInt(prompt('Digite um numero: '));

// processamento e verificação 
if( a % b == 0 || b % a == 0){
    console.log(`${a} e ${b} são multiplos`);
}else{
 console.log(`${a} e ${b} não são multiplos`);
}

