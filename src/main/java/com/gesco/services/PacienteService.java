package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.gesco.domain.Paciente;
import com.gesco.repositories.PacienteRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	private Paciente paciente;
	
	// -------- MÉTODO PARA BUSCAR POR ID
	public Paciente find(Integer id) {
		 Optional<Paciente> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado!"));
	}
	
	// -------- MÉTODO PARA CADASTRAR PACIENTE
	public Paciente insert(Paciente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	// -------- MÉTODO PARA ATUALIZAR PACIENTE
	public Paciente update (Paciente obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	// -------- MÉTODO PARA DELETAR PACIENTE
	public void delete (Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	// -------- MÉTODO PARA LISTAR TODOS OS PACIENTES 
	public List<Paciente> findAll(){
		return repo.findAll();
	}
	
	// -------- MÉTODO PARA LISTAR TODOS OS PACIENTES C/ FILTRO
	public Page<Paciente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		

		return repo.findAll(pageRequest);
	}
	
	// -------- MÉTODO PARA BUSCAR TODOS OS  PACIENTE PELO NOME
	public List<Paciente>findByNome(String nome) {
		List<Paciente> obj = repo.findByNome(nome);
		
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + paciente.getId() + ", Tipo: " + Paciente.class.getName());
		}
		return repo.findByNome(nome);
	}
	
	// -------- MÉTODO PARA LISTAR TODOS OS PACIENTES COM UM DETERMINADO REGISTRO DE ATENDIMENTO
	public List<Paciente> findRegistry(Long registry) {
		List<Paciente> obj = repo.findByRegistry(registry);
		
		 if (obj == null) {
				throw new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + paciente.getId() + ", Tipo: " + Paciente.class.getName());
			}
		 return repo.findByRegistry(registry);
	}
	

}
