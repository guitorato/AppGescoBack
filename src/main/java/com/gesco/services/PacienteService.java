package com.gesco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.domain.Paciente;
import com.gesco.repositories.AntibioticoRepository;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.repositories.PacienteRepository;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	public Paciente find(Integer id) {
		 Optional<Paciente> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado!"));
	}

}
