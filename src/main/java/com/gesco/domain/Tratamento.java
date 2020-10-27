package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Tratamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String diagnostico;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inicio_tratamento;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fim_tratamento;
	
	@Column(nullable = false)
	private double doseDiario;
	
	@Column(nullable = false)
	private String statusTratamento;
	
	@Column(nullable = false)
	private String obs;
	
	
	@ManyToMany
	 @JoinTable(name = "TRATAMENTO_ANTIBIOTICO",
	 joinColumns = @JoinColumn(name = "tratamento_id"),
	 inverseJoinColumns = @JoinColumn(name = "antibiotico_id"))
	private List<Antibiotico> antibioticos = new ArrayList<>();

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="medico_id") 
	private Funcionario funcionario;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="paciente_id") 
	private Paciente paciente;
	
	
	public Tratamento() {}
		


	public Tratamento(Integer id, String diagnostico, LocalDate inicio_tratamento, LocalDate fim_tratamento,
			double doseDiario, String statusTratamento, String obs, Funcionario funcionario, Paciente paciente) {
		this.id = id;
		this.diagnostico = diagnostico;
		this.inicio_tratamento = inicio_tratamento;
		this.fim_tratamento = fim_tratamento;
		this.doseDiario = doseDiario;
		this.statusTratamento = statusTratamento;
		this.obs = obs;
		this.funcionario = funcionario;
		this.paciente = paciente;
	}







	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public LocalDate getInicio_tratamento() {
		return inicio_tratamento;
	}

	public void setInicio_tratamento(LocalDate inicio_tratamento) {
		this.inicio_tratamento = inicio_tratamento;
	}

	public LocalDate getFim_tratamento() {
		return fim_tratamento;
	}

	public void setFim_tratamento(LocalDate fim_tratamento) {
		this.fim_tratamento = fim_tratamento;
	}

	public double getDoseDiario() {
		return doseDiario;
	}

	public void setDoseDiario(double doseDiario) {
		this.doseDiario = doseDiario;
	}

	public String getStatusTratamento() {
		return statusTratamento;
	}

	public void setStatusTratamento(String statusTratamento) {
		this.statusTratamento = statusTratamento;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<Antibiotico> getAntibioticos() {
		return antibioticos;
	}

	public void setAntibioticos(List<Antibiotico> antibioticos) {
		this.antibioticos = antibioticos;
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
		Tratamento other = (Tratamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Tratamento [\nid=" + id + ",\n diagnostico=" + diagnostico + ",\n inicio_tratamento=" + inicio_tratamento
				+ ", \nfim_tratamento=" + fim_tratamento + ",\n doseDiario=" + doseDiario + ", \nstatusTratamento="
				+ statusTratamento + ",\n obs=" + obs + ",\n antibioticos=" + antibioticos + ",\n funcionario=" + funcionario
				+ ",\n paciente=" + paciente + "]";
	}
	
	
	
	
	
	
	
}
