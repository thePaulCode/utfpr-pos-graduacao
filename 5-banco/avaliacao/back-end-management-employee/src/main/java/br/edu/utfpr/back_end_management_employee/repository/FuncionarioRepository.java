package br.edu.utfpr.back_end_management_employee.repository;

import br.edu.utfpr.back_end_management_employee.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Transactional(readOnly = false)
    @Modifying
    @Query(value = "DELETE FROM funcionario f WHERE f.cod_funcionario = ?1", nativeQuery = true)
    void deleteFuncionarioByCodFuncionario(Integer codFuncionario);

    //@Query
    int countAllByNomeIsNotNull();
}
