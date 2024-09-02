package ocp_dip.ocptest02;

public enum TipoClientes {
    PF {
        @Override
        public double valorDesconto(double valorVenda) {
            return valorVenda * 0.1;
        }
    },
    PJ {
        @Override
        public double valorDesconto(double valorVenda) {
            return valorVenda * 0.05;
        }
    };
    public abstract double valorDesconto(double valorVenda);

}
