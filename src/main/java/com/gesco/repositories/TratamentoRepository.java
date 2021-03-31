package com.gesco.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {
	
	

}
