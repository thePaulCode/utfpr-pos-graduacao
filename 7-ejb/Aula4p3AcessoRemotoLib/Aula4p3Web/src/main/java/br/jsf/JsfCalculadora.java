/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import bri.ICalculadora;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author engen
 */
@Named(value = "jsfCalculadora")
@RequestScoped
public class JsfCalculadora {

    @EJB
    private ICalculadora ejbCalculadora1;
    
    @Setter @Getter
    private int valorA;
    @Setter @Getter
    private int valorB;
    @Getter
    private int resultado;
    
    public void somar(){
        resultado = ejbCalculadora1.somar(valorA, valorB);
    }

    /**
     * Creates a new instance of JsfCalculadora
     */
    public JsfCalculadora() {
     
    }
    
    
    
}
