package com.gesco.domain;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gesco.domain.enums.TipoAplicacao;
import com.gesco.domain.enums.TipoFuncionario;

@Entity
@Table(name="Antibioticos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Antibiotico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nm_antibiotico",nullable = false , length = 100 )
	private String nome;
	
	@Column(name="nm_comercial",nullable = false , length = 100 )
	private String nomeComercial;
	
	@Column(name="dt_validade",nullable = false , length = 100 )
	private LocalDate dataValidade;
	
	@Column(name="cd_lote",nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String lote;
	
	@Column(name="cd_tipo_aplicacao",nullable = false)
	private Integer tipoAplicacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="funcionario_id") 
	private Funcionario funcionario;
	
	public Antibiotico () {}
	public Antibiotico(String nome, String nomeComercial, LocalDate dataValidade, String lote, Integer tipoAplicacao,
			Funcionario funcionario) {
		this.nome = nome;
		this.nomeComercial = nomeComercial;
		this.dataValidade = dataValidade;
		this.lote = lote;
		this.tipoAplicacao = tipoAplicacao;
		this.funcionario = funcionario;
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
	public TipoAplicacao getTipoAplicacao() {
		return TipoAplicacao.toEnum(tipoAplicacao);
	}

	public void setTipoAplicacao(TipoAplicacao tipoAplicacao) {
		this.tipoAplicacao = tipoAplicacao.getCod();
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	@Override
	public String toString() {
		return "Antibiotico [id=" + id + ", nome=" + nome + ", nomeComercial=" + nomeComercial + ", dataValidade="
				+ dataValidade + ", lote=" + lote + ", TipoAplicacao=" + tipoAplicacao + ", funcionario=" + funcionario
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Antibiotico other = (Antibiotico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
