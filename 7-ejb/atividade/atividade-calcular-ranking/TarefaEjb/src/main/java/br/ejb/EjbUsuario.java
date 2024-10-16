package br.ejb;

import br.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class EjbUsuario {

    // Lista de usuários
    private List<Usuario> lUsuario;

    public EjbUsuario() {
        lUsuario = new ArrayList<>();  // Inicializa a lista de usuários
    }

    // Método para adicionar usuário com 0 pontos
    public void add(Usuario usuario) {
        boolean existeUsuario = false;

        // Verifica se o usuário já existe
        for (Usuario u : lUsuario) {
            if (u.getNome().equals(usuario.getNome())) {
                existeUsuario = true; // Usuário já existe
                break;
            }
        }

        // Se não existe, adiciona com 0 pontos
        if (!existeUsuario) {
            lUsuario.add(new Usuario(usuario.getNome(), 0));
        }
    }

    // Método para incrementar pontos
    public void incrementarPontos(String nomeUsuario) {
        for (Usuario u : lUsuario) {
            if (u.getNome().equals(nomeUsuario)) {
                u.setPontos(u.getPontos() + 10); // Incrementa 10 pontos
                break;
            }
        }
    }

    // Retorna todos os usuários
    public List<Usuario> getAll() {
        return lUsuario;
    }
}
