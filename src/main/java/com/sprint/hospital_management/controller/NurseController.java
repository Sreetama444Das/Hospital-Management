package com.sprint.hospital_management.controller;

import com.sprint.hospital_management.entity.Nurse;
import com.sprint.hospital_management.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {

    @Autowired
    private NurseRepository nurseRepository;

    @PostMapping
    public String addNurse(@RequestBody Nurse nurse) {
        nurseRepository.save(nurse);
        return "Record Created Successfully";
    }

    @GetMapping
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    @GetMapping("/{empId}")
    public Nurse getNurseByEmpId(@PathVariable String empId) {
        return nurseRepository.findById(empId).orElse(null);
    }

    @GetMapping("/position/{empId}")
    public String getPosition(@PathVariable String empId) {
        Nurse nurse = nurseRepository.findById(empId).orElse(null);
        return nurse != null ? nurse.getPosition() : null;
    }

    @GetMapping("/registered/{empId}")
    public boolean isRegistered(@PathVariable String empId) {
        Nurse nurse = nurseRepository.findById(empId).orElse(null);
        return nurse != null && nurse.isRegistered();
    }

    @PutMapping("/registered/{empId}")
    public Nurse updateRegistered(@PathVariable String empId, @RequestBody boolean registered) {
        Nurse nurse = nurseRepository.findById(empId).orElse(null);
        if (nurse != null) {
            nurse.setRegistered(registered);
            return nurseRepository.save(nurse);
        }
        return null;
    }

    @PutMapping("/ssn/{empId}")
    public Nurse updateSSN(@PathVariable String empId, @RequestBody String ssn) {
        Nurse nurse = nurseRepository.findById(empId).orElse(null);
        if (nurse != null) {
            nurse.setSsn(ssn);
            return nurseRepository.save(nurse);
        }
        return null;
    }
}