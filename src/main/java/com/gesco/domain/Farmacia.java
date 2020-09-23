package com.gesco.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFarmacia;
	
	@Column(nullable = false)
	private String usuario;
	
	@Column(nullable = false)
	private String senha;
	
	@OneToMany(mappedBy="farmacia")
	private List<Tratamento> tratamentos;
	
	public Farmacia() {}
	public Farmacia(Integer idFarmacia, String usuario, String senha, List<Tratamento> tratamentos) {
		this.idFarmacia = idFarmacia;
		this.usuario = usuario;
		this.senha = senha;
		this.tratamentos = tratamentos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFarmacia == null) ? 0 : idFarmacia.hashCode());
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
		if (idFarmacia == null) {
			if (other.idFarmacia != null)
				return false;
		} else if (!idFarmacia.equals(other.idFarmacia))
			return false;
		return true;
	}
	
	
	

}
