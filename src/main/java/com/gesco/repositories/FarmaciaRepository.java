package com.gesco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Farmacia;
import com.gesco.domain.Funcionario;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Integer> {

}
