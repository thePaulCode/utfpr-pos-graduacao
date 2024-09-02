package ocp_dip.ocptest02;

import java.util.List;

public class OcpTeste02 {
    public static void main(String[] args) {
        final OcpTeste02 ocpTeste02 = new OcpTeste02();
        ocpTeste02.execute();
    }

    private void execute() {

        final List<Item> itens = List.of(
                new Item("Cpu", 1, 325.0),
                new Item("Cpu", 1, 165.0),
                new Item("Cpu", 2, 189.0),
                new Item("Cpu", 1, 499.0),
                new Item("Cpu", 2, 100.0)
        );

        final Venda venda = new Venda("Prs", TipoClientes.PF, "PR", itens);

        final  List<AcoesAposFat> acoesAposFat = List.of(
            new EmitirNf(), new Correio(), new GerenciarEstoque()
        );

        final Caixa caixa = new Caixa(acoesAposFat);

        final Venda vendaFaturada = caixa.faturar(venda, new TransportadoraCorreios(), new TabelaPromocional());

        System.out.println("Total da venda " + vendaFaturada.valorTotal());
        System.out.println("\nO desconto da venda é: " + vendaFaturada.getDesconto());
        System.out.println("O frete da venda é: " + vendaFaturada.getFrete());
    }
}
