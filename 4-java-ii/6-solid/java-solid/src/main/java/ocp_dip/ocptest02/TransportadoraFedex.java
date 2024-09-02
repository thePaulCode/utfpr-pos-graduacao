package ocp_dip.ocptest02;

public class TransportadoraFedex implements Transportadora {

    @Override
    public double calcularFrete(Venda venda){
        return (venda.getEstado().equalsIgnoreCase("SP"))? 35.0 : 60.0;
    }
}
