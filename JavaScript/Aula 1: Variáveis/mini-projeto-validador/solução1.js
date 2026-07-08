// ==========================================
// 1. DECLARAÇÃO DE VARIÁVEIS (AMOSTRAS)
// ==========================================
const nome = "Ana";
const frequencia = 80;             // Escala de 0 a 100
const mediaFinal = 7.5;            // Escala de 0.0 a 10.0
const pendenciaFinanceira = false;  // true se houver débito, false se estiver quitado

// ==========================================
// 2. PROCESSAMENTO E FILTROS LÓGICOS
// ==========================================

// O aluno precisa passar em AMBOS os critérios académicos (Operador E)
const aprovado = (frequencia >= 75) && (mediaFinal >= 6.0);

// Para colar grau, precisa estar aprovado E NÃO (!) ter pendência financeira
const aptoColarGrau = aprovado && !pendenciaFinanceira;

// ==========================================
// 3. PUBLICAÇÃO DOS RESULTADOS (SAÍDA)
// ==========================================
console.log(`${nome} — Aprovada: ${aprovado} | Apta a colar grau: ${aptoColarGrau}`);
