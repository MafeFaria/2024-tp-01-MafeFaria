
public class Conta {

    private int numero;
    private Cliente dono;
    private double saldo;
    private double limite;
    private Operacao[] operacoes;
    private int proximaOperacao;
    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new Operacao[10]; // Inicialmente, o array tem tamanho 10
        this.proximaOperacao = 0;

        Conta.totalContas++;
    }

    // Outros métodos da classe...

    private void _redimensionarOperacoes() {
        int novoTamanho = this.operacoes.length * 2; // Dobra o tamanho do array
        Operacao[] novoArray = new Operacao[novoTamanho];

        // Copia as operações antigas para o novo array
        for (int i = 0; i < this.operacoes.length; i++) {
            novoArray[i] = this.operacoes[i];
        }

        this.operacoes = novoArray; // Atualiza a referência para o novo array
    }

    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            if (this.proximaOperacao == this.operacoes.length) {
                this._redimensionarOperacoes(); // Redimensiona o array se estiver cheio
            }

            this.operacoes[this.proximaOperacao] = new Operacao('s', valor);
            this.proximaOperacao++;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        if (this.proximaOperacao == this.operacoes.length) {
            this._redimensionarOperacoes(); // Redimensiona o array se estiver cheio
        }

        this.operacoes[this.proximaOperacao] = new Operacao('d', valor);
        this.proximaOperacao++;
    }

}


