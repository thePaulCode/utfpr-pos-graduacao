package br.edu.utfpr.java_backend_categoria_musica_webconf.service;

import br.edu.utfpr.java_backend_categoria_musica_webconf.entity.Categoria;
import br.edu.utfpr.java_backend_categoria_musica_webconf.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public void salvar(Categoria categoria){
        repository.save(categoria);
    }
}
