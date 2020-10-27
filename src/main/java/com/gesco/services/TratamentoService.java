package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gesco.domain.Tratamento;
import com.gesco.repositories.TratamentoRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;


@Service
public class TratamentoService {
	
	@Autowired
	private TratamentoRepository repo;
	
	public Tratamento find(Integer id) {
		 Optional<Tratamento> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Tratamento não encontrado!"));
	}
	
	public Tratamento insert(Tratamento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Tratamento update (Tratamento obj) {
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
	
	public List<Tratamento> findAll(){
		return repo.findAll();
	}
	
	public Page<Tratamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		

		return repo.findAll(pageRequest);
	}
	
	public List<Tratamento> findPaciente(String nome) {
	
		 return repo.findByPaciente(nome);
	}

}
