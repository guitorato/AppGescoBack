package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gesco.domain.Hospital;
import com.gesco.repositories.HospitalRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository repo;
	
	public Hospital find(Integer id) {
		 Optional<Hospital> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Hospital não encontrado!"));
	}
	
	public Hospital insert(Hospital obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Hospital update (Hospital obj) {
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
	public List<Hospital> findAll(){
		return repo.findAll();
	}
}
