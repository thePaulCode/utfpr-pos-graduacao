package ocp_dip.ocptest02;

import java.util.List;

public class Caixa {

   private final List<AcoesAposFat> acoesAposFatList;

    public Caixa(List<AcoesAposFat> acoesAposFatList) {
        this.acoesAposFatList = acoesAposFatList;
    }

    public Venda faturar(Venda venda, Transportadora transportadora, TabelaDesconto tabelaDesconto ) {

        venda.setFrete(transportadora.calcularFrete(venda));

        venda.setDesconto(tabelaDesconto.calcularDesconto(venda));

        System.out.println("Venda faturada.");

        this.acoesAposFatList
                .forEach(acoesAposFat -> acoesAposFat.executar(venda));

        return  venda;
    }
}
