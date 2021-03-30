package com.gesco.dto;

import java.time.LocalDate;

import com.gesco.domain.Antibiotico;

public class AntibioticoDTO {
	
	private Integer id;
	private String nome;
	private String nomeComercial;
	private LocalDate dataValidade;
	private String lote;
	private String tipoAplicacao;
	private String funcionario;
	
	public AntibioticoDTO() {}
	public AntibioticoDTO(Antibiotico obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.nomeComercial = obj.getNomeComercial();
		this.dataValidade = obj.getDataValidade();
		this.lote = obj.getLote();
		this.tipoAplicacao = obj.getTipoAplicacao().getDescricao();
		this.funcionario = obj.getFuncionario().getNome();
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

	public String getNomeComercial() {
		return nomeComercial;
	}

	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getTipoAplicacao() {
		return tipoAplicacao;
	}

	public void setTipoAplicacao(String tipoAplicacao) {
		this.tipoAplicacao = tipoAplicacao;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}
