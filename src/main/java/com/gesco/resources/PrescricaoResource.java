package com.gesco.resources;

import java.net.URI;
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

import com.gesco.domain.Prescricao;
import com.gesco.dto.PrescricaoDTO;
import com.gesco.dto.StatusTratamentoDTO;
import com.gesco.services.PrescricaoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api/prescricao")
public class PrescricaoResource {
	
	@Autowired
	private PrescricaoService service;
	
	@ApiOperation(value = "DELETA A PRESCRIÇÃO, BUSCANDO PELO ID")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "LISTANDO TODAS AS PRESCRIÇÕES")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PrescricaoDTO>> findAll(){
		
		List<Prescricao> list = service.findAll();
		List<PrescricaoDTO> listDto = list.stream().map(obj -> new PrescricaoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "INSERE UMA PRESCRICAO")
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> insert(@Valid @RequestBody PrescricaoDTO obj) throws Exception {
		

		
		
		System.out.println(obj.toString()+"\n");

		service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getStatusTratamento());
		
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "ATUALIZAR O STATUS DO TRATAMENTO DA PRESCRICAO")
	@RequestMapping(value="/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Void> update(@RequestBody StatusTratamentoDTO dto , @PathVariable Integer id){
		
		service.updateStatusTratamento(id, dto);
		
		return ResponseEntity.noContent().build();
	}
	
	

}
