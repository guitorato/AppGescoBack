package com.gesco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesco.domain.Paciente;
import com.gesco.domain.Prescricao;
import com.gesco.domain.Tratamento;
import com.gesco.dto.PrescricaoDTO;
import com.gesco.dto.TratamentoDTO;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.repositories.HospitalRepository;
import com.gesco.repositories.PacienteRepository;
import com.gesco.repositories.TratamentoRepository;
import com.gesco.services.exceptions.ObjectNotFoundException;

import io.swagger.annotations.ApiOperation;

@Service
public class TratamentoService {
	
	@Autowired
	private TratamentoRepository repo;
	
	@Autowired
	private PacienteRepository pacienteRepo;
	
	@Autowired
	private HospitalRepository hospitalRepo;
	
	@Autowired
	private FuncionarioRepository funcionarioRepo;
	

	@ApiOperation(value = "LISTA DE TODOS OS TRATAMENTOS S/FILTRO")
	public List<Tratamento> findAll(){
		return repo.findAll();
	}
	
	@ApiOperation(value = "INSERE UM TRATAMENTO")
	public Tratamento insert (TratamentoDTO dto) {
		Tratamento obj = new Tratamento();
			    Integer idPaciente = pacienteRepo.findById(pacienteRepo.findByRegistroLike(dto.getRegistroPaciente()));
				if(repo.findPaciente(idPaciente).get().getId().equals(null)) {
					
				
		
				obj.setId(null);
				
				obj.setDescDiagnostico(dto.getDescDiagnostico());
				
				if(pacienteRepo.findByRegistroLike(dto.getRegistroPaciente()).isPresent() && 
						funcionarioRepo.findByLogin(dto.getLoginFucnionario()).isPresent() &&
						hospitalRepo.findByNome(dto.getHospital()).isPresent()) {
					
					obj.setPaciente(pacienteRepo.findByRegistroLike(dto.getRegistroPaciente()).get());
					obj.setFuncionario(funcionarioRepo.findByLogin(dto.getLoginFucnionario()).get());
					obj.setHospital(hospitalRepo.findByNome(dto.getHospital()).get());
					
					return repo.save(obj);
					
				}
				else {
					throw new ObjectNotFoundException("Não foi encontrado algum dado");
				}
		}else {
			throw new ObjectNotFoundException("Não foi encontrado algum dado");
		}
	}
}
