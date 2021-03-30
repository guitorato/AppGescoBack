package com.gesco.domain.enums;

public enum TipoAplicacao {

	ENDOVENOSA(1,"ENDOVENOSA(EV)"),
	INTRAMUSCULAR(2,"INTRAMUSCULAR(IM)"),
	ENDOVENOSAeINTRAMUSCULAR(3,"ENDOVENOSA(EV) / INTRAMUSCULAR(IM)"),
	COMPRIMIDO(4,"COMPRIMIDO(CP)");
	
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
