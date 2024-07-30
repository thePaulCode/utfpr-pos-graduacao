package br.edu.utfpr.java_backend_categoria_musica_webconf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_musica", nullable = false)
    private Integer codMusica;

    @ManyToOne
    @JoinColumn(name = "cod_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "duracao")
    private Integer duracao;
}
