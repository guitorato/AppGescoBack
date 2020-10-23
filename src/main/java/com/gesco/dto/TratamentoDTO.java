package com.gesco.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.gesco.domain.Tratamento;

public class TratamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String paciente;
	private String diagnostico;
	private LocalDate inicio_tratamento;
	private LocalDate fim_tratamento;
	private double doseDiario;
	private String statusTratamento;
	private String medico;
	private String obs;
	private List<?> antibioticos;
	
	public TratamentoDTO () {}
	public TratamentoDTO (Tratamento obj) {
		id = obj.getId();
		paciente = obj.getPaciente().getNome();
		diagnostico = obj.getDiagnostico();
		inicio_tratamento = obj.getInicio_tratamento();
		fim_tratamento = obj.getFim_tratamento();
		doseDiario = obj.getDoseDiario();
		statusTratamento = obj.getStatusTratamento();
		obs = obj.getObs();
		medico = obj.getFuncionario().getNome();
		antibioticos = ((TratamentoDTO) getAtbId(obj)).getAtbNomes(obj);
		
	}
	
	private List<String> getAtbNomes(Tratamento obj){
		return obj.getAntibioticos().stream().map(atb -> atb.getNome()).collect(Collectors.toList());
	}
	
	private List<Integer> getAtbId(Tratamento obj){
		return obj.getAntibioticos().stream().map(atb -> atb.getId()).collect(Collectors.toList());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
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
	public List<?> getAntibioticos() {
		return antibioticos;
	}
	public void setAntibioticos(List<?> antibioticos) {
		
		this.antibioticos = antibioticos;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}

	
}
