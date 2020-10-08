package com.gesco.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.gesco.domain.Funcionario;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idFuncionario;
	private String nome;
	private LocalDate dtNascimento;
	private String sexo;
	private String nameUser;
	private String senha;
	private String crmOuCrf;
	private String tipoFuncionario;
	private String hospital;
	
	public FuncionarioDTO() {}
	public FuncionarioDTO (Funcionario obj) {
		idFuncionario = obj.getIdFuncionario();
		nome = obj.getNome();
		dtNascimento = obj.getDtNascimento();
		sexo = obj.getSexo();
		nameUser = obj.getNameUser();
		senha = obj.getSenha();
		crmOuCrf = obj.getCrmOuCrf();
		tipoFuncionario = obj.getTipoFuncionario().getDescricao();
		hospital = obj.getHospital().getNome();
		
	}
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public String getCrmOuCrf() {
		return crmOuCrf;
	}
	public void setCrmOuCrf(String crmOuCrf) {
		this.crmOuCrf = crmOuCrf;
	}
	public String getTipoFuncionario() {
		return tipoFuncionario;
	}
	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	
	
	
	
}
