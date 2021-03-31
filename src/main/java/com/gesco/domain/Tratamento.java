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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gesco.domain.enums.StatusTratamento;
import com.gesco.domain.enums.TipoFuncionario;

@Entity
@Table(name="Tratamentos")
public class Tratamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ds_diagnostico",nullable = false, length = 255 )
	private String descDiagnostico;
	
	@Column(name="ic_status_paciente",nullable = false)
	private Integer statusTratamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="funcionario_id") 
	private Funcionario funcionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="paciente_id") 
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hospital_id") 
	private Hospital hospital;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tratamento", fetch = FetchType.EAGER)
	private List<Prescricao> prescricoes = new ArrayList<>();
	
	public Tratamento () {}
	public Tratamento(String descDiagnostico, Integer statusTratamento, Funcionario funcionario, Paciente paciente,
			Hospital hospital, List<Prescricao> prescricoes) {
		this.descDiagnostico = descDiagnostico;
		this.statusTratamento = statusTratamento;
		this.funcionario = funcionario;
		this.paciente = paciente;
		this.hospital = hospital;
		this.prescricoes = prescricoes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescDiagnostico() {
		return descDiagnostico;
	}
	public void setDescDiagnostico(String descDiagnostico) {
		this.descDiagnostico = descDiagnostico;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public List<Prescricao> getPrescricoes() {
		return prescricoes;
	}
	public void setPrescricoes(List<Prescricao> prescricoes) {
		this.prescricoes = prescricoes;
	}
	public StatusTratamento getStatusTratamento() {
		return StatusTratamento.toEnum(statusTratamento);
	}

	public void setTipoFuncionario(StatusTratamento statusTratamento) {
		this.statusTratamento = statusTratamento.getCod();
	}
	@Override
	public String toString() {
		return "Tratamento [id=" + id + ", descDiagnostico=" + descDiagnostico + ", statusTratamento="
				+ statusTratamento + ", funcionario=" + funcionario + ", paciente=" + paciente + ", hospital="
				+ hospital + ", prescricoes=" + prescricoes + "]";
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
		Tratamento other = (Tratamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
