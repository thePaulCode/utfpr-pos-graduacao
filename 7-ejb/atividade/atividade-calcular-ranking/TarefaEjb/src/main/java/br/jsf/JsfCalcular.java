/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbCalcular;
import br.ejb.EjbUsuario;
import br.ejb.IEjbLocal;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author engen
 */
@Named(value = "jsfCalcular")
@RequestScoped
//@ViewScoped
@Data
public class JsfCalcular  implements Serializable{

    private int randonA;
    private int randonB;
    private int valorUsuario;
    private int resultado;
    private String nomeUsuario; // Nome do usuário para vinculação

    @EJB
    private EjbUsuario ejbUsuario; // Injeta o EJB de usuários

    // Inicializa os números randômicos ao carregar a página
    public JsfCalcular() {
        gerarNovosNumeros();
    }

    // Método que gera novos números para o cálculo
    private void gerarNovosNumeros() {
        randonA = (int) (Math.random() * 100);
        randonB = (int) (Math.random() * 100);
        resultado = 0;
        valorUsuario = 0;
    }

    // Método que verifica a soma e incrementa pontos se o usuário acertar
    public String somar() {
    resultado = randonA + randonB;

    if (resultado == valorUsuario) {
        ejbUsuario.incrementarPontos(nomeUsuario); // Incrementa pontos se acertar
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Você acertou!", "Pontos adicionados."));
    } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Você errou!", "Tente novamente."));
    }

    return null; // Retorna null para permanecer na mesma página
}

    // Getters e setters para os atributos
    public int getRandonA() {
        return randonA;
    }

    public int getRandonB() {
        return randonB;
    }

    public int getValorUsuario() {
        return valorUsuario;
    }

    public void setValorUsuario(int valorUsuario) {
        this.valorUsuario = valorUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}