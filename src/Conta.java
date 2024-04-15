import java.util.regex.Pattern;

public class Cliente {
    String nome;
    String cpf;
    String endereco;
    int idade;
    char sexo;

    // Método estático para validar CPF
    private static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11)
            return false;

        // Verifica se todos os dígitos são iguais
        boolean allDigitsEqual = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual)
            return false;

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
            return false;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9)
            digit2 = 0;

        // Verifica o segundo dígito verificador
        return (cpf.charAt(10) - '0') == digit2;
    }

    // Método estático para criar cliente se o CPF for válido
    public static Cliente criarCliente(String nome, String cpf, String endereco, int idade, char sexo) {
        if (validarCPF(cpf)) {
            Cliente cliente = new Cliente();
            cliente.nome = nome;
            cliente.cpf = cpf;
            cliente.endereco = endereco;
            cliente.idade = idade;
            cliente.sexo = sexo;
            return cliente;
        } else {
            return null;
        }
    }
}
