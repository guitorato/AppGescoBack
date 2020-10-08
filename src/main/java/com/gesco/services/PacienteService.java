package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Paciente;
import com.gesco.repositories.PacienteRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	public Paciente find(Integer id) {
		 Optional<Paciente> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado!"));
	}
	
	public Paciente insert(Paciente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Paciente update (Paciente obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	public List<Paciente> findAll(){
		return repo.findAll();
	}

}
