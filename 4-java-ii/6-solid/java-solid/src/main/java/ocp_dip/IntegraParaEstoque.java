package ocp_dip;

public class IntegraParaEstoque implements AcoesAposFaturamento{

    @Override
    public void executar(Venda venda) {
        System.out.println("Integrar para estoque");
    }
}
