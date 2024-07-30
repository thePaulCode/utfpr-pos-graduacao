package br.edu.utfpr.java_backend_categoria_musica_webconf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_categoria", nullable = false)
    private Integer codCategoria;
    @Column(name = "desc_categoria", length = 50)
    private String descCategoria;

}
