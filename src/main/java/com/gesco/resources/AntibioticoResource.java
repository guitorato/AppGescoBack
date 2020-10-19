package com.gesco.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gesco.domain.Antibiotico;
import com.gesco.dto.AntibioticoDTO;
import com.gesco.services.AntibioticoService;

@RestController
@RequestMapping(value="/antibioticos")
public class AntibioticoResource {
	
	@Autowired
	private AntibioticoService service;
	
	
	//GET POR ID DO ATB
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Antibiotico> findId(@PathVariable Integer id){
		
		Antibiotico obj = service.findId(id);
	
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Antibiotico obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Antibiotico obj , @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AntibioticoDTO>> findAll(){
		
		List<Antibiotico> list = service.findAll();
		List<AntibioticoDTO> listDto = list.stream().map(obj -> new AntibioticoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(value ="/buscar" ,method = RequestMethod.GET)
	public ResponseEntity<List<AntibioticoDTO>> findName(
			@RequestParam(value = "nome", defaultValue = "") String nome){
		
		List<Antibiotico> list = service.findByNome(nome);
		List<AntibioticoDTO> listDTO =  list.stream().map(obj -> new AntibioticoDTO(obj)).collect(Collectors.toList());
	
		return ResponseEntity.ok().body(listDTO);
	}
	
	
}
