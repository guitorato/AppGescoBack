package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private int cd_paciente;
	
	@Column(nullable = false)
	@NotEmpty(message = "Preenchimento do Nome do Paciente Obrigatório")
	private String nome;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNascimento;
	
	@Column(nullable = false)
	@NotEmpty(message = "Informe o sexo do Paciente")
	private String sexo;
	
	@JsonIgnore
	@OneToMany(mappedBy="paciente")
	private List<Tratamento> tratamentos;
	
	public Paciente() {}

	public Paciente(Integer id, int cd_paciente, String nome, LocalDate dtNascimento, String sexo) {
		super();
		this.id = id;
		this.cd_paciente = cd_paciente;
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

	public int getCd_paciente() {
		return cd_paciente;
	}

	public void setCd_paciente(int cd_paciente) {
		this.cd_paciente = cd_paciente;
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
		return "Paciente [id=" + id + ", cd_paciente=" + cd_paciente + ", nome=" + nome
				+ ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", tratamentos=" + tratamentos + "]";
	}
	
	
	

}
