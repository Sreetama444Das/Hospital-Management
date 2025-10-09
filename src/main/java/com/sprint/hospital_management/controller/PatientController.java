package com.sprint.hospital_management.controller;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprint.hospital_management.entity.Patient;
import com.sprint.hospital_management.service.PatientService;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient> patients =patientService.getAllPatients();
		return ResponseEntity.ok(patients);
	}
	
	@GetMapping("/{ssn}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Integer ssn){
		Optional<Patient> patient = patientService.getPatientsBySsn(ssn);
		return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
	    patientService.addPatient(patient);
	    return ResponseEntity.ok(patient);
	}
}

