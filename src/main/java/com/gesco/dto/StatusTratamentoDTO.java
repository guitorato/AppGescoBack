package com.gesco.dto;

import com.gesco.domain.Prescricao;

public class StatusTratamentoDTO {
	
	private Integer statusTratamento;
	private String descStatusTratamento;
	
	public StatusTratamentoDTO() {}
	public StatusTratamentoDTO (Prescricao obj) {
		this.statusTratamento = obj.getStatusTratamento().getCod();
		this.descStatusTratamento = obj.getDescPrescricao();
	}
	
	
	
	public Integer getStatusTratamento() {
		return statusTratamento;
	}
	public void setStatusTratamento(Integer statusTratamento) {
		this.statusTratamento = statusTratamento;
	}
	public String getDescStatusTratamento() {
		return descStatusTratamento;
	}
	public void setDescStatusTratamento(String descStatusTratamento) {
		this.descStatusTratamento = descStatusTratamento;
	}
	
	

}
