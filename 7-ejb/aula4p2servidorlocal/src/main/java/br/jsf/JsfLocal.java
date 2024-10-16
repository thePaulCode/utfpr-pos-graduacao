/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbLocalLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author engen
 */
@Named(value = "jsfLocal")
@RequestScoped
public class JsfLocal {

    @EJB
    private EjbLocalLocal ejbLocal;
    /**
     * Creates a new instance of JsfLocal
     */
    public JsfLocal() {
              
    }
    
    private int valor;
    private int resultado;
    
    public void dobrar(){
        
        resultado = ejbLocal.dobrar(valor);
    }

    public EjbLocalLocal getEjbLocal() {
        return ejbLocal;
    }

    public void setEjbLocal(EjbLocalLocal ejbLocal) {
        this.ejbLocal = ejbLocal;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getResulado() {
        return resultado;
    }

}
