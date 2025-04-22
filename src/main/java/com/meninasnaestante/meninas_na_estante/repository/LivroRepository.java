package com.meninasnaestante.meninas_na_estante.repository;

import com.meninasnaestante.meninas_na_estante.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
