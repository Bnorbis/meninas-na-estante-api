package com.meninasnaestante.meninas_na_estante.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meninasnaestante.meninas_na_estante.dto.LivroDTO;
import com.meninasnaestante.meninas_na_estante.entity.Livro;
import com.meninasnaestante.meninas_na_estante.service.LivroService;

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
	public ResponseEntity<?> pesquisarLivros(
	    @RequestParam(required = false) String titulo,
	    @RequestParam(required = false) String autora,
	    @RequestParam(required = false) String genero) {

	    try {
	        List<LivroDTO> livros = livroService.buscarLivrosPorFiltro(titulo, autora, genero);
	        return ResponseEntity.ok(livros);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}


}
