/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.data.crud.CrudProduto;
import br.model.Produto;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author engen
 */
@Stateless
public class EjbProduto {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
      
    public EjbProduto(){}
    
    public List<Produto> getAll(){
        
        return new CrudProduto().getAll();
    }
        
//    public Double getValorCompra( ){
//        
//        return new CrudProduto().valorCompra(new CrudProduto().getAll());
//    }
}
