package com.gesco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gesco.domain.Paciente;
import com.gesco.domain.Tratamento;
import com.gesco.repositories.PacienteRepository;
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

}
