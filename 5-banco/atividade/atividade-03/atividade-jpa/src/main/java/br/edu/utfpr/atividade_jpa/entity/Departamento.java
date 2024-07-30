package br.edu.utfpr.atividade_jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_depto", nullable = false)
    private Integer codDepto;

//    @OneToMany(mappedBy = "departamento")
//    private List<Funcionario> funcionarios;
    
    @Column(name = "nome_depto", length = 50)
    private String nomeDepto;

    // Constructor
    public Departamento(){}

    // Getters and Setters
    public void setCodDepto(Integer codDepto){
        this.codDepto = codDepto;
    }

    public Integer getCodDepto(){
        return codDepto;
    }

    public void setNomeDepto(String nomeDepto){
        this.nomeDepto = nomeDepto;
    }

    public String getNomeDepto(){
        return nomeDepto;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "codDepto=" + codDepto +
                ", nomeDepto='" + nomeDepto + '\'' +
                '}';
    }
}
