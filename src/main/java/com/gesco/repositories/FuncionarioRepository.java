package com.gesco.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gesco.domain.Funcionario;
import com.gesco.domain.Paciente;
import com.gesco.dto.FuncionarioDTO;
import com.gesco.dto.UserDTO;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	 
	 @Transactional(readOnly=false)
	 Optional<Funcionario> findByNameUserAndSenha(String name, String senha);
	 
	 @Transactional(readOnly=false)
	 Optional<Funcionario> findByNome(String name);
	 
	 

}
