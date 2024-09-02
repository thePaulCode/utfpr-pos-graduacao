package srp.stptest02;

public class CalcBonificacao {

    public double calcularBonificacao(Funcionario funcionario){
        double salarioBase = funcionario.salarioBase();
        return funcionario.funcao().calcularBonificacao(salarioBase);
    }
}
