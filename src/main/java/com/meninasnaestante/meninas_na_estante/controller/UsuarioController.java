package com.meninasnaestante.meninas_na_estante.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UsuarioController {

    @GetMapping("/usuario")
    public ResponseEntity<String> getUsuario() {
        return ResponseEntity.ok("Usuario encontrado");
    }
}
