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
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private AntibioticoRepository antibioticoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private TratamentoRepository tratamentoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GescoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hospital hosp1 = new Hospital(null, "SPDM", "Rua bla bla", "5457", "Ocian", "Praia Grande-SP");
		
		
		Funcionario farmaceutico = new Funcionario(null, "Guilherme", LocalDate.now(), "M", "sdasd", "asdasd","4525" ,TipoFuncionario.FARMACEUTICO, hosp1);
		Funcionario medico = new Funcionario(null, "Matheus", LocalDate.now(), "M", "sdasd", "3423", "54878", TipoFuncionario.MEDICO, hosp1);
		Funcionario internacao = new Funcionario(null, "Daulo", LocalDate.now(), "M", "sdasd", "asdfad", null, TipoFuncionario.INTERNACAO, hosp1);
		Funcionario farmacia = new Funcionario(null, "FARMACIA", LocalDate.now(), "M", "farmacia", "123456", null, TipoFuncionario.FARMACIA, hosp1);
		Funcionario adm = new Funcionario(null, "Administrador", LocalDate.now(), "M", "admin", "admin", null, TipoFuncionario.ADMINISTRADOR, hosp1);
		
		hosp1.getFuncionarios().addAll(Arrays.asList(farmaceutico,medico,internacao,farmacia,adm));
		
		hospitalRepository.save(hosp1);
		funcionarioRepository.saveAll(Arrays.asList(farmaceutico,medico,internacao,farmacia,adm));
		
		Antibiotico atb1 = new Antibiotico(null, "Ceftriaxona","45841-1", LocalDate.now(), 1.0 , "EV", farmaceutico);
		Antibiotico atb2 = new Antibiotico(null, "Meropenem","AL4521-1", LocalDate.now(), 1.0 , "EV", medico);
		
		antibioticoRepository.saveAll(Arrays.asList(atb1,atb2));
		
		Paciente pc1 = new Paciente(null, 455455, "Carlos Eduardo", LocalDate.now(), "Masculino");
		Paciente pc2 = new Paciente(null, 475455, "Ângelo", LocalDate.now(), "Outros");
		
		pacienteRepository.saveAll(Arrays.asList(pc1,pc2));
		
		Tratamento trat1 = new Tratamento(null, "Fimose", LocalDate.now(), LocalDate.now(), 2.5, "APROVADO", "Paciente Alérgico Cefalotina", medico, pc1);
		Tratamento trat2 = new Tratamento(null, "Hemorroida", LocalDate.now(), LocalDate.now(), 2.5, "APROVADO", "Paciente Alérgico Ceftriaxona", medico, pc2);
		
		//atb1.getTratamentos().add(trat1);
		//atb2.getTratamentos().addAll(Arrays.asList(trat1,trat2));
		trat1.getAntibioticos().add(atb1);
		trat2.getAntibioticos().addAll(Arrays.asList(atb1,atb2));
		
		tratamentoRepository.saveAll(Arrays.asList(trat1,trat2));
		
	}
	
	

}
