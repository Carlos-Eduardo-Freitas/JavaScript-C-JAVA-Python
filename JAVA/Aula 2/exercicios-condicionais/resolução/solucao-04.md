# Solução — Exercício 4: Sistema de Login

```java
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String usuarioCorreto = "admin";
        String senhaCorreta = "1234";

        System.out.print("Usuário: ");
        String usuarioDigitado = entrada.nextLine();

        System.out.print("Senha: ");
        String senhaDigitada = entrada.nextLine();

        if (usuarioDigitado.equals(usuarioCorreto) && senhaDigitada.equals(senhaCorreta)) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Usuário ou senha incorretos.");
        }
    }
}
```

### Explicação

- Usamos `.equals()` para comparar o conteúdo das `String`, nunca `==` (que compara referência de memória, não o texto em si).
- O `&&` exige que **as duas** comparações sejam verdadeiras ao mesmo tempo — se o usuário estiver certo mas a senha errada (ou vice-versa), o login falha.
- Repare que usamos `nextLine()` para ambos os campos, já que estamos lendo texto do início ao fim — não há mistura com `nextInt()` aqui, então não precisamos nos preocupar com o problema do buffer que vimos na aula anterior.

**Teste com `admin` / `1234`:** as duas comparações são verdadeiras → `"Login realizado com sucesso!"`. Bate com o exemplo da questão!
