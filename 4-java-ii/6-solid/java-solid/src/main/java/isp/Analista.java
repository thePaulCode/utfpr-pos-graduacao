package isp;

public class Analista extends Colaborador {


    public Analista(String nome, int documento, double salario) {
        super(nome, documento, salario);
    }
    @Override
    public double getComissao() {
        return 0;
    }
}