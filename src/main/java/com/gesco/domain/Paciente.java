package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer registry;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNascimento;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Column(nullable = false)
	@NotEmpty(message = "Informe o sexo do Paciente")
	private String sexo;
	
	@JsonIgnore
	@OneToMany(mappedBy="paciente")
	private List<Tratamento> tratamentos;
	
	public Paciente() {}

	public Paciente(Integer id, Integer registry, String nome, LocalDate dtNascimento, String sexo) {
		super();
		this.id = id;
		this.registry = registry;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegistry() {
		return registry;
	}

	public void setRegistry(Integer registy) {
		this.registry = registy;
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
		result = prime * result + id;
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
		Paciente other = (Paciente) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", registro=" + registry + ", nome=" + nome
				+ ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", tratamentos=" + tratamentos + "]";
	}


	
	
	

}
