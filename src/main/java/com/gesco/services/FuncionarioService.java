package com.gesco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesco.domain.Funcionario;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario find(Integer id) {
		 Optional<Funcionario> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado!"));
	}

}
