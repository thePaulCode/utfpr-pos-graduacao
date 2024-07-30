package br.edu.utfpr.java_backend_categoria_musica_webconf.repository;

import br.edu.utfpr.java_backend_categoria_musica_webconf.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
