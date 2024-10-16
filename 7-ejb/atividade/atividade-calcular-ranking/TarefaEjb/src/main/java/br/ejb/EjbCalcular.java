/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.model.Calcular;
import br.model.ICalcular;
import javax.ejb.Stateless;
import lombok.Data;

/**
 *
 * @author engen
 */
@Stateless
public class EjbCalcular implements IEjbLocal{
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public EjbCalcular() {}
    
    @Override
    public int somar(int a, int b, int valorUsuario){
       int resultado = a + b;
       return (resultado == valorUsuario)? resultado : -1;
    }
    
    
}
