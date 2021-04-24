package com.gesco.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gesco.dto.LoginDTO;
import com.gesco.dto.SessaoDTO;
import com.gesco.services.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/login")
public class LoginResource {
	
	@Autowired
	private LoginService loginService;
	
	
	@ApiOperation(value = "API PARA LOGIN DO USUÁRIO")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public SessaoDTO loginUsuario(@Valid @RequestBody LoginDTO loginDto) throws Exception {
		 
		return loginService.validarLogin(loginDto);
	}

}
