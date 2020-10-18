package com.gesco.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gesco.domain.Funcionario;
import com.gesco.dto.UserDTO;
import com.gesco.services.FuncionarioService;

@RestController
@RequestMapping(value="/login")
public class LoginResource {
	

	@Autowired
	private FuncionarioService service;
	
	// -------- GET PROVISÓRIO PARA LOGIN
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findLogin(
			@RequestParam(value = "user", defaultValue = "") String user, 
			@RequestParam(value = "pass", defaultValue = "") String pass){
		
		
		Funcionario obj = service.findLogin(user, pass);
		
		UserDTO objDTO = new UserDTO(obj);
		
		return ResponseEntity.ok().body(objDTO);
	}

}
