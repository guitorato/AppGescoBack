package com.gesco.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Paciente;
import com.gesco.domain.Tratamento;
import com.gesco.dto.PrescricaoDTO;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {
	
	@Query("SELECT t FROM Tratamento t, Paciente p WHERE t.paciente=p.id AND p.nome LIKE %:nome%")
	List<Tratamento> findByNome (String nome);
	
	@Query("SELECT t FROM Tratamento t WHERE t.paciente = :paciente")
	Optional<Tratamento> findPaciente (Integer paciente);
	
	@Query("SELECT t FROM Tratamento t, Paciente p WHERE t.paciente=p.id AND p.registro = :registro")
	Optional<Tratamento> findRegistroPaciente (Integer registro);
	
	@Query("SELECT t FROM Tratamento t WHERE t.prescricoes = :prescricoes")
	List<Tratamento> findByPrescricao(Integer prescricoes);

}
