package com.gesco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	@Query("SELECT p FROM Paciente p WHERE p.nome LIKE %:nome% ORDER BY registry ASC")
	 List<Paciente> findByNome(String nome);
	 
	 
	@Query("SELECT p FROM Paciente p WHERE p.registry = :registry ORDER BY registry ASC")
	 List<Paciente> findByRegistry(Integer registry);
	 
	 //@Query("SELECT p FROM Paciente p WHERE p.nome LIKE %:nome% AND p.registry LIKE %:registry% ")
	 //List<Paciente> findByNomeAndRegistry(String nome,Long registry);
	 
	 
	

}
