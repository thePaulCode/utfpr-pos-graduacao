/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author engen
 */
@Stateless
public class EjbLocal implements IEjbLocal {

    @Override
    public int somar(int a, int b){
        return a+b;
    }
            
}
