package srp;

import java.util.List;

public class Srp {
    public static void main(String[] args) {
        final Srp srp = new Srp();
        srp.executar();
    }

    private  void executar(){
        final List<Colaborador> colaboradores = List.of(
                new Colaborador("Paul", Cargo.DESENVOLVEDOR, 500),
                new Colaborador("Stll", Cargo.ANALISTA, 1000),
                new Colaborador("Anna", Cargo.GERENTE, 2000),
                new Colaborador("Adalberto", Cargo.CEO, 3000)
        );

        final CalculadoraBonificacao calculadora = new CalculadoraBonificacao();

        colaboradores.forEach(colaborador -> {
            System.out.printf("O colaborador %s tem bonificacao de %f%n",
                    colaborador.nome(), calculadora.calculaBonificacao(colaborador)).println();
        });
    }


}
