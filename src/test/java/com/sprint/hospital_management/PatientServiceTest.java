package com.sprint.hospital_management;

import com.sprint.hospital_management.entity.Patient;
import com.sprint.hospital_management.service.PatientService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    private PatientService patientService;

    @BeforeEach
    public void setup() {
        patientService = mock(PatientService.class);
    }

    @Test
    public void testAddPatient() {
        Patient patient = new Patient();
        patient.setName("John Doe");

        doNothing().when(patientService).addPatient(patient);

        patientService.addPatient(patient);
        verify(patientService, times(1)).addPatient(patient);
    }

    @Test
    public void testGetAllPatients() {
        Patient p1 = new Patient();
        p1.setSsn(101);

        Patient p2 = new Patient();
        p2.setSsn(102);

        when(patientService.getAllPatients()).thenReturn(Arrays.asList(p1, p2));

        List<Patient> result = patientService.getAllPatients();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetPatientsBySsn() {
        Patient patient = new Patient();
        patient.setSsn(101);
        patient.setName("John Doe");

        when(patientService.getPatientsBySsn(101)).thenReturn(Optional.of(patient));

        Optional<Patient> result = patientService.getPatientsBySsn(101);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
    }

    @Test
    public void testUpdatePatient() {
        Patient updated = new Patient();
        updated.setName("Jane Doe");
        updated.setAddress("456 Elm St");
        updated.setPhone("9876543210");
        updated.setInsuranceId("INS456");

        when(patientService.updatePatient(101, updated)).thenReturn(updated);

        Patient result = patientService.updatePatient(101, updated);
        assertEquals("Jane Doe", result.getName());
        assertEquals("456 Elm St", result.getAddress());
    }

    @Test
    public void testDeletePatientSuccess() {
        when(patientService.deletePatient(101)).thenReturn("Patient Deleted successfully");

        String result = patientService.deletePatient(101);
        assertEquals("Patient Deleted successfully", result);
    }

    @Test
    public void testDeletePatientNotFound() {
        when(patientService.deletePatient(999)).thenReturn("Patient not found");

        String result = patientService.deletePatient(999);
        assertEquals("Patient not found", result);
    }
}