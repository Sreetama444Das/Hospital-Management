package com.sprint.hospital_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.hospital_management.entity.Procedure;
import com.sprint.hospital_management.repository.ProcedureRepository;

@Service
public class ProcedureService {

	@Autowired
	private ProcedureRepository procedureRepository;
	
	public Procedure addProcedure(Procedure procedure) {
		return procedureRepository.save(procedure);
	}
	
	public List<Procedure> getAllProcedures(){
		return procedureRepository.findAll();
	}
	
	public Optional<Procedure> getProcedureByCode(Integer code){
		return procedureRepository.findById(code);
	}
	
	public void deleteProcedure(Integer code) {
		procedureRepository.deleteById(code);
	}
}
