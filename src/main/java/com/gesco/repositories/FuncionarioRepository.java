package com.gesco.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gesco.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	 
	 @Transactional(readOnly=false)
	 Optional<Funcionario> findByNameUserAndSenha(String name, String senha);
	 
	 @Query("SELECT a FROM Funcionario a WHERE a.nome LIKE %:nome%")
		List<Funcionario> findByNome(String nome);
	 
	 
	 

}
