package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gesco.domain.Antibiotico;
import com.gesco.repositories.AntibioticoRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;

import io.swagger.annotations.ApiOperation;

@Service
public class AntibioticoService {
	
	@Autowired
	private AntibioticoRepository repo;
	
	@ApiOperation(value = "BUSCAR POR ID DO Antibiótico")
	public Antibiotico findId(Integer id) {
		 Optional<Antibiotico> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Antibiótico não encontrado!"));
	}
	
	@ApiOperation(value = "INSERE UM NOVO Antibiótico")
	public Antibiotico insert(Antibiotico obj) {
		obj.setId(null);
		obj.setNome(obj.getNome().toUpperCase());
		obj.setNomeComercial(obj.getNomeComercial().toUpperCase());
		return repo.save(obj);
	}
	
	@ApiOperation(value = "ATUALIZA UM Antibiótico")
	public Antibiotico update (Antibiotico obj) {
		findId(obj.getId());
		obj.setNome(obj.getNome().toUpperCase());
		obj.setNomeComercial(obj.getNomeComercial().toUpperCase());
		return repo.save(obj);
	}
	
	@ApiOperation(value = "DELETA UM Antibiótico")
	public void delete (Integer id) {
		findId(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	@ApiOperation(value = "LISTA DE TODOS OS Antibiótico S/FILTRO")
	public List<Antibiotico> findAll(){
		return repo.findAll();
	}
	
	
	@ApiOperation(value = "BUSCAR PELO DOIS NOMES DO Antibiótico")
	public List<Antibiotico> findByNome(String nome) {
	
		if(repo.findByNome(nome).isEmpty()) {
			if(repo.findByNomeComercial(nome).isEmpty()) {
				
				throw new ObjectNotFoundException("Antibiótico Não Encontrado");
				
			}else {
				
				return repo.findByNomeComercial(nome);
			}
		
		}else {
			
		  return repo.findByNome(nome);
		}

	}
}
