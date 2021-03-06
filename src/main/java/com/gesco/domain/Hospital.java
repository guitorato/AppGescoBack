package com.gesco.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Hospitais")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nm_hospital",nullable = false , length = 100 )
	@Size(max = 100 , message ="O Tamanho do nome deve ser {max} caracteres")
	@NotBlank(message = "Preencha o campo do nome")
	private String nome;
	
	@Column(name="ds_hospital",nullable = false , length = 100)
	@Size(max = 100 , message ="O Tamanho da descricao deve ser {max} caracteres")
	@NotBlank(message = "Preencha o campo da descricao")
	private String descricao;
	
	@JsonIgnore 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hospital", fetch = FetchType.EAGER)
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public Hospital () {}
	public Hospital(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
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
		Hospital other = (Hospital) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
