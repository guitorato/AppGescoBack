package com.gesco.dto;

	
import java.util.Date;

import com.gesco.domain.Funcionario;
import com.gesco.domain.Hospital;



	public class SessaoDTO {
		private Funcionario funcionario;
		private String login;
		private String token;
		private Date dataInicio;
		private Date dataFim;
		
		public SessaoDTO() {}
		
		public SessaoDTO(Funcionario funcionario, String login, String token, Date dataInicio, Date dataFim) {
			this.funcionario = funcionario;
			this.login = login;
			this.token = token;
			this.dataInicio = dataInicio;
			this.dataFim = dataFim;
		}
		

		public Funcionario getFuncionario() {
			return funcionario;
		}

		public void setFuncionario(Funcionario funcionario) {
			this.funcionario = funcionario;
		}
		
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public Date getDataInicio() {
			return dataInicio;
		}
		public void setDataInicio(Date dataInicio) {
			this.dataInicio = dataInicio;
		}
		public Date getDataFim() {
			return dataFim;
		}
		public void setDataFim(Date dataFim) {
			this.dataFim = dataFim;
		}
		
	}

