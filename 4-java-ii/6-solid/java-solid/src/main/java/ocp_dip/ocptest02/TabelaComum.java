package ocp_dip.ocptest02;

public class TabelaComum implements TabelaDesconto{
    @Override
    public double calcularDesconto(Venda venda) {
        return venda.getTipoCliente().valorDesconto(venda.valorTotal());
    }
}
