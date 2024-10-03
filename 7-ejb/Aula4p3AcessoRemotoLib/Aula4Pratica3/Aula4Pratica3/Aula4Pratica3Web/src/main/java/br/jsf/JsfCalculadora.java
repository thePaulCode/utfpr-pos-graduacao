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
 * @author default
 */
@Named(value = "jsfCalculadora")
@RequestScoped
public class JsfCalculadora {

    @EJB
    private ICalculadora ejbCalculadora;

    /**
     * Creates a new instance of JsfCalculadora
     */
    public JsfCalculadora() {
    }
    
    public void somar(){
        resultado = ejbCalculadora.somar(valora, valorb);
    }
    
    @Setter @Getter
    private int valora;
    
    @Getter @Setter
    private int valorb;
    
    @Getter
    private int resultado;
            
}
