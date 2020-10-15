package com.gesco.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Funcionario;
import com.gesco.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	
	

}
