package com.meninasnaestante.meninas_na_estante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meninasnaestante.meninas_na_estante.dto.LivroDTO;
import com.meninasnaestante.meninas_na_estante.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	@Query("SELECT l FROM Livro l WHERE "
		     + "(:titulo IS NOT NULL AND l.titulo LIKE %:titulo%) "
		     + "OR (:autora IS NOT NULL AND l.autora LIKE %:autora%) "
		     + "OR (:genero IS NOT NULL AND l.genero LIKE %:genero%)")
		List<Livro> buscarPorFiltros(@Param("titulo") String titulo,  
		                             @Param("autora") String autora,  
		                             @Param("genero") String genero);
	
	
	
	List<Livro> findByTituloAndAutoraAndGenero(String titulo, String autora, String genero);
	
	


	
}
