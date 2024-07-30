package br.edu.utfpr.java_backend_categoria_musica_webconf.service;

import br.edu.utfpr.java_backend_categoria_musica_webconf.entity.Musica;
import br.edu.utfpr.java_backend_categoria_musica_webconf.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository repository;

    public List<Musica> listarMusicas() {
        return repository.findAll();
    }
}
