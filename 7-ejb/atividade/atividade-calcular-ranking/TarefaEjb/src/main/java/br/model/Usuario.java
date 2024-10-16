/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.model;

import lombok.Data;

/**
 *
 * @author engen
 */
@Data
public class Usuario {
    
    private String nome;
    private int pontos;
    
    public Usuario(){
    
    }

    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }
    
    
    
}
