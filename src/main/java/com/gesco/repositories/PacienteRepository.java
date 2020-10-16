package com.gesco.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gesco.domain.Funcionario;
import com.gesco.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	 @Transactional(readOnly=true)
	 List<Paciente> findByNome(String nome);
	 
	 
	 @Transactional(readOnly=true)
	 List<Paciente> findByRegistry(Long registry);
	

}
