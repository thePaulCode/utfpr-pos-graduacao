package ocp_dip.ocptest02;

public class TransportadoraCorreios implements Transportadora {

    @Override
    public double calcularFrete(Venda venda){
        return (venda.getEstado().equalsIgnoreCase("PR"))? 25.0 : 50.0;
    }
}
