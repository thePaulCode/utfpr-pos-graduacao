package ocp_dip.ocptest02;

public class Correio implements AcoesAposFat{

    @Override
    public void executar(Venda venda) {
        System.out.println("Notificando o fornecedor...");
    }
}
