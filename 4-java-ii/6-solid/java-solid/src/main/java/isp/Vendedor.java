package isp;

public class Vendedor extends Colaborador {


    public Vendedor(String nome, int documento, double salario) {
        super(nome, documento, salario);
    }

    @Override
    public double getComissao() {
        return 0.1;
    }
}
