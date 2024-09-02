package br.edu.utfpr.back_end_management_employee.service;

import br.edu.utfpr.back_end_management_employee.entity.Funcionario;
import br.edu.utfpr.back_end_management_employee.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public void salvar(Funcionario funcionario){
        repository.save(funcionario);
    }

    public List<Funcionario> listarTodos(){
        return repository.findAll();
    }

    public List<Funcionario> listarTodosOrdemCrescente(){

        return repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    //TODO revisar
//    public int quantidadeFuncionarios(){
//        return (int) repository.count();
//    }
    public int quantidadeFuncionarios(){
        return repository.countAllByNomeIsNotNull();
    }

    public void excluir(Integer id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }
}
