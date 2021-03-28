package com.gesco.dto;

import java.io.Serializable;

import com.gesco.domain.Funcionario;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String login;
	private String senha;
	private Integer conselho;
	private Integer tipoFuncionario;
	
	public FuncionarioDTO() {}
	public FuncionarioDTO(Funcionario obj) {
		nome = obj.getNome();
		login = obj.getLogin();
		senha = obj.getSenha();
		conselho = obj.getConselho();
		tipoFuncionario = obj.getTipoFuncionario().getCod();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public Integer getConselho() {
		return conselho;
	}
	public void setConselho(Integer conselho) {
		this.conselho = conselho;
	}
	public Integer getTipoFuncionario() {
		return tipoFuncionario;
	}
	public void setTipoFuncionario(Integer tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	
	

}
