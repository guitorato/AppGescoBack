package com.gesco.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gesco.domain.Hospital;
import com.gesco.services.HospitalService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api/hospital")
public class HospitalResource {
	
	@Autowired
	private HospitalService service;
	
	
	@ApiOperation(value = "BUSCANDO POR ID DO HOSPITAL")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hospital> findId(@PathVariable Integer id){
		
		Hospital obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "INSERINDO UM NOVO HOSPITAL")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Hospital obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "ATUALIZANDO UM HOSPITAL PELO ID")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Hospital obj , @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "DELETANDO UM HOSPITAL PELO ID")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "LISTANDO TODOS OS HOSPITAIS")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Hospital>> findAll(){
		
		List<Hospital> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
