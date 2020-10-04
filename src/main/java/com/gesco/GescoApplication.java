package com.gesco;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.domain.Hospital;
import com.gesco.domain.enums.TipoFuncionario;
import com.gesco.repositories.AntibioticoRepository;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.repositories.HospitalRepository;

@SpringBootApplication
public class GescoApplication implements CommandLineRunner {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private AntibioticoRepository antibioticoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GescoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hospital hosp1 = new Hospital(null, "SPDM", "Rua bla bla", "5457", "Ocian", "Praia Grande-SP");
		
		
		Funcionario func1 = new Funcionario(null, "Guilherme", LocalDate.now(), "M", "sdasd", "asdasd","4525" ,TipoFuncionario.FARMACEUTICO, hosp1);
		Funcionario func2 = new Funcionario(null, "Matheus", LocalDate.now(), "M", "sdasd", "3423", "54878", TipoFuncionario.MEDICO, hosp1);
		Funcionario func3 = new Funcionario(null, "Daulo", LocalDate.now(), "M", "sdasd", "asdfad", null, TipoFuncionario.INTERNACAO, hosp1);

		hosp1.getFuncionarios().addAll(Arrays.asList(func1,func2,func3));
		
		hospitalRepository.save(hosp1);
		funcionarioRepository.saveAll(Arrays.asList(func1,func2));
		
		Antibiotico atb1 = new Antibiotico(null, "Ceftriaxona","45841-1", LocalDate.now(), 1.0 , "EV", func1);
		Antibiotico atb2 = new Antibiotico(null, "Cefalotina","AL4521-1", LocalDate.now(), 1.0 , "EV", func2);
		
		antibioticoRepository.saveAll(Arrays.asList(atb1,atb2));
	}
	
	

}
