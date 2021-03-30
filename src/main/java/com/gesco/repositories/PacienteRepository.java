package com.gesco.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	@Query("SELECT p FROM Paciente p WHERE p.nome LIKE %:nome% AND p.statusPaciente = true")
	 List<Paciente> findByNome(String nome);
	
	@Query("SELECT p FROM Paciente p WHERE p.registro = :registro AND p.statusPaciente = true")
	List<Paciente> findByRegistro(Integer registro);
	
	@Transactional
	Optional<Paciente> findByRegistroLike (Integer registro);
	
	@Transactional
	Paciente deleteByRegistro (Integer registro);
	
	List<Paciente> findByStatusPaciente (boolean statusTratamento);
	 
	 
	

}
