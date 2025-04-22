package com.meninasnaestante.meninas_na_estante.repository;

import com.meninasnaestante.meninas_na_estante.entity.Encontro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncontroRepository extends JpaRepository<Encontro, Long> {
    //TODO buscar encontros revisados e aprovados apenas (para aparecerem no front end)
    List<Encontro> findByRevisadoTrue();
}
