package lsp;

public class ManipuladorSaldoPremium implements ManipuladorSaldo {
    private double saldo;

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        this.saldo -= valor;
    }

    public void render(){
        this.saldo += this.saldo * 0.1;
    }

    public double getSaldo(){
        return saldo;
    }
}
