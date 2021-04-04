package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gesco.domain.enums.StatusTratamento;

@Entity
@Table(name="Prescricoes")
public class Prescricao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ds_prescricao", nullable = true, length = 255)
	private String descPrescricao;
	
	@Column(name="cd_status_tratamento",nullable = false)
	private Integer statusTratamento;
	
	@Column(name="ds_descricao_status",nullable = true , length = 100 )
	private String descStatusTratamento;
	
	@Column(name="dt_inicio_tratamento",nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inicioTratamento;
	
	@Column(name="dt_fim_tratamento",nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fimTratamento;
	
	@Column(name="vl_dosagem_diaria",nullable = false , length = 4)
	private Double dosagemDiaria;
	
	@Column(name="cd_periodiociadade",nullable = false, length = 2)
	private Integer periodiociadade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="antibiotico_id") 
	private Antibiotico antibiotico;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tratamento_id") 
	private Tratamento tratamento;
	
	public Prescricao() {}

	public Prescricao(String descPrescricao, Integer statusTratamento, String descStatusTratamento,
			LocalDate inicioTratamento, LocalDate fimTratamento, Double dosagemDiaria, Integer periodiociadade,
			Antibiotico antibiotico, Tratamento tratamento) {
		this.descPrescricao = descPrescricao;
		this.statusTratamento = statusTratamento;
		this.descStatusTratamento = descStatusTratamento;
		this.inicioTratamento = inicioTratamento;
		this.fimTratamento = fimTratamento;
		this.dosagemDiaria = dosagemDiaria;
		this.periodiociadade = periodiociadade;
		this.antibiotico = antibiotico;
		this.tratamento = tratamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescPrescricao() {
		return descPrescricao;
	}

	public void setDescPrescricao(String descPrescricao) {
		this.descPrescricao = descPrescricao;
	}

	public String getDescStatusTratamento() {
		return descStatusTratamento;
	}

	public void setDescStatusTratamento(String descStatusTratamento) {
		this.descStatusTratamento = descStatusTratamento;
	}

	public LocalDate getInicioTratamento() {
		return inicioTratamento;
	}

	public void setInicioTratamento(LocalDate inicioTratamento) {
		this.inicioTratamento = inicioTratamento;
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

	public Antibiotico getAntibiotico() {
		return antibiotico;
	}

	public void setAntibiotico(Antibiotico antibiotico) {
		this.antibiotico = antibiotico;
	}

	public Tratamento getTratamento() {
		return tratamento;
	}

	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public StatusTratamento getStatusTratamento() {
		return StatusTratamento.toEnum(statusTratamento);
	}

	public void setStatusTratamento(StatusTratamento statusTratamento) {
		this.statusTratamento = statusTratamento.getCod();
	}

	@Override
	public String toString() {
		return "Prescricao [id=" + id + ", descPrescricao=" + descPrescricao + ", statusTratamento=" + statusTratamento
				+ ", descStatusTratamento=" + descStatusTratamento + ", inicioTratamento=" + inicioTratamento
				+ ", fimTratamento=" + fimTratamento + ", dosagemDiaria=" + dosagemDiaria + ", periodiociadade="
				+ periodiociadade + ", antibiotico=" + antibiotico + ", tratamento=" + tratamento + "]";
	}

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
		Prescricao other = (Prescricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
