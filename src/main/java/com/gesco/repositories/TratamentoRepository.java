package com.gesco.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Paciente;
import com.gesco.domain.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {
	
	
	@Query("SELECT t FROM Tratamento t WHERE t.paciente = :paciente")
	Optional<Tratamento> findPaciente (Integer paciente);

}
