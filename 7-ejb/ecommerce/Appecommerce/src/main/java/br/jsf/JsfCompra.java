/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.data.crud.EjbCompra;
import br.model.ItemCompra;
import br.model.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author engen
 */
@Named(value = "jsfCompra")
@SessionScoped
public class JsfCompra implements Serializable {

    @EJB
    private EjbCompra ejbCompra;

    /**
     * Creates a new instance of JsfCompra
     */
    public JsfCompra() {
    }
    
    public void add(Produto produto){
        ejbCompra.add(produto);
    }
    
    public List<ItemCompra> getAll(){
        // TODO: implementar SORT by id
        
        return ejbCompra.getAll();
    }
    
    public void getOrderList(){
    
        ejbCompra.getOrderList();
    }
    
    
    public Double getValorCompra(){
    
        return ejbCompra.getValorCompra();
    }
    
}
