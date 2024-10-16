/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;
import br.ejb.IEjbLocal;

/**
 *
 * @author engen
 */
@Named(value = "jsfCalcular")
@RequestScoped
public class JsfLocal {

    @EJB
    private IEjbLocal ejbLocal;
  
    @Getter @Setter
    private int valorA;
    @Getter @Setter
    private int valorB;
    @Getter
    private int resultado;
    
    public JsfLocal() {
        
    }
    
    public void somar(){
        resultado = ejbLocal.somar(valorA, valorB);
    }
    
}
