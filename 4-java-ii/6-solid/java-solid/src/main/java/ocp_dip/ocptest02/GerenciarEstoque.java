package ocp_dip.ocptest02;

public class GerenciarEstoque implements AcoesAposFat{

    @Override
    public void executar(Venda venda) {
        System.out.println("Gerenciando estoque...");
    }
}
