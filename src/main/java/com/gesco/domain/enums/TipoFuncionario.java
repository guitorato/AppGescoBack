package com.gesco.domain.enums;

public enum TipoFuncionario {
	
	DESENVOLVEDRO(0,"Desenvolvedor"),
	MEDICO(1,"Médico"),
	FARMACEUTICO(2,"Farmacêutico"),
	INTERNACAO(3,"Internação"),
	FARMACIA(4,"Farmácia"),
	ADMINISTRADOR(5,"Administrador");
	
	private int cod;
	private String descricao;
	
	private TipoFuncionario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoFuncionario toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(TipoFuncionario x : TipoFuncionario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Acesso inválido");
	}
	
}
