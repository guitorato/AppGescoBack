package com.gesco.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.domain.Paciente;
import com.gesco.domain.Tratamento;
import com.gesco.services.AntibioticoService;
import com.gesco.services.FuncionarioService;
import com.gesco.services.PacienteService;
import com.gesco.services.TratamentoService;

@RestController
@RequestMapping(value="/tratamentos")
public class TratamentoResource {
	
	@Autowired
	private TratamentoService service;
	
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findId(@PathVariable Integer id){
		
		Tratamento obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
