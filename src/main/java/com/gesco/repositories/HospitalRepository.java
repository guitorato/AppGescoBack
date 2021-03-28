package com.gesco.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
	Optional<Hospital> findByNome (String nome);

}
