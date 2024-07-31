package ocp_dip;

public final class Caixa {

    private final Correio correio;
    private final EmissorNf emissorNf;
    private final IntegraParaEstoque integraParaEstoque;

    public Caixa(){
        this.correio = new Correio();
        this.emissorNf = new EmissorNf();
        this.integraParaEstoque = new IntegraParaEstoque();
    }

    public Venda faturar(Venda venda, Transportadora transportadora, TabelaDescontos tabelaDescontos){

        // verifica o calculo do frete
        venda.setFrete(transportadora.calcularFrete(venda));

        // verifica o calculo do desconto
        venda.setDesconto(tabelaDescontos.calcularDesconto(venda));

        System.out.println("Venda faturada!");

        this.emissorNf.emitir(); // emite NF
        this.correio.notificarFornecedor(); // notificacao ao cliente
        this.integraParaEstoque.integrar(); // dar baixa nos itens do estoque

        return venda;
    }
}
