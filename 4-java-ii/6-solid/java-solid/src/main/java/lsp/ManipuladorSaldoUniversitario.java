package lsp;

public class ManipuladorSaldoUniversitario implements ManipuladorSaldo {
    private double saldo;

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        this.saldo -= valor;
    }

    public void render(){
        this.saldo += this.saldo * 0;
    }

    public double getSaldo(){
        return saldo;
    }
}
