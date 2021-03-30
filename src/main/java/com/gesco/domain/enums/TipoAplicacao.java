package com.gesco.domain.enums;

public enum TipoAplicacao {

	EV(1,"EV"),
	IM(2,"IM"),
	EVIM(3,"EV / IM"),
	COMP(4,"COMP");
	
	private int cod;
	private String descricao;
	
	private TipoAplicacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoAplicacao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(TipoAplicacao x : TipoAplicacao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Acesso inválido");
	}
	
}
