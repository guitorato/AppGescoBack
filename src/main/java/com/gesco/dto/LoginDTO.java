package com.gesco.dto;

import javax.validation.constraints.NotEmpty;

import com.gesco.domain.Funcionario;

import io.swagger.annotations.ApiModelProperty;

public class LoginDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	@ApiModelProperty(value = "Login (Usuario) no sistema (cpf, telefone, apelido)", example = "masteruser")
	private String login;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@ApiModelProperty(value = "Senha do usuario", example = "senh@Fort#")
	private String senha;
	
	public LoginDTO() {
	}
	
	public LoginDTO(Funcionario obj) {
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
