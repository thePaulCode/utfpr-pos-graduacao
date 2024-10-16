/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package br.data.crud;

import br.model.ItemCompra;
import br.model.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author engen
 */
@Stateful
public class EjbCompra {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private List<ItemCompra> listaCompra;

    public EjbCompra() {
        listaCompra = new ArrayList<>();
    }

    public void add(Produto produto) {
        boolean produtoNaLista = false;
        for (ItemCompra item : listaCompra) {
            if (item.getProduto().getId() == produto.getId()) {

                item.setQuantidade(item.getQuantidade() + 1);
                produtoNaLista = true;
                break;
            }
        }

        if (!produtoNaLista) {

            listaCompra.add(new ItemCompra(produto, 1));
        }

    }

    public List<ItemCompra> getAll() {
        return listaCompra;
    }

    public void getOrderList(){
    
        Collections.sort(getAll());
    }
    public Double getValorCompra() {

        Double valorProdutos = this.listaCompra.stream()
                .filter(produtos -> produtos.getQuantidade() >= 0)
                .mapToDouble(produto -> 
                        produto.getProduto().getValor() * produto.getQuantidade()) 
                .sum();

        return valorProdutos;
    }
}
