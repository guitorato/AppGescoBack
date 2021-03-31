package com.gesco.dto;

import java.util.List;

import com.gesco.domain.Prescricao;
import com.gesco.domain.Tratamento;

public class TratamentoDTO {
	
	private String descDiagnostico;
	private Integer registroPaciente;
	private String nomePaciente;
	private List<Prescricao> prescricoes;
	private String statusTratamento;
	private String funcionario;
	
	public TratamentoDTO() {}
	public TratamentoDTO(Tratamento obj) {
		this.descDiagnostico = obj.getDescDiagnostico();
		this.registroPaciente = obj.getPaciente().getRegistro();
		this.nomePaciente = obj.getPaciente().getNome();
		this.prescricoes = obj.getPrescricoes();
		this.statusTratamento = obj.getStatusTratamento().getDescricao();
		this.funcionario = obj.getFuncionario().getNome();
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

	public String getStatusTratamento() {
		return statusTratamento;
	}

	public void setStatusTratamento(String statusTratamento) {
		this.statusTratamento = statusTratamento;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	
	

}
