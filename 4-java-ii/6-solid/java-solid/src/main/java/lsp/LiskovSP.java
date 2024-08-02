package lsp;

import java.util.List;

public class LiskovSP {
    public static void main(String[] args) {
        final LiskovSP lsp = new LiskovSP();
        lsp.execute();
    }

    private void execute() {
        final var conta1 = new Conta();

        final var conta2 = new ContaPremium();

        conta1.depositar(100);
        conta2.depositar(100);

        final List<Conta> contas = List.of(conta1, conta2);
                contas.stream()
                        .peek(Conta::render)
                        .forEach(conta -> System.out.println("Saldo conta " + conta.getSaldo()));


    }
}

