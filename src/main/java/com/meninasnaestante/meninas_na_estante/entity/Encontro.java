package com.meninasnaestante.meninas_na_estante.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "encontro")
public class Encontro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProponente;
    private String livroSugerido;
    private LocalDateTime dataHora;
    private String descricao;
    //private boolean revisado = false;

}
