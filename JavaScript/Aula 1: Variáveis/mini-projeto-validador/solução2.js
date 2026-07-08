// ==========================================
// 1. CAPTURA DINÂMICA DE DADOS (INTERATIVO)
// ==========================================
const nome = prompt("Digite o nome do discente:");

// O prompt sempre retorna texto. Usamos Number() para cast de tipo (coerção explícita)
const frequencia = Number(prompt("Digite a frequência (0 a 100):"));
const mediaFinal = Number(prompt("Digite a média final (0 a 10):"));

// Avaliamos a resposta textual para transformá-la em um booleano puro
const pendenciaFinanceira = prompt("Possui pendência financeira? (digite 'sim' ou 'nao')") === "sim";

// ==========================================
// 2. VALIDAÇÃO CIENTÍFICA DOS INTERVALOS
// ==========================================
// Garante que os dados digitados fazem sentido matemático antes da análise
const dadosValidos = (mediaFinal >= 0 && mediaFinal <= 10) && (frequencia >= 0 && frequencia <= 100);

// ==========================================
// 3. PROCESSAMENTO CONDICIONADO
// ==========================================
// Se 'dadosValidos' for false, toda a cadeia lógica subsequente colapsará para false.
const aprovado = dadosValidos && (frequencia >= 75) && (mediaFinal >= 6.0);
const aptoColarGrau = aprovado && !pendenciaFinanceira;

// ==========================================
// 4. RELATÓRIO FINAL
// ==========================================
console.log(`[Integridade dos Dados: ${dadosValidos}]`);
console.log(`${nome} — Aprovado(a): ${aprovado} | Apto(a) a colar grau: ${aptoColarGrau}`);
