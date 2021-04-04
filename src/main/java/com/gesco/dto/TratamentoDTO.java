package com.gesco.dto;

import java.util.List;

import com.gesco.domain.Prescricao;
import com.gesco.domain.Tratamento;

public class TratamentoDTO {
	
	private String descDiagnostico;
	private Integer registroPaciente;
	private String nomePaciente;
	private List<Prescricao> prescricoes;
	private String loginFucnionario;
	private String funcionario;
	private String hospital;
	
	public TratamentoDTO() {}
	public TratamentoDTO(Tratamento obj) {
		this.descDiagnostico = obj.getDescDiagnostico();
		this.registroPaciente = obj.getPaciente().getRegistro();
		this.nomePaciente = obj.getPaciente().getNome();
		this.prescricoes = obj.getPrescricoes();
		this.loginFucnionario = obj.getFuncionario().getLogin();
		this.funcionario = obj.getFuncionario().getNome();
		this.hospital = obj.getHospital().getNome();
	}
	
	
	public String getLoginFucnionario() {
		return loginFucnionario;
	}
	public void setLoginFucnionario(String loginFucnionario) {
		this.loginFucnionario = loginFucnionario;
	}
	public String getDescDiagnostico() {
		return descDiagnostico;
	}

	public void setDescDiagnostico(String descDiagnostico) {
		this.descDiagnostico = descDiagnostico;
	}

	public Integer getRegistroPaciente() {
		return registroPaciente;
	}

	public void setRegistroPaciente(Integer registroPaciente) {
		this.registroPaciente = registroPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public List<Prescricao> getPrescricoes() {
		return prescricoes;
	}

	public void setPrescricoes(List<Prescricao> prescricoes) {
		this.prescricoes = prescricoes;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	
	
	

}
