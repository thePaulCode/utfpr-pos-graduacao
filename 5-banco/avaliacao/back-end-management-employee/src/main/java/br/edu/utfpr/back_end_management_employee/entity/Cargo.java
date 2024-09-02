package br.edu.utfpr.back_end_management_employee.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cargo")
@Data
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cargo", nullable = false)
    private Integer codCargo;

    @Column(name = "desc_cargo", length = 50)
    private String descricaoCargo;

    @OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER)
    private List<Funcionario> funcionario;

    public Cargo() {
    }

    public Cargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "codCargo=" + codCargo +
                ", descricaoCargo='" + descricaoCargo + '\'' +
                ", funcionario=" + funcionario +
                '}';
    }
}
