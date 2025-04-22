package com.meninasnaestante.meninas_na_estante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Encontro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProponente;
    private String livroSugerido;
    private LocalDateTime dataHora;
    private String descricao;
    private boolean revisado = false;

}
