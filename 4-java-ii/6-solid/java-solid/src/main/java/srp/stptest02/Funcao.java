package srp.stptest02;

public enum Funcao {
    ANALISTA {
        @Override
        public double calcularBonificacao(double salarioBase) {
            return salarioBase * 0.1;
        }
    },
    RH {
        @Override
        public double calcularBonificacao(double salarioBase) {
            return salarioBase * 0.15;
        }
    },
    GERENTE {
        @Override
        public double calcularBonificacao(double salarioBase) {
            return salarioBase * 0.2;
        }
    },
    ESTAGIARIO {
        @Override
        public double calcularBonificacao(double salarioBase) {
            return 0;
        }
    };

    public abstract double calcularBonificacao(double salarioBase);
}
