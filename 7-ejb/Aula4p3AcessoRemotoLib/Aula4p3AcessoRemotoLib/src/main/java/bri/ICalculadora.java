/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bri;

import javax.ejb.Remote;

/**
 *
 * @author Paulo Santos
 */
@Remote
public interface ICalculadora {
    
    int somar(int a, int b);
    
}
