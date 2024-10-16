/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbHello;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author engen
 */
@Named(value = "jsfHello")
@RequestScoped
public class JsfHello {

    @EJB
    private EjbHello ejbHello;
        
    /**
     * Creates a new instance of JsfHello
     */
    public JsfHello() {
    }
    
    public String getHello(){
        return ejbHello.getHello();
    }
}
