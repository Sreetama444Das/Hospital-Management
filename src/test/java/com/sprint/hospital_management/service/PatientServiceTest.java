package com.sprint.hospital_management.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sprint.hospital_management.entity.Patient;
import com.sprint.hospital_management.repository.PatientRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    private Patient patient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        patient = new Patient();
        patient.setSsn(123);
        patient.setName("John Doe");
        patient.setAddress("123 Main St");
        patient.setPhone("1234567890");
        patient.setInsuranceId("INS123");
    }

    @Test
    void testGetAllPatients() {
        List<Patient> patients = Arrays.asList(patient);
        when(patientRepository.findAll()).thenReturn(patients);

        List<Patient> result = patientService.getAllPatients();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    void testAddPatient() {
        patientService.addPatient(patient);
        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    void testGetPatientsBySsn() {
        when(patientRepository.findById(123)).thenReturn(Optional.of(patient));

        Optional<Patient> result = patientService.getPatientsBySsn(123);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
    }

    @Test
    void testUpdatePatient() {
        Patient updated = new Patient();
        updated.setName("Jane Doe");
        updated.setAddress("456 Elm St");
        updated.setPhone("0987654321");
        updated.setInsuranceId("INS456");

        when(patientRepository.findById(123)).thenReturn(Optional.of(patient));
        when(patientRepository.save(any(Patient.class))).thenReturn(updated);

        Patient result = patientService.updatePatient(123, updated);
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        assertEquals("456 Elm St", result.getAddress());
    }

    @Test
    void testDeletePatientExists() {
        when(patientRepository.existsById(123)).thenReturn(true);

        String result = patientService.deletePatient(123);
        verify(patientRepository, times(1)).deleteById(123);
        assertEquals("Patient Deleted successfully", result);
    }

    @Test
    void testDeletePatientNotFound() {
        when(patientRepository.existsById(123)).thenReturn(false);

        String result = patientService.deletePatient(123);
        verify(patientRepository, never()).deleteById(123);
        assertEquals("Patient not found", result);
    }
}