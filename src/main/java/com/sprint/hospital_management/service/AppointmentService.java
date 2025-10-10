package com.sprint.hospital_management.service;

import com.sprint.hospital_management.entity.Appointment;
import com.sprint.hospital_management.entity.Nurse;
import com.sprint.hospital_management.entity.Patient;
import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // 🔹 Create or update an appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // 🔹 Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // 🔹 Get appointments by start date
    public List<Appointment> getAppointmentsByStartDate(LocalDate startDate) {
        return appointmentRepository.findByStartDate(startDate);
    }

    // 🔹 Get patient by appointment ID
    public Patient getPatientByAppointment(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(Appointment::getPatient)
                .orElse(null);
    }

    // 🔹 Get physician by appointment ID
    public Physician getPhysicianByAppointment(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(Appointment::getPhysician)
                .orElse(null);
    }

    // 🔹 Get nurse by appointment ID
    public Nurse getNurseByAppointment(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(Appointment::getNurse)
                .orElse(null);
    }

    // 🔹 Get room by appointment ID
    public String getRoomByAppointment(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(Appointment::getExaminationRoom)
                .orElse(null);
    }

    // 🔹 Update room number
    public Appointment updateRoom(Long appointmentId, String newRoom) {
        Optional<Appointment> optional = appointmentRepository.findById(appointmentId);
        if (optional.isPresent()) {
            Appointment appointment = optional.get();
            appointment.setExaminationRoom(newRoom);
            return appointmentRepository.save(appointment);
        }
        return null;
    }
}