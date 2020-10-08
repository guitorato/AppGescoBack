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
import com.gesco.domain.Paciente;
import com.gesco.domain.Tratamento;
import com.gesco.domain.enums.TipoFuncionario;
import com.gesco.repositories.AntibioticoRepository;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.repositories.HospitalRepository;
import com.gesco.repositories.PacienteRepository;
import com.gesco.repositories.TratamentoRepository;

@SpringBootApplication
public class GescoApplication implements CommandLineRunner {
	
	
	public static void main(String[] args) {
		SpringApplication.run(GescoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		
	}
	
	

}
