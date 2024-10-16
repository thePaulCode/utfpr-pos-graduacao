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
public class ItemCompra implements Comparable<ItemCompra> {
    
    private Produto produto;
    private int quantidade;

    public ItemCompra() {
    }

    public ItemCompra(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(ItemCompra o) {
        return this.produto.getId().compareTo(o.produto.getId());
    }
    
    
    
}
