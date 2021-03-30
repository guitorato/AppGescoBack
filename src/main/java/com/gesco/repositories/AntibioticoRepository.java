package com.gesco.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Antibiotico;

@Repository
public interface AntibioticoRepository extends JpaRepository<Antibiotico, Integer> {
	
	List<Antibiotico> findByNomeLike (String nome);
	
	List<Antibiotico> findByNomeComercialLike (String nomComercial);

}
