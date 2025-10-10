package com.sprint.hospital_management.service;

import com.sprint.hospital_management.entity.Nurse;

import java.util.List;

public interface NurseService {

    Nurse addNurse(Nurse nurse);

    List<Nurse> getAllNurses();

    Nurse getNurseByEmpId(String empId);

    String getPositionByEmpId(String empId);

    boolean isRegistered(String empId);

    Nurse updateRegistered(String empId, boolean registered);

    Nurse updateSSN(String empId, String ssn);
}