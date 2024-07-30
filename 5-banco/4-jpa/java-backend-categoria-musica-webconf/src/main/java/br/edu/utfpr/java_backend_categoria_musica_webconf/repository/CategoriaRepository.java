package br.edu.utfpr.java_backend_categoria_musica_webconf.repository;

import br.edu.utfpr.java_backend_categoria_musica_webconf.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
