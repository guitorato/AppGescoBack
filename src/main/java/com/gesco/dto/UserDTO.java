package com.gesco.dto;

import java.io.Serializable;

import com.gesco.domain.Funcionario;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String senha;
	private Integer tipoUser;
	
	public UserDTO () {}
	public UserDTO (Funcionario obj) {
		user = obj.getNameUser();
		senha = obj.getSenha();
		tipoUser = obj.getTipoFuncionario().getCod();
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(Integer tipoUser) {
		this.tipoUser = tipoUser;
	}
	
	
}
