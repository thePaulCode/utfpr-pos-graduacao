package br.edu.utfpr.atividade_jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
@NamedQuery(
        name = "Funcionario.byQtdeDependentes",
        query = "from Funcionario f where f.qtdeDependentes = ?1"
)
@NamedNativeQuery(
        name = "Funcionario.byNomeFuncionario",
        query = "select * from funcionario f where f.nome_funcionario like ?1",
        resultClass = Funcionario.class
)
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_funcionario", nullable = false)
    private Integer codFuncionario;

    @ManyToOne
    @JoinColumn(name = "cod_depto", nullable = false)
    private Departamento departamento;

    @Column(name = "nome_funcionario", length = 50)
    private String nomeFuncionario;
    @Column(name = "qtde_dependentes")
    private int qtdeDependentes;
    @Column(name = "salario")
    private Float salario;
    @Column(name = "cargo", length = 50)
    private String cargo;

    public Funcionario() {
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public int getQtdeDependentes() {
        return qtdeDependentes;
    }

    public void setQtdeDependentes(int qtdeDependentes) {
        this.qtdeDependentes = qtdeDependentes;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codFuncionario=" + codFuncionario +
                ", cargo='" + cargo + '\'' +
                ", codDepto=" + getDepartamento().getCodDepto() +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", qtdeDependentes=" + qtdeDependentes +
                ", salario=" + salario +
                '}';
    }
}
