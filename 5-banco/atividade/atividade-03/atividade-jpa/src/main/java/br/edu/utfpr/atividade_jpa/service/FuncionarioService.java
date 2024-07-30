package br.edu.utfpr.atividade_jpa.service;

import br.edu.utfpr.atividade_jpa.dto.FuncionarioDTO;
import br.edu.utfpr.atividade_jpa.entity.Funcionario;
import br.edu.utfpr.atividade_jpa.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public Optional<Funcionario> findFuncionarioDependentes(String nome, int dependentes) {
        return funcionarioRepository.findByNomeFuncionarioAndQtdeDependentes(nome, dependentes);
    }

    public List<Funcionario> findFuncionarioDepto(Integer depto){
        return funcionarioRepository.findByFuncionarioCodDepto(depto);
    }

    public Optional<Funcionario> findTopFuncionarioByMaiorSalario() {

        return funcionarioRepository.findTopByOrderBySalarioDesc();

    }

    public List<Funcionario> findFirst3FuncionarioByMaiorSalario() {

        return funcionarioRepository.findFirst3ByOrderBySalarioDesc();

    }

    public List<Funcionario> findFuncionarioZeroDependentes(){
        return funcionarioRepository.findFuncionarioSemDependentes();
    }

    public List<Funcionario> findFuncionarioSalario(Float salario){
        return funcionarioRepository.findBySalarioAfter(salario);
    }

    public List<Funcionario> findSalario(Float fSalario){
        return funcionarioRepository.findBySalario(fSalario);
    }

    public List<Funcionario> findFuncionarioPorDependentes(Integer numDependentes){
        return funcionarioRepository.findFuncionarioByQtdeDependentes(numDependentes);
    }

    public List<Funcionario> findFuncionarioPorNome(String parteNome){
        return funcionarioRepository.findFuncionarioByNomeFuncionario("%" + parteNome + "%");
    }

    public List<Funcionario> buscarTodos(){
        return funcionarioRepository.findAll();
        
    }
    public void aumentarSalario(Integer valor){
        funcionarioRepository.riseSalary(valor);
    }

    public List<Funcionario> buscarFuncionarioSemDependentesPorDepartamento(String departameto){
        return funcionarioRepository.findFuncionarioWithoutDependentes(departameto);
    }

    public void excluirFuncionarioPorDepto(String departamento){
        funcionarioRepository.deleteFuncionarioByDepartamento(departamento);
    }

    public void atualizarFuncionarioDeptoParaOutro(String deptoOrigem, String deptoDestino){
        funcionarioRepository.updateFuncionarioFromDeptoToAnother(deptoOrigem, deptoDestino);
    }
}
