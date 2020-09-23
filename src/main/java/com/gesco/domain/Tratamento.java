package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
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
	
	@ManyToOne
	@JoinColumn(name="antibiotico_id") 
	private Antibiotico antibiotico;
	
	@ManyToOne
	@JoinColumn(name="farmacia_id") 
	private Farmacia farmacia;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id") 
	private Medico medico;
	
	@ManyToOne
	private Farmaceutico farmaceutico;
	
	@ManyToOne
	@JoinColumn(name="paciente_id") 
	private Paciente paciente;

	public Tratamento() {}
	
	
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
