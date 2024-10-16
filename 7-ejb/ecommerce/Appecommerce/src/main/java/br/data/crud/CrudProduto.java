/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data.crud;


import br.model.Produto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author engen
 */
public class CrudProduto {
       
    
    public CrudProduto(){
    
        
    }
    
    public List<Produto> getAll(){
        List<Produto> listaProdutos = new ArrayList<>();
        
        listaProdutos.add(new Produto(1L, "Mouse", 10.99d));
        listaProdutos.add(new Produto(2L, "Teclado", 50.99d));
        listaProdutos.add(new Produto(3L, "Touchpad", 18.50d));
        listaProdutos.add(new Produto(4L, "Mesa", 400.99d));
        listaProdutos.add(new Produto(5L, "Webcam", 10.99d));
        
        Double valorCompra = listaProdutos.stream()
                                        .filter(p -> p.getValor() != null )
                                         .mapToDouble(p -> p.getValor())
                .sum();
        
        System.out.println(valorCompra);
        return listaProdutos;
    }
    
    List<Produto> listaTotal = getAll();
    
    public Double valorCompra(List<Produto> listaTotal ){
        
        Double valorCompra = listaTotal.stream()
                                        .filter(p -> p.getValor() != null )
                                         .mapToDouble(p -> p.getValor())
                                            .sum();
        
        System.out.println(valorCompra);
        return valorCompra;
        
    }
        
    public static void main(String[] args) {
        CrudProduto crud = new CrudProduto();
        
        System.out.println(crud.getAll());
        System.out.println(crud.valorCompra(crud.getAll()));
    }
    
    
    
}
