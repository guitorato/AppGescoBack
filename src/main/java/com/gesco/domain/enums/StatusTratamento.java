package com.gesco.domain.enums;

public enum StatusTratamento {

	PENDENTE(1,"PENDENTE"),
	APROVADO(2,"APROVADO"),
	RECUSADO(3,"RECUSADO");
	
	
	private int cod;
	private String descricao;
	
	private StatusTratamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusTratamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(StatusTratamento x : StatusTratamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Acesso inválido");
	}
	
}
