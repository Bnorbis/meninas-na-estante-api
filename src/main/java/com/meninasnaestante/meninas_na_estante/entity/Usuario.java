package com.meninasnaestante.meninas_na_estante.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name  = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;
}
