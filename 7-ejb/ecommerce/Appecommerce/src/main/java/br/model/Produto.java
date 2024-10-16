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
public class Produto {
    
    private Long id;
    private String descricao;
    private Double valor;
    
    public Produto(){}
    
    public Produto(Long id, String descricao, Double valor){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }
   
    
}
