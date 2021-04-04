package com.gesco.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.domain.Hospital;
import com.gesco.domain.Paciente;
import com.gesco.domain.Prescricao;
import com.gesco.domain.Tratamento;
import com.gesco.domain.enums.StatusTratamento;
import com.gesco.domain.enums.TipoAplicacao;
import com.gesco.repositories.AntibioticoRepository;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.repositories.HospitalRepository;
import com.gesco.repositories.PacienteRepository;
import com.gesco.repositories.PrescricaoRepository;
import com.gesco.repositories.TratamentoRepository;


@Service
public class DBService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private AntibioticoRepository antibioticoRepository;
	
	@Autowired
	private PrescricaoRepository prescricaoRepository;
	
	@Autowired
	private TratamentoRepository tratamentoRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void instantiateTestDataBase() throws ParseException {
		
		
		Hospital hosp1 = new Hospital("SPDM", "Hospital de Praia Grande - SP");
		Hospital hosp2 = new Hospital("UPA-Quietude", "Pronto Socorro Quietude");
		
		hospitalRepository.save(hosp1);
		hospitalRepository.save(hosp2);
		
		Paciente pac1 = new Paciente("GUILHERME", 3488759, LocalDate.now(), false, true, hosp1);
		Paciente pac2 = new Paciente("MATHEUS", 3555759, LocalDate.now(), false, true, hosp1);
		Paciente pac3 = new Paciente("MARCELO", 3666759, LocalDate.now(), false, false, hosp1);
		Paciente pac4 = new Paciente("CARLOS", 3777759, LocalDate.now(), false, false, hosp1);
		
		pacienteRepository.save(pac1);
		pacienteRepository.save(pac2);
		pacienteRepository.save(pac3);
		pacienteRepository.save(pac4);
		
		
		Funcionario func1 = new Funcionario("Danilo", "danilo", passwordEncoder.encode("123456"), 2466644, 1 , hosp1);
		Funcionario func2 = new Funcionario("Test", "test", passwordEncoder.encode("123456"), 2466644, 2 , hosp1);
		Funcionario func3 = new Funcionario("Teste1", "teste1", passwordEncoder.encode("123456"), 2466644, 3 , hosp1);
		Funcionario func4 = new Funcionario("Admin", "admin", passwordEncoder.encode("123456"), 2466644, 4 , hosp1);
		
		funcionarioRepository.save(func1);
		funcionarioRepository.save(func2);
		funcionarioRepository.save(func3);
		funcionarioRepository.save(func4);
		
		
		Antibiotico atb1 = new Antibiotico("CEFTRIAXONA", "ROCEFIN", LocalDate.now(), "45785-1", 1 , func3);
		Antibiotico atb2 = new Antibiotico("CEFALOTINA", "KEFLIN", LocalDate.now(), "78555", 2 , func3);
		Antibiotico atb3 = new Antibiotico("CIPROFLOXACINO", "CIPRO", LocalDate.now(), "A575SD", 3 , func3);
		Antibiotico atb4 = new Antibiotico("METRONIDAZOL", "FLAGYL", LocalDate.now(), "BF8217", 4 , func3);
		
		antibioticoRepository.save(atb1);
		antibioticoRepository.save(atb2);
		antibioticoRepository.save(atb3);
		antibioticoRepository.save(atb4);
		
		Tratamento trata1 = new Tratamento("Diagnostico 1",func1 , pac1, hosp1, null);
		Tratamento trata2 = new Tratamento("Diagnostico 2",func1 , pac2, hosp1, null);
		Tratamento trata3 = new Tratamento("Diagnostico 3",func1 , pac3, hosp1, null);
		
		tratamentoRepository.save(trata1);
		tratamentoRepository.save(trata2);
		tratamentoRepository.save(trata3);
		
		Prescricao presc1 = new Prescricao("asdasd", 1, null, LocalDate.now(), LocalDate.now(), 8.0, 5, atb1, trata1);
		Prescricao presc2 = new Prescricao("asdasd", 1, null, LocalDate.now(), LocalDate.now(), 8.0, 5, atb2, trata1);
		Prescricao presc3 = new Prescricao("asdasd", 1, null, LocalDate.now(), LocalDate.now(), 8.0, 5, atb3, trata2);
		Prescricao presc4 = new Prescricao("asdasd", 1, null, LocalDate.now(), LocalDate.now(), 8.0, 5, atb4, trata2);
		Prescricao presc5 = new Prescricao("asdasd", 1, null, LocalDate.now(), LocalDate.now(), 8.0, 5, atb1, trata3);
		Prescricao presc6 = new Prescricao("asdasd", 1, null, LocalDate.now(), LocalDate.now(), 8.0, 5, atb3, trata3);
		
		prescricaoRepository.saveAll(Arrays.asList(presc1,presc2,presc3,presc4,presc5,presc6));
	}

}
