package com.gesco.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesco.domain.Hospital;
import com.gesco.domain.Paciente;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.repositories.HospitalRepository;
import com.gesco.repositories.PacienteRepository;


@Service
public class DBService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private HospitalRepository hospitalRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	
	public void instantiateTestDataBase() throws ParseException {
		
		
		Hospital hosp1 = new Hospital("SPDM", "Hospital de Praia Grande - SP");
		Hospital hosp2 = new Hospital("UPA-Quietude", "Pronto Socorro Quietude");
		
		hospitalRepository.save(hosp1);
		hospitalRepository.save(hosp2);
		
		Paciente pac1 = new Paciente("Guilherme", 3488759, LocalDate.now(), false, true, hosp1);
		Paciente pac2 = new Paciente("Matheus", 3555759, LocalDate.now(), false, true, hosp1);
		Paciente pac3 = new Paciente("Marcelo", 3666759, LocalDate.now(), false, false, hosp1);
		Paciente pac4 = new Paciente("Carlos", 3777759, LocalDate.now(), false, false, hosp1);
		
		pacienteRepository.save(pac1);
		pacienteRepository.save(pac2);
		pacienteRepository.save(pac3);
		pacienteRepository.save(pac4);
		
	}

}
