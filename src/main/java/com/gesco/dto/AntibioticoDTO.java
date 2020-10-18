package com.gesco.dto;

import java.io.Serializable;
import java.time.LocalDate;


import com.gesco.domain.Antibiotico;


public class AntibioticoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;
	private String lote;
	private LocalDate validade;
	private Double dosagem;
	private String aplicacao;
	private String funcionario;
	
	public AntibioticoDTO () {}
	
	public AntibioticoDTO (Antibiotico obj) {
		id = obj.getId();
		nome = obj.getNome();
		lote = obj.getLote();
		validade = obj.getValidade();
		dosagem = obj.getDosagem();
		aplicacao = obj.getAplicacao();
		//funcionario = obj.getFuncionario().getNome();
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

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Double getDosagem() {
		return dosagem;
	}

	public void setDosagem(Double dosagem) {
		this.dosagem = dosagem;
	}

	public String getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
}
