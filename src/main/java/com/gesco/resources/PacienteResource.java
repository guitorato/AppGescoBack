package com.gesco.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
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
import com.gesco.helpers.Helper;
import com.gesco.services.AntibioticoService;
import com.gesco.services.FuncionarioService;
import com.gesco.services.PacienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	
	@ApiOperation(value = "BUSCAR POR ID DO PACIENTE")
	@RequestMapping(value="/buscar/{id}", method = RequestMethod.GET , produces="application/json")
	public ResponseEntity<Paciente> findId(@PathVariable("id") Integer id){
		
		
		Paciente obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "INSERE UM PACIENTE")
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> insert(@Valid @RequestBody Paciente obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "ATUALIZA TODOS OS PACIENTES")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Paciente obj , @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "DELETA TODOS OS PACIENTES")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "LISTAR TODOS OS PACIENTES S/ FILTRO")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> findAll(){
		
		List<Paciente> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "LISTAR TODOS OS PACIENTES C/ FILTRO (Nº DE LINHAS / PAGINAÇÃO, QUE ORDEM UTILIZARÁ, E DIREÇÃO")
	@RequestMapping(value="/page", method = RequestMethod.GET , produces="application/json")
	public ResponseEntity<Page<Paciente>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction){
		
		Page<Paciente> list = service.findPage(page,linesPerPage,orderBy,direction);
		
		return ResponseEntity.ok().body(list);
	}
	
	
	@ApiOperation(value = "BUSCA POR NOME DO PACIENTE OU POR REGISTRO")
	@RequestMapping(value="/{param}", method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<List<Paciente>> findName(@PathVariable String param ){

		List<Paciente> list = null;
		list = Helper.isNumber(param) ? service.findRegistry(Integer.parseInt(param)) : service.findName(param);
		
		return ResponseEntity.ok().body(list);
	}
		

	
	
//	
}
	

