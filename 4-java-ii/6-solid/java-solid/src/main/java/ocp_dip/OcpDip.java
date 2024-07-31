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
        final Caixa caixa = new Caixa();
        final Venda vendaFaturada = caixa.faturar(venda, new TransportadoraCorreios(), new TabelaNormal());

        System.out.println("O desconto da venda é: " + vendaFaturada.getDesconto());
        System.out.println("O frete da venda é: " + vendaFaturada.getFrete());
    }
}
