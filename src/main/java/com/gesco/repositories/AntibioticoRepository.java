package com.gesco.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Antibiotico;

@Repository
public interface AntibioticoRepository extends JpaRepository<Antibiotico, Integer> {
	
	@Query("SELECT a FROM Antibiotico a WHERE a.nome LIKE %:nome%")
	List<Antibiotico> findByNome (String nome);
	
	@Query("SELECT a FROM Antibiotico a WHERE a.nomeComercial LIKE %:nomeComercial%")
	List<Antibiotico> findByNomeComercial (String nomeComercial);

}
