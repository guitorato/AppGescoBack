package com.gesco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {
	
	@Query("SELECT t FROM Tratamento t, Paciente p WHERE t.paciente=p.id AND p.nome LIKE %:nome%")
	List<Tratamento> findByNome (String nome);
	
	@Query("SELECT t FROM Tratamento t, Paciente p WHERE t.paciente=p.id AND p.registry = :registry")
	List<Tratamento> findByRegistry (Integer registry);

}
