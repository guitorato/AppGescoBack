package com.gesco.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Tratamento;
import com.gesco.services.AntibioticoService;

public class TratamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nm_paciente;
	private String diagnostico;
	private LocalDate inicio_tratamento;
	private LocalDate fim_tratamento;
	private double doseDiario;
	private String statusTratamento;
	private String medico;
	private String obs;
	private List<Antibiotico> antibioticos = new ArrayList<>();
	
	public TratamentoDTO () {}
	public TratamentoDTO (Tratamento obj ) {
		id = obj.getId();
		nm_paciente = obj.getPaciente().getNome();
		diagnostico = obj.getDiagnostico();
		inicio_tratamento = obj.getInicio_tratamento();
		fim_tratamento = obj.getFim_tratamento();
		doseDiario = obj.getDoseDiario();
		statusTratamento = obj.getStatusTratamento();
		obs = obj.getObs();
		medico = obj.getFuncionario().getNome();
		antibioticos = obj.getAntibioticos();
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNm_paciente() {
		return nm_paciente;
	}
	public void setNm_paciente(String nm_paciente) {
		this.nm_paciente = nm_paciente;
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
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}

	
}
