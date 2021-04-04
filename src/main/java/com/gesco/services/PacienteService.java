package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gesco.domain.Paciente;
import com.gesco.helpers.Helper;
import com.gesco.repositories.PacienteRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.NoSuchElementException;
import com.gesco.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	
	// -------- Método de exibir a lista com todos os pacientes
	public List<Paciente> findAll(){
		return repo.findAll();
	}
	
	// -------- Método de busca por nome dos Pacientes INTERNADOS (true)
		public List<Paciente> findNome(String nome){
			List<Paciente> list = null;
			
			
			if(repo.findByNome(nome).isEmpty()) {
				
					
					throw new ObjectNotFoundException(("Paciente Não Encontrado"));
				
				
			}else {
				
					return list = repo.findByNome(nome);
			}
	}
		
		
	// -------- Método de busca por Registro dos Pacientes INTERNADOS (true)
			public List<Paciente> findRegistro(Integer registro){
					
				if(repo.findByRegistro(registro).isEmpty()) {
						
							
						throw new ObjectNotFoundException(("Paciente Não Encontrado"));
						
						
				}else {
						
						return repo.findByRegistro(registro);
				}
		}	
	
		

	// -------- Método de exibir a lista de pacientes por status True = Internado e False = Alta
		public List<Paciente> findStatusTratamento(boolean status){
			return repo.findByStatusPaciente(status);
			
		}
	
	
			
	
	// -------- MÉTODO PARA DELETAR PACIENTE
		public void delete (Integer registro) {
			if(repo.findByRegistroLike(registro).isEmpty()) {
				
				throw new ObjectNotFoundException("Registro de Paciente não encontrado");
			}else {
				
               try {
					
					repo.delete(repo.findByRegistroLike(registro).get());
				}catch (DataIntegrityViolationException e) {
					throw new DataIntegrityException("Não é possível excluir");
				}
			}
			
		}
		
		// -------- MÉTODO PARA ATUALIZAR PACIENTE
		public Paciente update (Paciente obj) {
			
			
			if(repo.findByRegistro(obj.getRegistro()).isEmpty()){
				
				throw new ObjectNotFoundException(("Registro incorreto"));
			}else{
				
				return repo.save(obj);
			}
		}
			
		
		// -------- MÉTODO PARA CADASTRAR PACIENTE
		public Paciente insert(Paciente obj) {
			
			if(repo.findByRegistro(obj.getRegistro()).isEmpty()) {
				
				obj.setId(null);
				obj.setNome(obj.getNome().toUpperCase());
				obj.setStatusPaciente(true);
				return repo.save(obj);
				
			}else {
				throw new ObjectNotFoundException(("Já Existe um paciente cadastrado com esse Registro"));
			}
		}

}
