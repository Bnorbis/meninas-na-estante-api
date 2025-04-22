package com.meninasnaestante.meninas_na_estante.service;

import com.meninasnaestante.meninas_na_estante.repository.EncontroRepository;
import org.springframework.stereotype.Service;

@Service
public class EncontroService {
    private final EncontroRepository encontroRepository;

    public EncontroService(EncontroRepository encontroRepository) {
        this.encontroRepository = encontroRepository;
    }

}
