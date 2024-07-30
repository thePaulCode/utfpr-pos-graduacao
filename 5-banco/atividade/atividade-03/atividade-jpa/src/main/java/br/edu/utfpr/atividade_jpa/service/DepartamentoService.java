package br.edu.utfpr.atividade_jpa.service;

import br.edu.utfpr.atividade_jpa.entity.Departamento;
import br.edu.utfpr.atividade_jpa.entity.Funcionario;
import br.edu.utfpr.atividade_jpa.repository.DepartamentoRepository;
import br.edu.utfpr.atividade_jpa.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Departamento findFirstDepartamento(){
        return departamentoRepository.findFirstBy();
    }

    //5-5
    @Transactional(readOnly = false)
    public void salvarDeptoTransacao(Departamento departamento, Funcionario funcionario){
        departamentoRepository.save(departamento);
        funcionario.setDepartamento(departamento);
        funcionarioRepository.save(funcionario);
    }
}
