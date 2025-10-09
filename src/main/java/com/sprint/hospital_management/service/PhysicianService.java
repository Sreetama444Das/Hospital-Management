package com.sprint.hospital_management.service;

import com.sprint.hospital_management.entity.Physician;

import java.util.List;

public interface PhysicianService {
    Physician savePhysician(Physician physician);
    List<Physician> getAllPhysicians();
    Physician getPhysicianById(Integer employeeId);
}