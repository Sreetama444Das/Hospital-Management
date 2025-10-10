package com.sprint.hospital_management.controller;

import com.sprint.hospital_management.entity.Appointment;
import com.sprint.hospital_management.entity.Nurse;
import com.sprint.hospital_management.entity.Patient;
import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.repository.NurseRepository;
import com.sprint.hospital_management.repository.PatientRepository;
import com.sprint.hospital_management.repository.PhysicianRepository;
import com.sprint.hospital_management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PhysicianRepository physicianRepository;

    @Autowired
    private NurseRepository nurseRepository;

    // 🔹 Create a new appointment
    @PostMapping
    public String createAppointment(@RequestBody Appointment appointment) {
        // Fetch managed entities to avoid transient errors
        Patient patient = patientRepository.findById(appointment.getPatient().getSsn()).orElse(null);
        Physician physician = physicianRepository.findById(appointment.getPhysician().getId()).orElse(null);
        Nurse nurse = nurseRepository.findById(appointment.getNurse().getEmpId()).orElse(null);

        appointment.setPatient(patient);
        appointment.setPhysician(physician);
        appointment.setNurse(nurse);

        appointmentService.saveAppointment(appointment);
        return "Appointment created successfully";
    }

    // 🔹 Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // 🔹 Get appointments by start date
    @GetMapping("/{startdate}")
    public List<Appointment> getAppointmentsByStartDate(@PathVariable String startdate) {
        return appointmentService.getAppointmentsByStartDate(LocalDate.parse(startdate));
    }

    // 🔹 Get patient by appointment ID
    @GetMapping("/patient/{appointmentId}")
    public Patient getPatientByAppointment(@PathVariable Long appointmentId) {
        return appointmentService.getPatientByAppointment(appointmentId);
    }

    // 🔹 Get physician by appointment ID
    @GetMapping("/physician/{appointmentId}")
    public Physician getPhysicianByAppointment(@PathVariable Long appointmentId) {
        return appointmentService.getPhysicianByAppointment(appointmentId);
    }

    // 🔹 Get nurse by appointment ID
    @GetMapping("/nurse/{appointmentId}")
    public Nurse getNurseByAppointment(@PathVariable Long appointmentId) {
        return appointmentService.getNurseByAppointment(appointmentId);
    }

    // 🔹 Get examination room by appointment ID
    @GetMapping("/examinationroom/{appointmentId}")
    public String getRoomByAppointment(@PathVariable Long appointmentId) {
        return appointmentService.getRoomByAppointment(appointmentId);
    }

    // 🔹 Update examination room
    @PutMapping("/room/{appointmentId}")
    public Appointment updateRoom(@PathVariable Long appointmentId, @RequestBody String newRoom) {
        return appointmentService.updateRoom(appointmentId, newRoom);
    }
}