package com.sprint.hospital_management.repository;

import com.sprint.hospital_management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByStartDate(LocalDate localDate);
}
