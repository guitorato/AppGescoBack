package com.gesco.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesco.domain.Hospital;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.repositories.HospitalRepository;


@Service
public class DBService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private HospitalRepository hospitalRepository;
	
	
	public void instantiateTestDataBase() throws ParseException {
		
		
		Hospital hosp1 = new Hospital("SPDM", "Hospital de Praia Grande - SP");
		
		hospitalRepository.save(hosp1);
		
	}

}
