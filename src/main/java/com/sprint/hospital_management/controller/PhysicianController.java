package com.sprint.hospital_management.controller;

import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/physician")
public class PhysicianController {

    @Autowired
    private PhysicianRepository physicianRepository;

    @PostMapping
    public Physician addPhysician(@RequestBody Physician physician) {
        return physicianRepository.save(physician);
    }

    @GetMapping
    public List<Physician> getAllPhysicians() {
        return physicianRepository.findAll();
    }

    @GetMapping("/{employeeId}")
    public Physician getPhysicianById(@PathVariable Integer employeeId) {
        return physicianRepository.findById(employeeId).orElse(null);
    }
}