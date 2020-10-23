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
		return repo.save(obj);
	}
	
	@ApiOperation(value = "ATUALIZA UM Antibiótico")
	public Antibiotico update (Antibiotico obj) {
		findId(obj.getId());
		return repo.save(obj);
	}
	
	@ApiOperation(value = "DELETA UM Antibiótico")
	public void delete (Integer id) {
		findId(id);
		try {
			
			repo.deleteById(id);
			System.out.println("Deltado: "+id);
			
		}catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	@ApiOperation(value = "LISTA DE TODOS OS Antibiótico S/FILTRO")
	public List<Antibiotico> findAll(){
		return repo.findAll();
	}
	
	@ApiOperation(value = "BUSCAR POR NOME DO Antibiótico, ELE BUSCA MESMO INCOMPLETO O NOME")
	public List<Antibiotico> findByNome(String nome) {
	
	if (nome.equals("")) {
		throw new ObjectNotFoundException(("Digite o nome do Antibiótico!"));
	}else
		return repo.findByNome(nome);
	}


}
