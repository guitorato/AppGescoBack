package com.gesco.dto;

import java.time.LocalDate;

import com.gesco.domain.Prescricao;

public class PrescricaoDTO {
	
	private Integer idAntibiotico;
	private String nomeAntibiotico;
	private String nomeComercialAntibiotico;
	private String descPrescricao;
	private LocalDate inicioTratamento;
	private Integer diasTratamento;
	private LocalDate fimTratamento;
	private Double dosagemDiaria;
	private Integer periodiociadade;
	private String statusTratamento;
	private String descStatusTratamento;
	
	public PrescricaoDTO() {}
	public PrescricaoDTO(Prescricao obj) {
		this.idAntibiotico = obj.getAntibiotico().getId();
		this.nomeAntibiotico = obj.getAntibiotico().getNome();
		this.nomeComercialAntibiotico = obj.getAntibiotico().getNomeComercial();
		this.descPrescricao = obj.getDescPrescricao();
		this.inicioTratamento = obj.getInicioTratamento();
		this.diasTratamento = diasTratamento;
		this.fimTratamento = obj.getFimTratamento();
		this.dosagemDiaria = obj.getDosagemDiaria();
		this.periodiociadade = obj.getPeriodiociadade();
		this.statusTratamento = obj.getStatusTratamento().getDescricao();
		this.descStatusTratamento = obj.getDescStatusTratamento();
	}
	
	public Integer getIdAntibiotico() {
		return idAntibiotico;
	}
	public void setIdAntibiotico(Integer idAntibiotico) {
		this.idAntibiotico = idAntibiotico;
	}
	public String getNomeAntibiotico() {
		return nomeAntibiotico;
	}
	public void setNomeAntibiotico(String nomeAntibiotico) {
		this.nomeAntibiotico = nomeAntibiotico;
	}
	public String getNomeComercialAntibiotico() {
		return nomeComercialAntibiotico;
	}
	public void setNomeComercialAntibiotico(String nomeComercialAntibiotico) {
		this.nomeComercialAntibiotico = nomeComercialAntibiotico;
	}
	public String getDescPrescricao() {
		return descPrescricao;
	}
	public void setDescPrescricao(String descPrescricao) {
		this.descPrescricao = descPrescricao;
	}
	public LocalDate getInicioTratamento() {
		return inicioTratamento;
	}
	public void setInicioTratamento(LocalDate inicioTratamento) {
		this.inicioTratamento = inicioTratamento;
	}
	public Integer getDiasTratamento() {
		return diasTratamento;
	}
	public void setDiasTratamento(Integer diasTratamento) {
		this.diasTratamento = diasTratamento;
	}
	public LocalDate getFimTratamento() {
		return fimTratamento;
	}
	public void setFimTratamento(LocalDate fimTratamento) {
		this.fimTratamento = fimTratamento;
	}
	public Double getDosagemDiaria() {
		return dosagemDiaria;
	}
	public void setDosagemDiaria(Double dosagemDiaria) {
		this.dosagemDiaria = dosagemDiaria;
	}
	public Integer getPeriodiociadade() {
		return periodiociadade;
	}
	public void setPeriodiociadade(Integer periodiociadade) {
		this.periodiociadade = periodiociadade;
	}
	public String getStatusTratamento() {
		return statusTratamento;
	}
	public void setStatusTratamento(String statusTratamento) {
		this.statusTratamento = statusTratamento;
	}
	public String getDescStatusTratamento() {
		return descStatusTratamento;
	}
	public void setDescStatusTratamento(String descStatusTratamento) {
		this.descStatusTratamento = descStatusTratamento;
	}
	@Override
	public String toString() {
		return "PrescricaoDTO [idAntibiotico=" + idAntibiotico + ", nomeAntibiotico=" + nomeAntibiotico
				+ ", nomeComercialAntibiotico=" + nomeComercialAntibiotico + ", descPrescricao=" + descPrescricao
				+ ", inicioTratamento=" + inicioTratamento + ", diasTratamento=" + diasTratamento + ", fimTratamento="
				+ fimTratamento + ", dosagemDiaria=" + dosagemDiaria + ", periodiociadade=" + periodiociadade
				+ ", statusTratamento=" + statusTratamento + ", descStatusTratamento=" + descStatusTratamento + "]";
	}
	
	

}
