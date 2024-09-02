package ocp_dip.ocptest02;

public class TabelaPromocional implements TabelaDesconto{
    @Override
    public double calcularDesconto(Venda venda) {
        final var descontoNormal =venda.getTipoCliente().valorDesconto(venda.valorTotal());

        return descontoNormal * 1.02;
    }
}
