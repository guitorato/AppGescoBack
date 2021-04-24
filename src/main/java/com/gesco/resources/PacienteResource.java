package com.gesco.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gesco.domain.Paciente;
import com.gesco.dto.PacienteDTO;
import com.gesco.helpers.Helper;
import com.gesco.repositories.PacienteRepository;
import com.gesco.services.PacienteService;
import com.gesco.services.exceptions.NoSuchElementException;
import com.gesco.services.exceptions.ObjectNotFoundException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api/paciente")
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	@Autowired
	private PacienteRepository repo;
	
	@ApiOperation(value = "BUSCA POR NOME DO PACIENTE OU POR REGISTRO, DE PACIENTES INTERNADOS")
	@RequestMapping(value="/{param}", method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<List<PacienteDTO>> findName(@PathVariable String param ){

		List<Paciente> list = Helper.isNumber(param) ? 
				service.findRegistro(Integer.parseInt(param)) : 
					service.findNome(param);
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "LISTAR TODOS OS PACIENTES DE ACORDO COM STATUS INTERNADO(TRUE) E ALTA(FALSE)")
	@RequestMapping(method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<List<PacienteDTO>> findStatusPaciente(@RequestParam boolean status){
		
		List<Paciente> list = service.findStatusTratamento(status);
	    List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "LISTANDO TODOS OS PACIENTES")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> findAll(){
		
		List<Paciente> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
	@ApiOperation(value = "DELETA TODOS OS PACIENTES")
	@RequestMapping(value="/{registro}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer registro){
		
		service.delete(registro);
		return ResponseEntity.noContent().build();
	}
	
	
	@ApiOperation(value = "ATUALIZA TODOS OS PACIENTES")
	@RequestMapping(value="/{registro}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Paciente obj , @PathVariable Integer registro){
		try {
			obj.setId(repo.findByRegistroLike(registro).get().getId());
			obj.setRegistro(registro);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
			
		} catch (NoSuchElementException e) {
			
			throw new ObjectNotFoundException("Registro Incorreto");
		}
	
	}
	
	
	@ApiOperation(value = "INSERE UM PACIENTE")
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> insert(@Valid @RequestBody Paciente obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		return ResponseEntity.created(uri).build();
	}

}
