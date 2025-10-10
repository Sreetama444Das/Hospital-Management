package com.sprint.hospital_management.controller;

import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.repository.AffiliatedWithRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affiliated_with")
public class AffiliatedWithController {

    @Autowired
    private AffiliatedWithRepository affiliatedWithRepository;

    // 🔹 PUT: Update primary affiliation
    @PutMapping("/primary/{physicianId}")
    public boolean updatePrimaryAffiliation(@PathVariable Integer physicianId, @RequestBody boolean primaryAffiliation) {
        Physician physician = affiliatedWithRepository.findById(physicianId).orElse(null);
        if (physician != null) {
            physician.setPrimaryAffiliation(primaryAffiliation);
            affiliatedWithRepository.save(physician);
            return true;
        }
        return false;
    }

    // 🔹 POST: Create a new physician
    @PostMapping
    public Physician createPhysician(@RequestBody Physician physician) {
        return affiliatedWithRepository.save(physician);
    }

    // 🔹 GET: List all physicians
    @GetMapping
    public List<Physician> getAllPhysicians() {
        return affiliatedWithRepository.findAll();
    }

    // 🔹 GET: Get physician by ID
    @GetMapping("/{physicianId}")
    public Physician getPhysicianById(@PathVariable Integer physicianId) {
        return affiliatedWithRepository.findById(physicianId).orElse(null);


    }
}