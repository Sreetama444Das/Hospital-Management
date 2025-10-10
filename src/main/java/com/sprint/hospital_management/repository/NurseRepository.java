package com.sprint.hospital_management.repository;

import com.sprint.hospital_management.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, String> {
}