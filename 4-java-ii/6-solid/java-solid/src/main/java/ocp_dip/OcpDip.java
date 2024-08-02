package ocp_dip;

import java.util.List;

public class OcpDip {
    public static void main(String[] args) {
        final OcpDip ocpDip = new OcpDip();

        ocpDip.execute();
    }

    private void execute() {
        final List<Item> itens = List.of(
            new Item("CPU Ryzen 5", 1, 325),
            new Item("MB Asus", 1, 165),
            new Item("Mem DDR4 16GB", 2, 189),
            new Item("VGA Geforce", 1, 499),
            new Item("SSD Samsung 500GB", 2, 100)
        );

        final Venda venda = new Venda("Paul", TipoCliente.PF, "Parana", itens);
        final List<AcoesAposFaturamento> acoesAposFaturamentoList = List.of(
            new EmissorNf(), new Correio(), new IntegraParaEstoque()

        );

        final Caixa caixa = new Caixa(acoesAposFaturamentoList);

        final Venda vendaFaturada = caixa.faturar(venda, new TransportadoraCorreios(), new TabelaNormal());

        System.out.println("O desconto da venda é: " + venda.getDesconto());
        System.out.println("O frete da venda é: " + venda.getFrete());
    }
}
