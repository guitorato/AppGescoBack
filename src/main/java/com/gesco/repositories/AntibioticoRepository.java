package com.gesco.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;

@Repository
public interface AntibioticoRepository extends JpaRepository<Antibiotico, Integer> {
	
	
	@Query("SELECT a FROM Antibiotico a WHERE a.nome LIKE %:nome%")
	List<Antibiotico> findByNome(String nome);

}
