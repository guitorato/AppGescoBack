package com.gesco.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.domain.Paciente;
import com.gesco.services.AntibioticoService;
import com.gesco.services.FuncionarioService;
import com.gesco.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	
	// -------- MÉTODO PARA BUSCAR POR ID DO PACIENTE
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> findId(@PathVariable Integer id){
		
		Paciente obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	// -------- MÉTODO PARA CADASTRAR O PACIENTE
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Paciente obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		return ResponseEntity.created(uri).build();
	}
	
	// -------- MÉTODO PARA ATUALIZAR O PACIENTE
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Paciente obj , @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	// -------- MÉTODO DELETAR O PACIENTE
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> findAll(){
		
		List<Paciente> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	// -------- MÉTODO PARA LISTAR TODOS OS PACIENTES C/ FILTRO (PAGINAÇÃO,QNT DE DADOS A SEREM EXIBIDAS, ETC)
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Paciente>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction){
		
		Page<Paciente> list = service.findPage(page,linesPerPage,orderBy,direction);
		
		return ResponseEntity.ok().body(list);
	}
	
	
	// -------- MÉTODO PARA BUSCAR O REGISTRO MAIS O NOME DO PACIENTE
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	public ResponseEntity<List<Paciente>> findNameRegistry(
			@RequestParam(required = false, defaultValue = "0") Long registry, 
			@RequestParam(required = false, defaultValue = "") String nome ){
		
		List<Paciente> obj = service.findNameRegistry(nome, registry);
		

		return ResponseEntity.ok().body(obj);
	}
	
}
