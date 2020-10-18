package com.gesco.dto;

import java.io.Serializable;

import com.gesco.domain.Funcionario;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nameUser;
	private String senha;
	private Integer tipoUser;
	
	public UserDTO () {}
	public UserDTO (Funcionario obj) {
		id = obj.getIdFuncionario();
		nameUser = obj.getNameUser();
		senha = obj.getSenha();
		tipoUser = obj.getTipoFuncionario().getCod();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
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
