package com.sprint.hospital_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.hospital_management.entity.Patient;
import com.sprint.hospital_management.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}
	
	public Optional<Patient> getPatientsBySsn(Integer ssn){
		return patientRepository.findById(ssn);
	}
	
	public Patient updatePatient(Integer ssn, Patient updatedPatient) {
		return patientRepository.findById(ssn).map(patient -> {
			patient.setName(updatedPatient.getName());
			patient.setAddress(updatedPatient.getAddress());
			patient.setPhone(updatedPatient.getPhone());
			patient.setInsuranceId(updatedPatient.getInsuranceId());
			return patientRepository.save(patient);
		}).orElse(null);
	}
	
	public String deletePatient(Integer ssn) {
		if(patientRepository.existsById(ssn)) {
			patientRepository.deleteById(ssn);
			return "Patient Deleted successfully";
		}
		return "Patient not found";
	}
}