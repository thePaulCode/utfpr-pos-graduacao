package ocp_dip.ocptest02;

public class EmitirNf implements AcoesAposFat{

    @Override
    public void executar(Venda venda) {
        System.out.println("Emitindo nota fiscal...");
    }
}
