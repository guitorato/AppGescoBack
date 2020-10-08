package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.domain.Hospital;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario find(Integer id) {
		 Optional<Funcionario> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado!"));
	}

	public Funcionario insert(Funcionario obj) {
		obj.setIdFuncionario(null);
		return repo.save(obj);
	}
	
	public Funcionario update (Funcionario obj) {
		find(obj.getIdFuncionario());
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
	
	public List<Funcionario> findAll(){
		return repo.findAll();
	}
}
