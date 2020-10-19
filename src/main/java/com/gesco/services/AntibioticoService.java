package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.repositories.AntibioticoRepository;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class AntibioticoService {
	
	@Autowired
	private AntibioticoRepository repo;
	
	
	public Antibiotico findId(Integer id) {
		 Optional<Antibiotico> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Antibiótico não encontrado!"));
	}
	
	public Antibiotico insert(Antibiotico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Antibiotico update (Antibiotico obj) {
		findId(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) {
		findId(id);
		try {
			
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	public List<Antibiotico> findAll(){
		return repo.findAll();
	}
	
	public List<Antibiotico> findByNome(String nome) {
	
	if (nome.equals("")) {
		throw new ObjectNotFoundException(("Antibiótico não encontrado!"));
	}else
		return repo.findByNome(nome);
	}


}
