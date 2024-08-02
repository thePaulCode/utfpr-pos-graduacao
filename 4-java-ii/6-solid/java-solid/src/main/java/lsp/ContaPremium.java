package lsp;

public class ContaPremium extends Conta{
    @Override
    public void render() {
        this.saldo += this.saldo * 0.1;
    }
}
