package ocp_dip;

import java.util.List;

public final class Caixa {

    private final List<AcoesAposFaturamento> acoesAposFaturamentoList;


    // TODO - aplicar inversao de dependencias
    // Lista de acoes apos faturar Venda
    public Caixa(List<AcoesAposFaturamento> acoesAposFaturamentoList){
        this.acoesAposFaturamentoList = acoesAposFaturamentoList;
    }

    public Venda faturar(Venda venda, Transportadora transportadora, TabelaDescontos tabelaDescontos){

        // verifica o calculo do frete
        venda.setFrete(transportadora.calcularFrete(venda));

        // verifica o calculo do desconto
        venda.setDesconto(tabelaDescontos.calcularDesconto(venda));

        System.out.println("Venda faturada!");

        // TODO implementar interface Lista acoes
        this.acoesAposFaturamentoList.forEach( acao -> acao.executar(venda));

        return venda;
    }
}
