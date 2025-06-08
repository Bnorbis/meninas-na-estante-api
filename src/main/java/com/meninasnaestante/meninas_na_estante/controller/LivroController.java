package com.meninasnaestante.meninas_na_estante.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meninasnaestante.meninas_na_estante.dto.LivroDTO;
import com.meninasnaestante.meninas_na_estante.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private static final Logger logger = LoggerFactory.getLogger(LivroController.class);

	@Autowired
	private LivroService livroService;

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> getAllLivros() {
		logger.info("Recebendo requisição para buscar todos os livros...");

		List<LivroDTO> livros = livroService.getAllLivros();

		if (livros.isEmpty()) {
			logger.warn("Nenhum livro encontrado.");
			return ResponseEntity.noContent().build(); 
		}

		logger.info("Livros retornados com sucesso.");
		return ResponseEntity.ok(livros);
	}

	@GetMapping("/filtrar")
	public ResponseEntity<List<LivroDTO>> pesquisarLivrosporfiltro(@RequestParam String termo) {
		List<LivroDTO> livros = livroService.buscarLivrosporfiltro(termo);
		return ResponseEntity.ok(livros);
	}

}
