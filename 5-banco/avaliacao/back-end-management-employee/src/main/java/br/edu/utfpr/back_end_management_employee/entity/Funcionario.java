package br.edu.utfpr.back_end_management_employee.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "funcionario")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_funcionario")
    private Integer codFuncionario;

    @Column(name = "nome", length = 70)
    private String nome;

    @Column(name = "sexo", length = 10)
    private String sexo;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "cod_cargo", nullable = false)
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(String nome, String sexo, String telefone, Cargo cargo) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codFuncionario=" + codFuncionario +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cargo=" + cargo.getDescricaoCargo() +
                '}';
    }
}
