package com.gesco.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gesco.domain.Antibiotico;
import com.gesco.dto.AntibioticoDTO;
import com.gesco.helpers.Helper;
import com.gesco.services.AntibioticoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api/antibiotico")
public class AntibioticoResource {
	
	@Autowired
	private AntibioticoService service;
	
	@ApiOperation(value = "INSERIR NOVO ANTIBIOTICO")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Antibiotico obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "ATUALIZA O ANTIBIOTICO, BUSCANDO PELO ID")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Antibiotico obj , @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "DELETA O ANTIBIOTICO, BUSCANDO PELO ID")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "LISTA TODOS OS ANTIBIOTICOS S/FILTRO")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AntibioticoDTO>> findAll(){
		
		List<Antibiotico> list = service.findAll();
		List<AntibioticoDTO> listDto = list.stream().map(obj -> new AntibioticoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "BUSCA PELOS DOIS NOMES DO ANTIBIOTICO OU POR ID")
	@RequestMapping(value="/{param}", method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<List<AntibioticoDTO>> findName(@PathVariable String param ){

		List<Antibiotico> list = null;
		if(Helper.isNumber(param)) {
			list = new ArrayList<Antibiotico>();
			list.add(service.findId(Integer.parseInt(param)));
		}else {
			list = service.findByNome(param.toUpperCase());
		}
		List<AntibioticoDTO> listDTO = list.stream().map(obj -> new AntibioticoDTO(obj)).collect(Collectors.toList());
 		return ResponseEntity.ok().body(listDTO);
	}

}
