/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbUsuario;
import br.model.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import lombok.Data;

/**
 *
 * @author engen
 */
@Named(value = "jsfUsuario")
@SessionScoped
@Data
public class JsfUsuario implements Serializable {

    private Usuario usuario = new Usuario(); // Objeto Usuario para input do formulário
    
    @EJB
    private EjbUsuario ejbUsuario;

    public void addUsuario() {
        ejbUsuario.add(usuario); // Adiciona o usuário ao EJB
        usuario = new Usuario(); // Limpa o formulário para novo usuário
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Usuario> getAll(){
    
        return ejbUsuario.getAll();
    }
}