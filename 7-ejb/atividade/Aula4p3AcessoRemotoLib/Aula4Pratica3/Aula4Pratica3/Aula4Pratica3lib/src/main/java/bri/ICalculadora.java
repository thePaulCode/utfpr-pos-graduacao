/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bri;

import javax.ejb.Remote;

/**
 *
 * @author default
 */
@Remote
public interface ICalculadora {
    public int somar(int a, int b);
}
