package com.placeti.avaliacao.repository;

import com.placeti.avaliacao.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

//----------------------------------------------
/** Repositório para entidade Cidade */
//----------------------------------------------
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
