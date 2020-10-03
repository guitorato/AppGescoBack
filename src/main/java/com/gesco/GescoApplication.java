package com.gesco;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;

import com.gesco.domain.Funcionario;
import com.gesco.domain.Hospital;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.repositories.HospitalRepository;

@SpringBootApplication
public class GescoApplication implements CommandLineRunner {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GescoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hospital hosp1 = new Hospital(null, "SPDM", "Rua bla bla", "5457", "Ocian", "Praia Grande-SP");
		hospitalRepository.save(hosp1);
		
		Funcionario func1 = new Funcionario(null, "Guilherme", LocalDate.now(), "M", "sdasd", "asdasd", hosp1);
		Funcionario func2 = new Funcionario(null, "Matheus", LocalDate.now(), "M", "sdasd", "asdasd", hosp1);
		funcionarioRepository.save(func1);
		funcionarioRepository.save(func2);
		
	}
	
	

}
