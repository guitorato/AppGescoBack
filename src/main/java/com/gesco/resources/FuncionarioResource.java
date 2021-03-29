package com.gesco.resources;

import java.net.URI;
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
import com.gesco.dto.FuncionarioDTO;
import com.gesco.services.FuncionarioService;

@RestController
@RequestMapping(value="api/funcionario")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;


	// -------- MÉTODO DE DELETAR O CADASTRO DO FUNCIONÁRIO
		@RequestMapping(value="/{login}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable String login){
			
			service.delete(login);
			return ResponseEntity.noContent().build();
		}
		
		
		// -------- MÉTODO PUT PARA ATUALIZAR O CADASTRO DO FUNCIONÁRIO
		@RequestMapping(value="/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Funcionario obj , @PathVariable Integer id){
			obj.setId(id);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
		}
		
		
		// -------- MÉTODO DE LISTAR TODOS OS FUNCIONÁRIOS, FAZ A MESMA COISA DE O findAll SÓ QUE ESSE É FILTRADO
		@RequestMapping(value="/page", method = RequestMethod.GET)
		public ResponseEntity<Page<FuncionarioDTO>> findPage(
				@RequestParam(value = "page", defaultValue = "0") Integer page, 
				@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
				@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
				@RequestParam(value = "direction", defaultValue = "ASC") String direction){
			
			Page<Funcionario> list = service.findPage(page,linesPerPage,orderBy,direction);
			Page<FuncionarioDTO> listDto = list.map(obj -> new FuncionarioDTO(obj));
			
			return ResponseEntity.ok().body(listDto);
		}
		
		// -------- MÉTODO DE LISTAR OS FUNCIONÁRIO, UTILIZEI UMA CLASSE DTO PARA FILTRAS AS INFORMAÇÕES PELO JSON
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<FuncionarioDTO>> findAll(){
			
			List<Funcionario> list = service.findAll();
			List<FuncionarioDTO> listDto = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}
		
		// -------- MÉTODO POST PARA CADASTRAR O FUNCIONÁRIO
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody Funcionario obj){
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").build(obj.getId());
			return ResponseEntity.created(uri).build();
		}
}
