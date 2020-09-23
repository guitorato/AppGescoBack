package com.gesco.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="idFuncionario")
public class Internacao extends Funcionario {
	private static final long serialVersionUID = 1L;
	

}
