package com.meninasnaestante.meninas_na_estante.service;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.meninasnaestante.meninas_na_estante.dto.LivroDTO;
import com.meninasnaestante.meninas_na_estante.entity.Livro;
import com.meninasnaestante.meninas_na_estante.repository.LivroRepository;

@Service
public class LivroService {

	private static final Logger logger = LoggerFactory.getLogger(LivroService.class);

	private final LivroRepository livroRepository;

	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
	}

	public List<LivroDTO> buscarLivrosPorFiltro(String titulo, String autora, String genero) {

		titulo = (titulo != null) ? titulo.trim() : "";
		autora = (autora != null) ? autora.trim() : "";
		genero = (genero != null) ? genero.trim() : "";

		logger.info("Buscando livros com filtros - Título: {}, Autora: {}, Gênero: {}", titulo, autora, genero);

		try {
			List<Livro> livros = livroRepository.findByTituloAndAutoraAndGenero(titulo, autora, genero);

			if (livros.isEmpty()) {
				logger.warn("Nenhum livro encontrado para os filtros fornecidos.");
				return Collections.emptyList();
			}

			logger.info("Número de livros encontrados: {}", livros.size());

			return livros.stream().map(LivroDTO::new).collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("Erro ao buscar livros: {}", e.getMessage(), e);
			throw new RuntimeException("Erro interno ao processar a requisição.");
		}
	}
}
