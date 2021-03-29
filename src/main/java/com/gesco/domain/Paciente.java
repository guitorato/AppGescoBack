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

@Entity
@Table(name="Pacientes")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nm_paciente",nullable = false , length = 100 )
	private String nome;
	
	@Column(name="cd_registro",nullable = false , unique = true)
	private Integer registro;
	
	@Column(name="dt_paciente",nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	@Column(name="ic_sexo",nullable = false)
	private boolean sexo;
	
	@Column(name="ic_status_paciente",nullable = false)
	private boolean statusPaciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hospital_id") 
	private Hospital hospital;

	public Paciente() {}
	
	public Paciente(String nome, Integer registro, LocalDate dataNascimento, boolean sexo, boolean statusPaciente,
			Hospital hospital) {
		this.nome = nome;
		this.registro = registro;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.statusPaciente = statusPaciente;
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
	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public boolean isStatusPaciente() {
		return statusPaciente;
	}

	public void setStatusPaciente(boolean statusPaciente) {
		this.statusPaciente = statusPaciente;
	}
	
	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", registro=" + registro + ", dataNascimento=" + dataNascimento + ", sexo="
				+ sexo + ", statusPaciente=" + statusPaciente + ", hospital=" + hospital + "]";
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
}
