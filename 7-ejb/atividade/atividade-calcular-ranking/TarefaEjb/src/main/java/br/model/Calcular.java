/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.model;

import lombok.Data;

/**
 *
 * @author Paulo Santos
 */
@Data
public class Calcular implements ICalcular {
    
    private int valorA=0;
    private int valorB=0;
    private int resultado=0;

    @Override
    public int somar(int valorA, int valorb, int valorUsuario) {
        resultado = valorA+valorB;
        return (resultado == valorUsuario)? resultado : -1;
    }
    
}
