package com.sprint.hospital_management.service;

import com.sprint.hospital_management.entity.Physician;
import java.util.List;

public interface PhysicianService {

    Physician getByName(String name);
    List<Physician> getByPosition(String position);
    Physician getByEmpId(String empId);

    Physician updatePosition(String empId, String newPosition);
    Physician updateName(String empId, String newName);
    Physician updateSSN(String empId, String newSSN);
}