package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gesco.domain.Funcionario;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;



@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repo;
	
	
	
	// -------- MÉTODO PROVISÓRIO DE LOGIN 
	public Funcionario findLogin(String nameUser, String senha) {
		
		if (nameUser.equals("") && senha.equals("")) {
			throw new ObjectNotFoundException(("Digita o Usuário e a Senha!"));
			
		}else if(nameUser.equals("")){
			
			throw new ObjectNotFoundException(("Digita o Usuário!"));
			
		}else if(senha.equals("")){
			
			throw new ObjectNotFoundException(("Digita a Senha!"));
			
		}
			
		Optional<Funcionario> obj = repo.findByNameUserAndSenha(nameUser, senha);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
		 
		
	}
	
	// -------- MÉTODO PARA BUSCA POR FUNCIONÁRIO POR ID
	public Funcionario find(Integer id) {
		 Optional<Funcionario> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado!"));
	}

	// -------- MÉTODO PARA CADASTRO DO FUNCIONÁRIO
	public Funcionario insert(Funcionario obj) {
		obj.setIdFuncionario(null);
		return repo.save(obj);
	}
	
	// -------- MÉTODO PARA ATUALIZAR O CADASTRO DO FUNCIONÁRIO
	public Funcionario update (Funcionario obj) {
		find(obj.getIdFuncionario());
		return repo.save(obj);
	}
	
	
	// -------- MÉTODO PARA DELETAR O FUNCIONÁRIO
	public void delete (Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	// -------- MÉTODO PARA BUSCAR TODOS OS FUNCIONÁRIOS CADASTRADOS
	public List<Funcionario> findAll(){
		return repo.findAll();
	}
	
	
	// -------- MÉTODO PARA BUSCAR DE TODOS OS CADASTROS, COM FILTRO DE QUANTIDADES A SEREM EXIBIDAS, ORDENAÇÃO 
	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		

		return repo.findAll(pageRequest);
	}

	
}
