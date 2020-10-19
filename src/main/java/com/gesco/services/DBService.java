package com.gesco.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class DBService {
	
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
	
	public void instantiateTestDataBase() {
		
		Hospital hosp1 = new Hospital(null, "SPDM", "Rua bla bla", "5457", "Ocian", "Praia Grande-SP");
		
		
		Funcionario farmaceutico = new Funcionario(null, "Guilherme", LocalDate.now(), "M", "guilherme", "1234","4525" ,TipoFuncionario.FARMACEUTICO, hosp1);
		Funcionario medico = new Funcionario(null, "Matheus", LocalDate.now(), "M", "matheus", "12346", "54878", TipoFuncionario.MEDICO, hosp1);
		Funcionario internacao = new Funcionario(null, "Daulo", LocalDate.now(), "M", "daulo", "asdfad", null, TipoFuncionario.INTERNACAO, hosp1);
		Funcionario farmacia = new Funcionario(null, "FARMACIA", LocalDate.now(), "M", "farmacia", "123456", null, TipoFuncionario.FARMACIA, hosp1);
		Funcionario adm = new Funcionario(null, "Administrador", LocalDate.now(), "M", "admin", "admin", null, TipoFuncionario.ADMINISTRADOR, hosp1);
		
		hosp1.getFuncionarios().addAll(Arrays.asList(farmaceutico,medico,internacao,farmacia,adm));
		
		hospitalRepository.save(hosp1);
		funcionarioRepository.saveAll(Arrays.asList(farmaceutico,medico,internacao,farmacia,adm));
		
		Antibiotico atb1 = new Antibiotico(null, "Ceftriaxona","45841-1", LocalDate.now(), 1.0 , "EV", farmaceutico);
		Antibiotico atb2 = new Antibiotico(null, "Meropenem","AL4521-1", LocalDate.now(), 1.0 , "EV", medico);
		
		antibioticoRepository.saveAll(Arrays.asList(atb1,atb2));
		
		Paciente pc1 = new Paciente(null, 455455, "Carlos Eduardo", LocalDate.now(), "Masculino");
		Paciente pc2 = new Paciente(null, 48967867, "Ângelo", LocalDate.now(), "Outros");
		Paciente pc3 = new Paciente(null, 478767, "Guilherme", LocalDate.now(), "Outros");
		Paciente pc4 = new Paciente(null, 456737, "Pedro", LocalDate.now(), "Outros");
		
		pacienteRepository.saveAll(Arrays.asList(pc1,pc2,pc3,pc4));
		
		Tratamento trat1 = new Tratamento(null, "Fimose", LocalDate.now(), LocalDate.now(), 2.5, "APROVADO", "Paciente Alérgico Cefalotina", medico, pc1);
		Tratamento trat2 = new Tratamento(null, "Hemorroida", LocalDate.now(), LocalDate.now(), 2.5, "APROVADO", "Paciente Alérgico Ceftriaxona", medico, pc2);
		
		//atb1.getTratamentos().add(trat1);
		//atb2.getTratamentos().addAll(Arrays.asList(trat1,trat2));
		trat1.getAntibioticos().add(atb1);
		trat2.getAntibioticos().addAll(Arrays.asList(atb1,atb2));
		
		tratamentoRepository.saveAll(Arrays.asList(trat1,trat2));
	}

}
