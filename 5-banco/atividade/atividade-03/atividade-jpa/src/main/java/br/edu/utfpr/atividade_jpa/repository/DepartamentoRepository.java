package br.edu.utfpr.atividade_jpa.repository;

import br.edu.utfpr.atividade_jpa.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    //3
    Departamento findFirstBy();
}
