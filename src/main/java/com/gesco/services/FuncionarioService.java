package com.gesco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gesco.domain.Funcionario;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	// -------- MÉTODO PARA DELETAR O FUNCIONÁRIO UTILIZANDO O LOGIN
		public void delete (String login) {
			repo.findByLogin(login);
			try {
				
				repo.deleteByLogin(login);
			}catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir");
			}
		}
		
		
		// -------- MÉTODO PARA ATUALIZAR O CADASTRO DO FUNCIONÁRIO
		public Funcionario update (Funcionario obj) {
			
			if(repo.findByLogin(obj.getLogin()).isPresent()) {
				repo.findByLoginLike(obj.getLogin());
				return repo.save(obj);
			}else{
				throw new ObjectNotFoundException(("Login incorreto"));
			}
		}
		
		
		// -------- MÉTODO PARA BUSCAR DE TODOS OS CADASTROS, COM FILTRO DE QUANTIDADES A SEREM EXIBIDAS E ORDENAÇÃO 
		public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			

			return repo.findAll(pageRequest);
		}
		
		// -------- MÉTODO PARA BUSCAR TODOS OS FUNCIONÁRIOS CADASTRADOS
		public List<Funcionario> findAll(){
			return repo.findAll();
		}
		
		
		public Funcionario insert(Funcionario obj) {
			if(repo.findByLogin(obj.getLogin()).isEmpty()) {
				
				obj.setId(null);
				String hashedPassword = passwordEncoder.encode(obj.getSenha());
				obj.setSenha(hashedPassword);
				
				if (obj.getLogin().length() > 30) {
					
					throw new IllegalArgumentException("O login não deve conter mais que 30 caracteres.");
				}
			return repo.save(obj);
			
			}else {
			
				throw new ObjectNotFoundException("Já existe um funcionário cadastrado com esse login!");
			}
			
		}

}
