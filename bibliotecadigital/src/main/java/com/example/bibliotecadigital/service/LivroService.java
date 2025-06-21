package com.example.bibliotecadigital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.bibliotecadigital.dto.LivroDTO;
import com.example.bibliotecadigital.entity.Livro;
import com.example.bibliotecadigital.repository.LivroRepository;

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

	public List<LivroDTO> buscarLivrosPorFiltroGlobal(String termo) {

		if (termo != null) {
			termo = termo.trim().replace("%", "");
		}

		logger.info("Buscando livros com termo: {}", termo);

		try {
			List<Livro> livros;

			if (termo.isEmpty()) {
				livros = livroRepository.findAll();
			} else {
				livros = livroRepository.buscarPorFiltro(termo);
			}

			if (livros.isEmpty()) {
				logger.warn("Nenhum livro encontrado com o termo fornecido.");
				throw new RuntimeException("Nenhum livro encontrado com o termo fornecido.");
			}

			logger.info("Número de livros encontrados: {}", livros.size());
			return livros.stream().map(LivroDTO::new).collect(Collectors.toList());

		} catch (Exception e) {
			logger.error("Erro ao buscar livros: {}", e.getMessage(), e);
			throw new RuntimeException("Erro interno ao processar a requisição.");
		}
	}
	
	 public LivroDTO criarLivro(LivroDTO livroDTO) {
	        logger.info("Salvando livro no banco: {}", livroDTO);
	        
	        Livro livro = new Livro();
	        livro.setTitulo(livroDTO.getTitulo());
	        livro.setAutora(livroDTO.getAutora());
	        livro.setGenero(livroDTO.getGenero());
	        livro.setDescricao(livroDTO.getDescricao());
	        livro.setBiografiaAutora(livroDTO.getBiografiaAutora());
	        livro.setAnoPublicacao(livroDTO.getAnoPublicacao());
	        livro.setEditora(livroDTO.getEditora());
	        livro.setImagemUrl(livroDTO.getImagemUrl());

	        livro = livroRepository.save(livro);

	        return new LivroDTO(livro);
	    }

}
