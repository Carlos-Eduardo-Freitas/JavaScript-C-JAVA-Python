# Mini-projeto: Validador de Situação Acadêmica

## Objetivo
Aplicar variáveis, tipos e operadores construindo um pequeno script que avalia a situação de um aluno.

## Requisitos
Usando apenas o que foi visto na aula (variáveis, tipos, operadores relacionais e lógicos):

1. Declare variáveis para: `nome` (string), `frequencia` (number, 0–100), `mediaFinal` (number, 0–10) e `pendenciaFinanceira` (boolean).
2. Calcule se o aluno está **aprovado**: frequência >= 75 **e** média >= 6.0.
3. Calcule se o aluno está **apto a colar grau**: aprovado **e** sem pendência financeira.
4. Exiba no console uma mensagem final, por exemplo:
   ```
   Ana — Aprovada: true | Apta a colar grau: false
   ```

## Extensão (opcional)
- Transforme os valores fixos em `prompt()` (se rodar no navegador) para tornar o script interativo.
- Trate o caso em que `mediaFinal` está fora do intervalo 0–10 (valor inválido).

