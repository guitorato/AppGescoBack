package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Antibiotico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String lote;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validade;
	
	@Column(nullable = false)
	private Double dosagem;
	
	@Column(nullable = false)
	private String aplicacao;
	
	
	@ManyToOne
	@JoinColumn(name="farmaceutico_id")
	private Funcionario funcionario;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "antibioticos")
	private List<Tratamento> tratamentos = new ArrayList<>();
	
	public Antibiotico() {}
	
	
	public Antibiotico(Integer id, String nome, String lote, LocalDate validade, Double dosagem, String aplicacao,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.nome = nome.toUpperCase();
		this.lote = lote;
		this.validade = validade;
		this.dosagem = dosagem;
		this.aplicacao = aplicacao;
		this.funcionario = funcionario;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome.toUpperCase();
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
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
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}
	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
