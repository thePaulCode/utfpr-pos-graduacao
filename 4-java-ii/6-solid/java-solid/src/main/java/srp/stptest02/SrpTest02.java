package srp.stptest02;


import java.util.List;

public class SrpTest02 {
    public static void main(String[] args) {
        SrpTest02 srpTest02 = new SrpTest02();
        srpTest02.execute();
    }

    private void execute() {
        List<Funcionario> funcionarios = List.of(
                new Funcionario("Paul", Funcao.ANALISTA, 8500.0),
                new Funcionario("Stll", Funcao.GERENTE, 6500.0),
                new Funcionario("Anna", Funcao.RH, 5500.0),
                new Funcionario("Albert", Funcao.ESTAGIARIO, 900.0),
                new Funcionario("Josefa", Funcao.ANALISTA, 6390.0)
        );

        final CalcBonificacao calcBonificacao = new CalcBonificacao();

        funcionarios.forEach(f -> System.out.printf("Salario funcionario %s - R$ %s",
                f.nome(), calcBonificacao.calcularBonificacao(f)).println()
        );
    }
}
