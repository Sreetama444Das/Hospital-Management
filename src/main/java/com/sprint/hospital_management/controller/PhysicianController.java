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
    public Physician createPhysician(@RequestBody Physician physician) {
        return physicianRepository.save(physician);
    }

    @GetMapping("/name/{name}")
    public Physician getByName(@PathVariable String name) {
        return physicianRepository.findByName(name).orElse(null);
    }

    @GetMapping("/position/{pos}")
    public List<Physician> getByPosition(@PathVariable String pos) {
        return physicianRepository.findByPosition(pos);
    }

    @GetMapping("/empid/{empid}")
    public Physician getByEmpId(@PathVariable Long empid) {
        return physicianRepository.findById(empid).orElse(null);
    }

    @PutMapping("/update/position/{position}/{empid}")
    public Physician updatePosition(@PathVariable String position, @PathVariable String empid) {
        Physician physician = physicianRepository. findById(empid).orElse(null);
        if (physician != null) {
            physician.setPosition(position);
            return physicianRepository.save(physician);
        }
        return null;
    }

    @PutMapping("/update/name/{empid}")
    public Physician updateName(@PathVariable Long empid, @RequestBody String newName) {
        Physician physician = physicianRepository.findById(empid).orElse(null);
        if (physician != null) {
            physician.setName(newName);
            return physicianRepository.save(physician);
        }
        return null;
    }

    @PutMapping("/update/ssn/{empid}")
    public Physician updateSSN(@PathVariable Long empid, @RequestBody String newSSN) {
        Physician physician = physicianRepository.findById(empid).orElse(null);
        if (physician != null) {
            physician.setSsn(newSSN);
            return physicianRepository.save(physician);
        }
        return null;
    }
}