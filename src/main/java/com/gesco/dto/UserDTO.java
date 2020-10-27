package com.gesco.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.gesco.domain.Funcionario;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nameUser;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	private Integer tipoUser;
	
	private Integer hospital;
	
	public UserDTO () {}
	public UserDTO (Funcionario obj) {
		id = obj.getIdFuncionario();
		nameUser = obj.getNameUser();
		senha = obj.getSenha();
		tipoUser = obj.getTipoFuncionario().getCod();
		hospital = obj.getHospital().getId();
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
	public Integer getHospital() {
		return hospital;
	}
	public void setHospital(Integer hospital) {
		this.hospital = hospital;
	}
	
	
}
