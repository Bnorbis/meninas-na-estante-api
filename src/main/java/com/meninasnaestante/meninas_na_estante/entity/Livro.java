package com.meninasnaestante.meninas_na_estante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autora;
    private String genero;
    private String descricao;
    private String biografiaAutora;
    private String editora;
    private Integer anoPublicacao;
    private String imagemUrl;

}
