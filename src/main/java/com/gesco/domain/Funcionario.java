package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNascimento;
	
	@Column(nullable = false)
	private boolean sexo;
	
	@Column(nullable = false)
	private String nameUser;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private Integer tipoFunc;
	
	
	private String conselho;
	private String cdConselho;
	
	@ManyToOne
	@JoinColumn(name="hospital_id") 
	private Hospital hospital;
	
	public Funcionario () {}
	

	public Funcionario(Integer id, String nome, LocalDate dtNascimento, boolean sexo, String nameUser, String senha,
			Integer tipoFunc, String conselho, String cdConselho, Hospital hospital) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.nameUser = nameUser;
		this.senha = senha;
		this.tipoFunc = tipoFunc;
		this.conselho = conselho;
		this.cdConselho = cdConselho;
		this.hospital = hospital;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTipoFunc() {
		return tipoFunc;
	}

	public void setTipoFunc(Integer tipoFunc) {
		this.tipoFunc = tipoFunc;
	}

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public String getCdConselho() {
		return cdConselho;
	}

	public void setCdConselho(String cdConselho) {
		this.cdConselho = cdConselho;
	}

	public Hospital getHospital() {
		return hospital;
	}


	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo
				+ ", nameUser=" + nameUser + ", senha=" + senha + ", tipoFunc=" + tipoFunc + ", conselho=" + conselho
				+ ", cdConselho=" + cdConselho + ", hospital=" + hospital + "]";
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
