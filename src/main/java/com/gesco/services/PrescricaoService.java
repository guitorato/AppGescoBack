package com.gesco.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.DocumentEndToken;

import com.gesco.domain.Antibiotico;
import com.gesco.domain.Prescricao;
import com.gesco.domain.enums.StatusTratamento;
import com.gesco.dto.PrescricaoDTO;
import com.gesco.dto.StatusTratamentoDTO;
import com.gesco.repositories.AntibioticoRepository;
import com.gesco.repositories.PrescricaoRepository;
import com.gesco.services.exceptions.DataIntegrityException;
import com.gesco.services.exceptions.ObjectNotFoundException;

import io.swagger.annotations.ApiOperation;

@Service
public class PrescricaoService {
	
	@Autowired
	private PrescricaoRepository repo;
	
	@Autowired
	private AntibioticoRepository repoAntibiotico;
	
	
	@ApiOperation(value = "ATUALIZA UMA PRESCRICAO")
	public Prescricao update (Prescricao obj) {
		repo.findById(obj.getId());

		return repo.save(obj);
	}
	
	
	@ApiOperation(value = "DELETA UMA PRESCRICAO")
	public void delete (Integer id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	@ApiOperation(value = "LISTA DE TODOS AS PRESCRICÕES S/FILTRO")
	public List<Prescricao> findAll(){
		return repo.findAll();
	}
	
	
	@ApiOperation(value = "INSERE UMA PRESCRIÇÃO")
	public Prescricao insert (PrescricaoDTO dto) {
	  	Prescricao obj = new Prescricao();
	  	System.out.println(dto.getIdAntibiotico());
	  
		obj.setId(null);
		
		
		obj.setDescPrescricao(dto.getDescPrescricao());
		obj.getStatusTratamento();
		obj.setStatusTratamento(StatusTratamento.PENDENTE);
		obj.setDescStatusTratamento(null);
		
		obj.setInicioTratamento(LocalDate.now());
		obj.setFimTratamento(LocalDate.now().plusDays(dto.getDiasTratamento()));
		
		obj.setDosagemDiaria(dto.getDosagemDiaria());
		obj.setPeriodiociadade(dto.getPeriodiociadade());
		
		if(repoAntibiotico.findById(dto.getIdAntibiotico()).isPresent()) {
			
			obj.setAntibiotico(repoAntibiotico.findById(dto.getIdAntibiotico()).get());
		}else {
			throw new ObjectNotFoundException("Antibiotico não encontrado");
		}
		
		obj.setTratamento(null);
		
		
		System.out.println(obj.toString());
		
		return repo.save(obj);
	}
	
	@ApiOperation(value = "UPDATE DE STATUS DO TRATAMENTO E DESCRICAO")
	public void updateStatusTratamento (Integer id, StatusTratamentoDTO dto) {
		Optional<Prescricao> idPrescricao = repo.findById(id);
	
		
		if(idPrescricao.isPresent()) {
			Prescricao obj = idPrescricao.get();
			obj.setId(id);
			obj.getStatusTratamento();
			
			long dataFim =  ChronoUnit.DAYS.between(obj.getInicioTratamento() , obj.getFimTratamento());
			System.out.println(dataFim);
			
			
			if(dto.getStatusTratamento() == 2) {
				obj.setStatusTratamento(StatusTratamento.APROVADO);
				obj.setDescStatusTratamento(null);
				obj.setInicioTratamento(LocalDate.now());
				obj.setFimTratamento(LocalDate.now().plusDays(dataFim));
				repo.updateStatusTratamentoAndDescStatusTratamento
						(dto.getStatusTratamento(), dto.getDescStatusTratamento(),id);
				
			}else if(dto.getStatusTratamento() == 3) {
				if(dto.getDescStatusTratamento() == null || dto.getDescStatusTratamento().equals("")) {
					throw new ObjectNotFoundException("Informe o motivo de não Aprovar o Antibiótico");
				}else {
					
					obj.setStatusTratamento(StatusTratamento.RECUSADO);
					obj.setDescStatusTratamento(dto.getDescStatusTratamento());
					repo.updateStatusTratamentoAndDescStatusTratamento
					(dto.getStatusTratamento(), dto.getDescStatusTratamento(),id);
				}
				
			}else {
				
				throw new ObjectNotFoundException("Status de Tratamento Incorreto");
			}
		}else {
			
			throw new ObjectNotFoundException("Prescrição não encontrada");
		}
		
	}
	

}
