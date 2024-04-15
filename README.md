# 📝 Trabalho Prático: Internet Banking

Neste trabalho prático, você implementará algumas novas funcionalidade do sistema de InternetBanking adotado na sala de aula.
Para facilitar, o projeto já contém os arquivos `java` implementados para as listas `E02-Classes-Metodos` e `E03-Vetores-Modificadores`.

Utilize essas classes como ponto de partida para a implementação das novas funcionalidades.

## Requisitos

### R1: Visibilidade da classe `Cliente`

Implemente os mecanismos de visibilidade para proteger os atributos da classe cliente. Você deverá adotar os seguintes critérios:

- `nome`: getter & setter
- `cpf`: getter
- `endereco`: getter & setter
- `idade`: getter & setter
- `sexo`: getter & setter

Implemente um construtor que receba todos os atributos.

### R2: Validação de CPF

No momento, nosso sistema não realiza a validação do número de CPF.
Implemente um método dentro da classe `Cliente` que realiza essa validação.
Esse método deverá receber uma `String` com o CPF como parâmetro e retornar um valor `boolean` indicando se o CPF é ou não válido.
O  código abaixo realiza a checagem de um CPF diretamente no `Main` do programa, você deverá adaptá-lo.

```java
public class Main {
    public static void main(String[] args) {
        String cpf = "123.456.789-09";
        boolean cpfValido = true;
        
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11)
            cpfValido = false;

        // Verifica se todos os dígitos são iguais
        boolean allDigitsEqual = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual)
            cpfValido = false;

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9)
            digit1 = 0;

        // Verifica o primeiro dígito verificador
        if ((cpf.charAt(9) - '0') != digit1)
            cpfValido = false;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9)
            digit2 = 0;

        // Verifica o segundo dígito verificador
        if ((cpf.charAt(10) - '0') != digit2)
            cpfValido = false;

        if (cpfValido)
            System.out.println("CPF Válido");
        else
            System.out.println("CPF Inválido");
    }
}
```

Além disso, implemente outro método dentro da classe `Cliente` que seja responsável por criar os Clientes no sistema.
Este método deverá criar um cliente **apenas se o CPF for válido**.
Caso o CPF esteja incorreto, o método deverá retornar `null`.
Veja um exemplo de como esse método deve ser chamado.

```java
    Cliente ana = Cliente.criarCliente("Ana", "123.456.789-00", "Av. Antonio Carlos, 6627", 25, 'f');
    
    if(ana == null) {
        System.out.println("Cliente não foi criado");
    } else {
            System.out.println("Cliente criado com sucesso!");
    }
```

Observações:
- Lembre-se do conceito de métodos estáticos para implementação deste método.
- Um cliente deverá ser criado **apenas** por meio deste método!

### R3: Redimensionamento de Operações

A essa altura você deve ter observado que a classe `Conta` tem capacidade de armazenar apenas 10 operações.
Implemente um método privado de redimensionamento que dobre o tamanho do vetor de operações toda vez que for chamado.
Esse método deverá ser **privado e executado automaticamente** toda vez que o vetor chegar ao seu limite.

## Entrega

Você deverá enviar o projeto com a sua implementação por meio de um push no repositório criado para você.
**Não serão aceitas outras formas de entrega.**

Você deverá enviar o código-fonte da página HTML juntamente com qualquer recurso (imagens, vídeos, etc.) que seja necessário para visualizar a página de maneira completa. O envio será por meio de pull requests junto ao repositório criado para você.

## Avaliação

Sua atividade será avaliada com base nos seguintes critérios:

- Corretude: A implementação atende aos critérios da atividade?
- Estrutura: A implementação utiliza de forma adequada os conceitos abordados?
- Estilo: A implementação é legível, organizada, e segue as convenções recomendadas para a linguagem?

