package srp;

public class CalculadoraBonificacao {

    public double calcularBonificacao(Colaborador colaborador){

        double salarioBase = colaborador.salario();

        return colaborador.cargo().calcularBonificacao(salarioBase);
    }
}
