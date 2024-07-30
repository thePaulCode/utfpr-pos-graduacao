package srp;

public enum Cargo {
   ANALISTA {
       @Override
       public double calcularBonificacao(double salarioBase) {
           return salarioBase * 0.01;
       }
   },
    DESENVOLVEDOR {
        @Override
        public double calcularBonificacao(double salarioBase) {
            return salarioBase * 0.05;
        }
    },
    GERENTE {
        @Override
        public double calcularBonificacao(double salarioBase) {
            return salarioBase * 0.1;
        }
    },
    ESTAGIARIO;

   public double calcularBonificacao(double salarioBase){
       return 0;
   }
}
