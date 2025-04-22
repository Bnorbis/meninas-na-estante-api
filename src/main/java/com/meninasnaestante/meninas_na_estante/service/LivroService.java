package com.meninasnaestante.meninas_na_estante.service;

import com.meninasnaestante.meninas_na_estante.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
}
