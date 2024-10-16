/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.model;

import javax.ejb.Local;

/**
 *
 * @author Paulo Santos
 */
@Local
public interface ICalcular {
    
    int somar(int a, int b, int valorUsuario);
}
