#include <stdio.h>
*.c linguist-language=C

int main() {
    // Entrada
    int idade = 19;
    float nota = 7.2;
    
    // Processamento (Em C, usamos int no lugar de booleanos puros)
    int aprovado = (idade >= 18) && (nota >= 6.0);
    
    // Saída
    if (aprovado) {
        printf("Resultado: Aprovado (1)\n");
    } else {
        printf("Resultado: Reprovado (0)\n");
    }
    
    return 0;
}
