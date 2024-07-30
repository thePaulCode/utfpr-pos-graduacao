package br.edu.utfpr.atividade_jpa.repository;

import br.edu.utfpr.atividade_jpa.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {


    //1
    Optional<Funcionario> findByNomeFuncionarioAndQtdeDependentes(String nomeFuncionario, int qtdeDependentes);

    //2
    @Query("select f from Funcionario f join Departamento d on d.codDepto = f.departamento.codDepto and d.codDepto= ?1")
    List<Funcionario> findByFuncionarioCodDepto(Integer codDepto);

    //4
    Optional<Funcionario> findTopByOrderBySalarioDesc();

    //5
    List<Funcionario> findFirst3ByOrderBySalarioDesc();

    //6
    @Query("select f from Funcionario f where f.qtdeDependentes = 0")
    List<Funcionario> findFuncionarioSemDependentes();

    //7
    @Query("select  f from Funcionario f where f.salario > ?1")
    List<Funcionario> findBySalarioAfter(Float salario);

    //8
    @Query(value = "select  * from funcionario f where f.salario > ?1", nativeQuery = true)
    List<Funcionario> findBySalario(Float salario);

    //9
    @Query(name = "Funcionario.byQtdeDependentes")
    List<Funcionario> findFuncionarioByQtdeDependentes(Integer numeroDependentes);

    //10
    @Query(name = "Funcionario.byNomeFuncionario")
    List<Funcionario> findFuncionarioByNomeFuncionario(String parteNome);

    //5-1
    @Procedure("proc_aumentar_salario")
    void riseSalary(Integer value);

    //5-2
    @Query("SELECT f " +
            "FROM Funcionario f " +
            "JOIN Departamento d ON d.codDepto = f.departamento.codDepto " +
            "WHERE f.qtdeDependentes = 0 AND d.nomeDepto LIKE :departamento")
    List<Funcionario> findFuncionarioWithoutDependentes(@Param("departamento") String departamento);

    //5-3
    @Transactional(readOnly = false)
    @Modifying
    @Query(value ="UPDATE funcionario\n" +
            "set cod_depto = (\n" +
            "\tSELECT e.cod_depto \n" +
            "\tFROM departamento e\n" +
            "\tWHERE e.nome_depto LIKE ?2\n" +
            ")\n" +
            "WHERE cod_depto IN (\n" +
            "\tSELECT d.cod_depto \n" +
            "\tFROM departamento d\n" +
            "\tWHERE d.nome_depto LIKE ?1\n" +
            ");" , nativeQuery = true)
    void updateFuncionarioFromDeptoToAnother(String deptoOrigem, String deptoDestino);


    //5-4
    @Transactional(readOnly = false)
    @Modifying
    @Query(value = "DELETE from funcionario f\n" +
            "WHERE cod_depto in (SELECT d.cod_depto \n" +
            "\tFROM departamento d \n" +
            "\tWHERE d.nome_depto LIKE ?1)", nativeQuery = true)
    void deleteFuncionarioByDepartamento(String departamento);



}
