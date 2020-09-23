package com.gesco.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="idFuncionario")
public class Medico extends Funcionario {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private int crm;
	
	@OneToMany(mappedBy="medico")
	private List<Tratamento> tratamentos;
	

}
