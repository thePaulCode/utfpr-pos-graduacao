package isp;


import java.util.List;

public class Isp {
    public static void main(String[] args) {
        final Isp isp = new Isp();
        isp.execute();
    }

    private void execute() {
        final var analista = new Analista("Paul", 117, 6500.0);
        final var vendedor = new Vendedor("Stll", 711, 8500.0);

        final List<Colaborador> colaboradores = List.of(analista, vendedor);

        colaboradores.forEach(colaborador -> System.out.printf("A comissao do funcionario %s é de %s ", colaborador.getNome(), colaborador.getComissao()).println());
    }
}
