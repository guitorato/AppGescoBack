package com.gesco.dto;

import java.time.LocalDate;

import com.gesco.domain.Paciente;

public class PacienteDTO {
	
	private Integer registro;
	private String nome;
	private boolean sexo;
	private LocalDate dataNascimento;
	private String hospital;
	private boolean statusPaciente;
	
	public PacienteDTO() {}
	public PacienteDTO(Paciente obj) {
		
		this.registro = obj.getRegistro();
		this.nome = obj.getNome();
		this.sexo = obj.isSexo();
		this.dataNascimento = obj.getDataNascimento();
		this.hospital = obj.getHospital().getNome();
		this.statusPaciente = obj.isStatusPaciente();
		
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public boolean isStatusPaciente() {
		return statusPaciente;
	}

	public void setStatusPaciente(boolean statusPaciente) {
		this.statusPaciente = statusPaciente;
	}
	
	
	
	

}
