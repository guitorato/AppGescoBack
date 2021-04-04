package com.gesco.repositories;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Prescricao;
import com.gesco.domain.Tratamento;

@Repository
public interface PrescricaoRepository extends JpaRepository<Prescricao, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Prescricao p SET p.statusTratamento = :statusTratamento , p.descStatusTratamento = :descStatusTratamento WHERE p.id = :id")
	void updateStatusTratamentoAndDescStatusTratamento (Integer statusTratamento , String descStatusTratamento , Integer id);
	
	
	//@Param(value = "id") Integer id, @Param(value = "status") Integer status

}
