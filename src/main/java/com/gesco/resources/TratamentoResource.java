package com.gesco.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.gesco.domain.Funcionario;
import com.gesco.domain.Tratamento;
import com.gesco.dto.FuncionarioDTO;
import com.gesco.dto.TratamentoDTO;
import com.gesco.helpers.Helper;
import com.gesco.services.TratamentoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/tratamentos")
public class TratamentoResource {
	
	@Autowired
	private TratamentoService service;
	
	
	@ApiOperation(value = "BUSCAR TRATAMENTO POR ID")
	@RequestMapping(value="/buscar/{id}", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<TratamentoDTO> findId(@PathVariable Integer id){
		
		Tratamento obj = service.find(id);
		TratamentoDTO objDTO = new TratamentoDTO(obj);
		
		return ResponseEntity.ok().body(objDTO);
	}
	
	@ApiOperation(value = "INSERIR UM NOVO TRATAMENTO")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Tratamento obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "ATUALIZAR TRATAMENTO")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Tratamento obj , @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "DELETAR UM TRATAMENTO")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "LISTAR TODOS OS TRATAMENTOS S/ FILTRO")
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<TratamentoDTO>> findAll(){
		
		List<Tratamento> list = service.findAll();
		List<TratamentoDTO> listDto = list.stream().map(obj -> new TratamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "LISTAR TODOS OS TRATAMENTOS C/ FILTRO (Nº DE LINHAS / PAGINAÇÃO, QUE ORDEM UTILIZARÁ, E DIREÇÃO")
	@RequestMapping(value="/page", method = RequestMethod.GET , produces="application/json")
	public ResponseEntity<Page<TratamentoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction){
		
		Page<Tratamento> list = service.findPage(page,linesPerPage,orderBy,direction);
		Page<TratamentoDTO> listDto = list.map(obj -> new TratamentoDTO(obj));
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "BUSCAR PACIENTE POR NOME E REGISTRO")
	@RequestMapping(value="/{param}" ,method = RequestMethod.GET)
	public ResponseEntity<List<TratamentoDTO>> findPaciente(@PathVariable String param){
		
		List<Tratamento> list = null;
		if(Helper.isNumber(param)) {
			list = new ArrayList<Tratamento>();
			list.addAll(service.findRegistry(Integer.parseInt(param)));
		}else {
			list = service.findName(param);
		}
		List<TratamentoDTO> listDTO = list.stream().map(obj -> new TratamentoDTO(obj)).collect(Collectors.toList());
 		return ResponseEntity.ok().body(listDTO);
	}
	
	@ApiOperation(value = "BUSCAR TRATAMENTO POR Status")
	@RequestMapping(value="/{status}", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<TratamentoDTO>> findStatus(@PathVariable Integer status){
		
		List<Tratamento> list = service.findStatus(status);
		List<TratamentoDTO> listDTO = list.stream().map(obj -> new TratamentoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
}
