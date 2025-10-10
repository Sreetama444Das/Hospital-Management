package com.sprint.hospital_management.repository;

import com.sprint.hospital_management.entity.Physician;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository extends JpaRepository<Physician, Long> {

	List<Physician> findByPosition(String pos);
    // No custom queries needed for DepartmentController

	Optional<Physician> findByName(String name);

	Optional<Physician> findByEmpId(String empId);
}