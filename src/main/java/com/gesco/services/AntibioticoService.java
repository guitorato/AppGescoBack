package com.gesco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.repositories.AntibioticoRepository;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class AntibioticoService {
	
	@Autowired
	private AntibioticoRepository repo;
	
	public Antibiotico find(Integer id) {
		 Optional<Antibiotico> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Antibiótico não encontrado!"));
	}

}