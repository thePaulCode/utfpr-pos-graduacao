package isp;

public abstract class Colaborador {
    private String nome;
    private int documento;
    private double salario;


    public Colaborador(String nome, int documento, double salario) {
        this.nome = nome;
        this.documento = documento;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract double getComissao();

}