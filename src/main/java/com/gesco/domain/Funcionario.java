package com.gesco.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gesco.domain.enums.TipoFuncionario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFuncionario;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, columnDefinition = "DATE")
	@DateTimeFormat(iso = ISO.DATE, pattern = "")
	private LocalDate dtNascimento;
	
	@Column(nullable = false)
	private String sexo;
	
	@Column(nullable = false)
	private String nameUser;
	
	@Column(nullable = false)
	private String senha;
	
	private String crmOuCrf;
	
	@Column(nullable = false)
	private Integer tipoFuncionario;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hospital_id") 
	private Hospital hospital;
	
	@JsonInclude
	@Transient
	private String nm_hospital;
	
	@JsonIgnore 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.EAGER)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Tratamento> tratamentos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.EAGER)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Antibiotico> antibioticos = new ArrayList<>();
	
	public Funcionario() {}

	public Funcionario(Integer idFuncionario, String nome, LocalDate dtNascimento, String sexo, String nameUser,
			String senha, String crmOuCrf, TipoFuncionario tipoFuncionario, Hospital hospital) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.nameUser = nameUser;
		this.senha = senha;
		this.crmOuCrf = crmOuCrf;
		this.tipoFuncionario = tipoFuncionario.getCod();
		this.hospital = hospital;
	}


	public String getNm_hospital() {
		return hospital.getNome();
	}

	public void setNm_hospital(String nm_hospital) {
		this.nm_hospital = hospital.getNome();
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
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

	public String getCrmOuCrf() {
		return crmOuCrf;
	}

	public void setCrmOuCrf(String crmOuCrf) {
		this.crmOuCrf = crmOuCrf;
	}

	public TipoFuncionario getTipoFuncionario() {
		return TipoFuncionario.toEnum(tipoFuncionario);
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario.getCod();
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Antibiotico> getAntibioticos() {
		return antibioticos;
	}

	public void setAntibioticos(List<Antibiotico> antibioticos) {
		this.antibioticos = antibioticos;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
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
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", dtNascimento=" + dtNascimento
				+ ", sexo=" + sexo + ", nameUser=" + nameUser + ", senha=" + senha + ", hospital=" + hospital+ "]";
	}
	
	
	
	
	
}
