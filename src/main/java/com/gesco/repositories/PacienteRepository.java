package com.gesco.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gesco.domain.Funcionario;
import com.gesco.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	@Query("SELECT p FROM Paciente p WHERE p.nome LIKE %:nome% ORDER BY registry ASC")
	 List<Paciente> findByNome(String nome);
	 
	 
	//@Query("SELECT p FROM Paciente p WHERE p.registry LIKE %:registry% ORDER BY `registry` ASC")
	 //List<Paciente> findByRegistry(Long registry);
	 
	 //@Query("SELECT p FROM Paciente p WHERE p.nome LIKE %:nome% AND p.registry LIKE %:registry% ")
	 //List<Paciente> findByNomeAndRegistry(String nome,Long registry);
	 
	 
	

}
