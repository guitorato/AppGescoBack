package com.gesco.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Funcionario;
import com.gesco.domain.Hospital;
import com.gesco.domain.Paciente;
import com.gesco.domain.Tratamento;
import com.gesco.domain.enums.StatusTratamento;
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
	
	public void instantiateTestDataBase() throws ParseException {
		
		
		Hospital hosp1 = new Hospital(null, "SPDM", "Rua bla bla", "5457", "Ocian", "Praia Grande-SP");
		
		
		Funcionario farmaceutico = new Funcionario(null, "Guilherme", LocalDate.now(), 1, "guilherme", "1234","4525" ,TipoFuncionario.FARMACEUTICO, hosp1);
		Funcionario medico = new Funcionario(null, "Matheus", LocalDate.now(), 1, "matheus", "12346", "54878", TipoFuncionario.MEDICO, hosp1);
		Funcionario internacao = new Funcionario(null, "Daulo", LocalDate.now(), 1, "daulo", "asdfad", null, TipoFuncionario.INTERNACAO, hosp1);
		Funcionario farmacia = new Funcionario(null, "FARMACIA", LocalDate.now(), 1, "farmacia", "123456", null, TipoFuncionario.FARMACIA, hosp1);
		Funcionario adm = new Funcionario(null, "Administrador", LocalDate.now(), 1, "admin", "admin", null, TipoFuncionario.ADMINISTRADOR, hosp1);
		
		hosp1.getFuncionarios().addAll(Arrays.asList(farmaceutico,medico,internacao,farmacia,adm));
		
		hospitalRepository.save(hosp1);
		funcionarioRepository.saveAll(Arrays.asList(farmaceutico,medico,internacao,farmacia,adm));
		
		Antibiotico atb1 = new Antibiotico(null, "Ceftriaxona","45841-1", LocalDate.now(), 1.0 , "EV", farmaceutico);
		Antibiotico atb2 = new Antibiotico(null, "Meropenem","AL4521-1", LocalDate.now(), 1.0 , "EV", medico);
		
		antibioticoRepository.saveAll(Arrays.asList(atb1,atb2));
		
		
		Paciente pc1 = new Paciente(null, 455455, "Carlos Eduardo", LocalDate.now(), 1);
		Paciente pc2 = new Paciente(null, 48967867, "Ângelo", LocalDate.now(), 1);
		Paciente pc3 = new Paciente(null, 478767, "Guilherme", LocalDate.now(), 1);
		Paciente pc4 = new Paciente(null, 456737, "Pedro", LocalDate.now(), 1);
		
		pacienteRepository.saveAll(Arrays.asList(pc1,pc2,pc3,pc4));
		
		Tratamento trat1 = new Tratamento(null, "Fimose", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.PENDENTE, "Paciente Alérgico Cefalotina", medico, pc1);
		Tratamento trat2 = new Tratamento(null, "Hemorroida", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.PENDENTE, "Paciente Alérgico Ceftriaxona", medico, pc2);
		Tratamento trat3 = new Tratamento(null, "Disenteria", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.PENDENTE, "Paciente Alérgico", medico, pc2);
		Tratamento trat4 = new Tratamento(null, "Doença1", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.APROVADO, "Paciente Alérgico", medico, pc2);
		Tratamento trat5 = new Tratamento(null, "Doença2", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.APROVADO, "Paciente Alérgico", medico, pc3);
		Tratamento trat6 = new Tratamento(null, "Doença3", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.APROVADO, "Paciente Alérgico", medico, pc4);
		Tratamento trat7 = new Tratamento(null, "Doença4", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.RECUSADO, "Paciente Alérgico", medico, pc1);
		Tratamento trat8 = new Tratamento(null, "Doença5", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.RECUSADO, "Paciente Alérgico", medico, pc3);
		Tratamento trat9 = new Tratamento(null, "Doença6", LocalDate.now(), LocalDate.now(), 2.5, StatusTratamento.RECUSADO, "Paciente Alérgico", medico, pc4);

		
		atb1.getTratamentos().add(trat1);
		atb2.getTratamentos().addAll(Arrays.asList(trat1,trat2));
		trat1.getAntibioticos().add(atb1);
		trat2.getAntibioticos().addAll(Arrays.asList(atb1,atb2));
		trat3.getAntibioticos().addAll(Arrays.asList(atb2));
		trat4.getAntibioticos().addAll(Arrays.asList(atb1,atb2));
		trat5.getAntibioticos().addAll(Arrays.asList(atb2));
		trat6.getAntibioticos().addAll(Arrays.asList(atb1));
		trat7.getAntibioticos().addAll(Arrays.asList(atb2));
		trat8.getAntibioticos().addAll(Arrays.asList(atb2));
		trat9.getAntibioticos().addAll(Arrays.asList(atb1));

		
		tratamentoRepository.saveAll(Arrays.asList(trat1,trat2,trat3,trat4,trat5,trat6,trat7,trat8,trat9));
	}

}
