package com.sprint.hospital_management.controller;

import com.sprint.hospital_management.entity.TrainedIn;
import com.sprint.hospital_management.service.TrainedInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/trained_in")
@CrossOrigin(origins = "*")
public class TrainedInController {

    @Autowired
    private TrainedInService trainedInService;

    @PostMapping
    public ResponseEntity<String> addCertification(@RequestBody TrainedIn trainedIn) {
        trainedInService.saveCertification(trainedIn);
        return ResponseEntity.ok("Record Created Successfully");
    }

    @GetMapping
    public ResponseEntity<List<TrainedIn>> getAllCertifications() {
        return ResponseEntity.ok(trainedInService.getAllCertifications());
    }

    @GetMapping("/treatment/{physicianId}")
    public ResponseEntity<List<TrainedIn>> getProceduresByPhysician(@PathVariable Long physicianId) {
        return ResponseEntity.ok(trainedInService.getProceduresByPhysician(physicianId));
    }

    @GetMapping("/physicians/{procedureCode}")
    public ResponseEntity<List<TrainedIn>> getPhysiciansByProcedure(@PathVariable Integer procedureCode) {
        return ResponseEntity.ok(trainedInService.getPhysiciansByProcedure(procedureCode));
    }

    @GetMapping("/expiredsooncerti/{physicianId}")
    public ResponseEntity<List<TrainedIn>> getExpiringCertifications(@PathVariable Long physicianId) {
        return ResponseEntity.ok(trainedInService.getExpiringCertifications(physicianId));
    }

    @PutMapping("/certificationexpiry/{physicianId}/{procedureCode}")
    public ResponseEntity<Boolean> updateCertificationExpiry(
            @PathVariable Long physicianId,
            @PathVariable Integer procedureCode,
            @RequestBody LocalDate newExpiryDate) {
        boolean updated = trainedInService.updateCertificationExpiry(physicianId, procedureCode, newExpiryDate);
        return ResponseEntity.ok(updated);
    }
}