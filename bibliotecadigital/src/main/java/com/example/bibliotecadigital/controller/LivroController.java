package com.example.bibliotecadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecadigital.dto.LivroDTO;
import com.example.bibliotecadigital.entity.Livro;
import com.example.bibliotecadigital.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;

	@GetMapping
	public List<Livro> getAllLivros() {
		return livroService.getAllLivros();
	}
	
	@GetMapping("/filtrar")
	public ResponseEntity<?> pesquisarLivros(@RequestParam(required = false) String termo) {
	    try {
	        List<LivroDTO> livros = livroService.buscarLivrosPorFiltroGlobal(termo);
	        return ResponseEntity.ok(livros);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado com criterios de busca");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor.");
	    }
	}
	
	@PostMapping
    public ResponseEntity<LivroDTO> criarLivro(@RequestBody LivroDTO livroDTO) {
        LivroDTO livroSalvo = livroService.criarLivro(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }


}
