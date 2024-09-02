package br.edu.utfpr.back_end_management_employee.repository;

import br.edu.utfpr.back_end_management_employee.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CargoRepostiroty extends JpaRepository<Cargo, Integer> {

    @Transactional(readOnly = false)
    @Modifying
    @Query(value = "DELETE FROM cargo c WHERE c.cod_cargo = ?1", nativeQuery = true)
    void deleteCargoByCodCargo(Integer codCargo);
}
