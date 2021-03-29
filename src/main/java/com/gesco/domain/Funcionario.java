package com.gesco.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gesco.domain.enums.TipoFuncionario;

@Entity
@Table(name="Funcionarios")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nm_funcionario",nullable = false , length = 100 )
	private String nome;
	
	@Column(name="nm_login",nullable = false , length = 30, unique = true )
	private String login;
	
	@Column(name="ds_senha",nullable = false)
	private String senha;
	
	@Column(name="cd_conselho",nullable = true , length = 10 )
	private Integer conselho;
	
	@Column(name="cd_tipo_funcionario",nullable = false)
	private Integer tipoFuncionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hospital_id") 
	private Hospital hospital;
	
	public Funcionario() {}
	public Funcionario(String nome, String login, String senha, Integer conselho, Integer tipoFuncionario,
			Hospital hospital) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.conselho = conselho;
		this.tipoFuncionario = tipoFuncionario;
		this.hospital = hospital;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public TipoFuncionario getTipoFuncionario() {
		return TipoFuncionario.toEnum(tipoFuncionario);
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario.getCod();
	}
	public Hospital getHospial() {
		return hospital;
	}
	public void setHospial(Hospital hospial) {
		this.hospital = hospial;
	}
	
	

}
