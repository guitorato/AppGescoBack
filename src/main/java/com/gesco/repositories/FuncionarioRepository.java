package com.gesco.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gesco.domain.Funcionario;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	Optional<Funcionario> findByLogin (String login);
	
	Funcionario findByLoginLike (String login);
	
	Optional<Funcionario> deleteByLogin(String login);

}