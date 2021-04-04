package com.gesco.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
import com.gesco.domain.Prescricao;
import com.gesco.domain.Tratamento;
import com.gesco.dto.AntibioticoDTO;
import com.gesco.dto.FuncionarioDTO;
import com.gesco.dto.PrescricaoDTO;
import com.gesco.dto.TratamentoDTO;
import com.gesco.helpers.Helper;
import com.gesco.repositories.TratamentoRepository;
import com.gesco.services.PrescricaoService;
import com.gesco.services.TratamentoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api/tratamento")
public class TratamentoResource {
	
	@Autowired
	private TratamentoService service;
	
	@Autowired
	private PrescricaoService prescricaoService;
	
	@Autowired
	private TratamentoRepository repo;
	
	@ApiOperation(value = "LISTA TODOS OS TRATAMENTOS S/FILTRO")
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
	
	
	@ApiOperation(value = "BUSCA POR REGISTRO OU NOME DO PACIENTE")
	@RequestMapping(value="/{paciente}" ,method = RequestMethod.GET)
	public ResponseEntity<List<TratamentoDTO>> findRegistro(String paciente){
		if(Helper.isNumber(paciente)) {
			
			Optional<Tratamento> registro = service.findRegistroPaciente(Integer.parseInt(paciente));
			List<TratamentoDTO> listDto = registro.stream().map(obj -> new TratamentoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
			
		}else {
			List<Tratamento> list = service.findNomePaciente(paciente);
			List<TratamentoDTO> listDto = list.stream().map(obj -> new TratamentoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
			
		}
	}

}
