package com.gesco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Funcionario;
import com.gesco.domain.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {

}
