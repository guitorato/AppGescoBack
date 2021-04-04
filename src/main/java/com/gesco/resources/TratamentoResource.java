package com.gesco.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Tratamento;
import com.gesco.dto.AntibioticoDTO;
import com.gesco.dto.PrescricaoDTO;
import com.gesco.dto.TratamentoDTO;
import com.gesco.services.TratamentoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api/tratamento")
public class TratamentoResource {
	
	@Autowired
	private TratamentoService service;
	
	@ApiOperation(value = "LISTA TODOS OS ANTIBIOTICOS S/FILTRO")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TratamentoDTO>> findAll(){
		
		List<Tratamento> list = service.findAll();
		List<TratamentoDTO> listDto = list.stream().map(obj -> new TratamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "INSERE UM TRATAMENTO")
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> insert(@Valid @RequestBody TratamentoDTO obj) throws Exception {
		
		System.out.println(obj.toString()+"\n");

		service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{nome}").build(obj.getNomePaciente());
		
		return ResponseEntity.created(uri).build();
	}

}
