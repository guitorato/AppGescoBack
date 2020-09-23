package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Antibiotico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String lote;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validade;
	
	@Column(nullable = false)
	private Double dosagem;
	
	@Column(nullable = false)
	private String aplicacao;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Farmaceutico farmaceutico;
	
	@OneToMany(mappedBy="antibiotico")
	private List<Tratamento> tratamentos;

	public Antibiotico() {}
	public Antibiotico(Integer id, String nome, String lote, LocalDate validade, Double dosagem, String aplicacao,
			Farmaceutico farmaceutico) {
		super();
		this.id = id;
		this.nome = nome;
		this.lote = lote;
		this.validade = validade;
		this.dosagem = dosagem;
		this.aplicacao = aplicacao;
		this.farmaceutico = farmaceutico;
		
	}
	@Override
	public String toString() {
		return "Antibiotico [id=" + id + ", nome=" + nome + ", lote=" + lote + ", validade=" + validade + ", dosagem="
				+ dosagem + ", aplicacao=" + aplicacao + ", farmaceutico=" + farmaceutico + "]";
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
		Antibiotico other = (Antibiotico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
