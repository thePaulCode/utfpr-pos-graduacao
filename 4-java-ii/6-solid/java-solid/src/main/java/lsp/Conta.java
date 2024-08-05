package lsp;

public class Conta {

    /**
     * inteface ManipuladorSaldo
     *
     * composicao criar ponto de extensao
     * sem alterar o comportamento original
     * remocao das herancas, composicao de comportamentos
     * */
    protected final ManipuladorSaldo manipuladorSaldo;

    public Conta(ManipuladorSaldo manipuladorSaldo) {
        this.manipuladorSaldo = manipuladorSaldo;
    }

    public void depositar(double valor) {
        this.manipuladorSaldo.depositar(valor);
    }

    public void sacar(double valor) {
        this.manipuladorSaldo.sacar(valor);
    }

    public void render() {
        this.manipuladorSaldo.render();
    }

}
