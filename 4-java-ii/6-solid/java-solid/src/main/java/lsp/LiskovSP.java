package lsp;

import java.util.List;

public class LiskovSP {
    public static void main(String[] args) {
        final LiskovSP lsp = new LiskovSP();
        lsp.execute();
    }

    private void execute() {
        final ManipuladorSaldo comum = new ManipuladorSaldoComum();
        final ManipuladorSaldo premium = new ManipuladorSaldoPremium();
        final ManipuladorSaldo universitario = new ManipuladorSaldoUniversitario();

        final Conta conta1 = new Conta(comum);
        final Conta conta2 = new Conta(premium);
        final Conta conta3 = new Conta(universitario);

        conta1.depositar(100);
        conta2.depositar(100);
        conta3.depositar(100);

        final List<Conta> contas = List.of(conta1, conta2, conta3);
                contas.stream()
                        .peek(Conta::render)
                        .forEach(conta -> System.out.println("Saldo conta " + conta.manipuladorSaldo.getSaldo()));


    }
}

