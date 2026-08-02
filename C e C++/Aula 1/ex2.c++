#include <iostream>
*.cpp linguist-language=C++
*.h linguist-language=C++

int main() {
    // Entrada
    int idade = 19;
    float nota = 7.2;
    
    // Processamento
    bool aprovado = (idade >= 18) && (nota >= 6.0);
    
    // Saída
    if (aprovado) {
        std::cout << "Resultado: Aprovado (true)\n";
    } else {
        std::cout << "Resultado: Reprovado (false)\n";
    }
    
    return 0;
}
