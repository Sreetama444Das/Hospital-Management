package com.sprint.hospital_management.service;

import com.sprint.hospital_management.entity.TrainedIn;
import com.sprint.hospital_management.repository.TrainedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TrainedInService {

    @Autowired
    private TrainedInRepository trainedInRepository;

    public TrainedIn saveCertification(TrainedIn trainedIn) {
        return trainedInRepository.save(trainedIn);
    }

    public List<TrainedIn> getAllCertifications() {
        return trainedInRepository.findAll();
    }

    public List<TrainedIn> getProceduresByPhysician(Long physicianId) {
        return trainedInRepository.findByPhysician_Id(physicianId);
    }

    public List<TrainedIn> getPhysiciansByProcedure(Integer procedureCode) {
        return trainedInRepository.findByProcedure_Code(procedureCode);
    }

    public List<TrainedIn> getExpiringCertifications(Long physicianId) {
        LocalDate oneMonthFromNow = LocalDate.now().plusMonths(1);
        return trainedInRepository.findByPhysician_IdAndCertificationExpiryBefore(physicianId, oneMonthFromNow);
    }

    public boolean updateCertificationExpiry(Long physicianId, Integer procedureCode, LocalDate newExpiry) {
        Optional<TrainedIn> record = trainedInRepository.findByPhysician_IdAndProcedure_Code(physicianId, procedureCode);
        if (record.isPresent()) {
            TrainedIn trainedIn = record.get();
            trainedIn.setCertificationExpiry(newExpiry);
            trainedInRepository.save(trainedIn);
            return true;
        }
        return false;
    }
}