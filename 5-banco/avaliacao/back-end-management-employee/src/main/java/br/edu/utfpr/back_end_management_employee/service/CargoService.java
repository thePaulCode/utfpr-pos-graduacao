package br.edu.utfpr.back_end_management_employee.service;

import br.edu.utfpr.back_end_management_employee.entity.Cargo;
import br.edu.utfpr.back_end_management_employee.repository.CargoRepostiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepostiroty repostiroty;

    public void salvar(Cargo cargo){
        repostiroty.save(cargo);
    }

    public List<Cargo> listarTodos(){
        return repostiroty.findAll();
    }

    public void excluir(Integer id){

        try {
            repostiroty.deleteCargoByCodCargo(id);
        } catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }
}
