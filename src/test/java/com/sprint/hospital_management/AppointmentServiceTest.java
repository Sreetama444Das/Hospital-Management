package com.sprint.hospital_management;

import com.sprint.hospital_management.entity.Appointment;
import com.sprint.hospital_management.entity.Nurse;
import com.sprint.hospital_management.entity.Patient;
import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.service.AppointmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setup() {
        appointmentService = mock(AppointmentService.class);
    }

    @Test
    public void testSaveAppointment() {
        Appointment appointment = new Appointment();
        appointment.setExaminationRoom("Room 101");

        when(appointmentService.saveAppointment(appointment)).thenReturn(appointment);

        Appointment result = appointmentService.saveAppointment(appointment);
        assertNotNull(result);
        assertEquals("Room 101", result.getExaminationRoom());
    }

    @Test
    public void testGetAppointmentsByStartDate() {
        LocalDate date = LocalDate.of(2025, 10, 11);
        Appointment a1 = new Appointment();
        a1.setStartDate(date);

        when(appointmentService.getAppointmentsByStartDate(date)).thenReturn(Arrays.asList(a1));

        List<Appointment> result = appointmentService.getAppointmentsByStartDate(date);
        assertEquals(1, result.size());
        assertEquals(date, result.get(0).getStartDate());
    }

    @Test
    public void testGetPatientByAppointment() {
        Patient patient = new Patient();
        patient.setName("John Doe");

        when(appointmentService.getPatientByAppointment(1L)).thenReturn(patient);

        Patient result = appointmentService.getPatientByAppointment(1L);
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testGetPhysicianByAppointment() {
        Physician physician = new Physician();
        physician.setName("Dr. Smith");

        when(appointmentService.getPhysicianByAppointment(1L)).thenReturn(physician);

        Physician result = appointmentService.getPhysicianByAppointment(1L);
        assertNotNull(result);
        assertEquals("Dr. Smith", result.getName());
    }

    @Test
    public void testGetNurseByAppointment() {
        Nurse nurse = new Nurse();
        nurse.setName("Nurse Joy");

        when(appointmentService.getNurseByAppointment(1L)).thenReturn(nurse);

        Nurse result = appointmentService.getNurseByAppointment(1L);
        assertNotNull(result);
        assertEquals("Nurse Joy", result.getName());
    }

    @Test
    public void testGetRoomByAppointment() {
        when(appointmentService.getRoomByAppointment(1L)).thenReturn("Room 202");

        String room = appointmentService.getRoomByAppointment(1L);
        assertEquals("Room 202", room);
    }
}