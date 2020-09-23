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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaciente;
	
	@Column(nullable = false)
	private int cd_paciente;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNascimento;
	
	@Column(nullable = false)
	private Boolean sexo;
	
	@OneToMany(mappedBy="paciente")
	private List<Tratamento> tratamentos;

}
