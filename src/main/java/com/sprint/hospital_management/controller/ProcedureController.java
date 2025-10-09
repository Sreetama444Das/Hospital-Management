package com.sprint.hospital_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sprint.hospital_management.entity.Procedure;
import com.sprint.hospital_management.service.ProcedureService;

@RestController
@RequestMapping("/api/procedure")
public class ProcedureController {
	
	@Autowired
	private ProcedureService procedureService;
	
	@PostMapping
	public ResponseEntity<Procedure> addRocedure(@RequestBody Procedure procedure){
		return ResponseEntity.ok(procedureService.addProcedure(procedure));
	}
	
	@GetMapping
	public ResponseEntity<List<Procedure>> getAllProcedures(){
		return ResponseEntity.ok(procedureService.getAllProcedures());
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Procedure> getProcedureByCode(@PathVariable Integer code){
		return procedureService.getProcedureByCode(code)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{code}")
	public ResponseEntity<Void> deleteProcedure(@PathVariable Integer code){
		procedureService.deleteProcedure(code);
		return ResponseEntity.noContent().build();
	}
}
