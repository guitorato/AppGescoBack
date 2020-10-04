package com.gesco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;

@Repository
public interface AntibioticoRepository extends JpaRepository<Antibiotico, Integer> {

}
