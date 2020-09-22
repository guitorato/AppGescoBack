package com.gesco.domain;

import java.util.List;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Farmacia {
	
	private Integer id;
	private String usuario;
	private String senha;
	private List<Tratamento> tratamentos;
	
	public Farmacia() {}
	public Farmacia(Integer id, String usuario, String senha, List<Tratamento> tratamentos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.tratamentos = tratamentos;
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
		Farmacia other = (Farmacia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
