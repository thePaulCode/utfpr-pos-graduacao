package ocp_dip;

public class Correio implements AcoesAposFaturamento{
    @Override
    public void executar(Venda venda) {
        System.out.println("Notificando fornecedores...");

    }
}
