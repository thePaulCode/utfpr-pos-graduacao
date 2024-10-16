/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbProduto;
import br.model.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author engen
 */
@Named(value = "jsfProduto")
@RequestScoped
public class JsfProduto {

    @EJB
    private EjbProduto ejbProduto;

    
    /**
     * Creates a new instance of JsfProduto
     */
    public JsfProduto() {
    }
    
    public List<Produto> getAll(){
    
        return ejbProduto.getAll();
    }
    
    //List<Produto> listaTotal = ejbProduto.getAll();
    
   
}
