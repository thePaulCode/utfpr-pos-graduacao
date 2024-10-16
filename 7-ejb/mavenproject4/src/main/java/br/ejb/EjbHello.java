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
public class EjbHello {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public String getHello(){
        return "Hello from Enterprise Java Beans";
    }
}
