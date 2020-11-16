package com.gesco.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {
	
	@Query("SELECT t FROM Tratamento t, Paciente p WHERE t.paciente=p.id AND p.nome LIKE %:nome%")
	List<Tratamento> findByNome (String nome);
	
	@Query("SELECT t FROM Tratamento t, Paciente p WHERE t.paciente=p.id AND p.registry = :registry")
	List<Tratamento> findByRegistry (Integer registry);
	
	@Query("SELECT t FROM Tratamento t WHERE t.statusTratamento = :status")
	List<Tratamento> findByStatus (Integer status);
	
	@Transactional
	@Modifying
	@Query("UPDATE Tratamento t SET t.statusTratamento = :status WHERE t.id = :id")
	void updateStatus(@Param(value = "id") Integer id, @Param(value = "status") Integer status);


}
