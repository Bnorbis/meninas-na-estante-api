package com.example.bibliotecadigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bibliotecadigital.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT l FROM Livro l WHERE " + "LOWER(l.titulo) LIKE LOWER(CONCAT('%', :termo, '%')) OR "
			+ "LOWER(l.autora) LIKE LOWER(CONCAT('%', :termo, '%')) OR "
			+ "LOWER(l.genero) LIKE LOWER(CONCAT('%', :termo, '%'))")
	List<Livro> buscarPorFiltro(@Param("termo") String termo);

}