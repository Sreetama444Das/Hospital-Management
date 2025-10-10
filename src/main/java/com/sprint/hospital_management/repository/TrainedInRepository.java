package com.sprint.hospital_management.repository;

import com.sprint.hospital_management.entity.TrainedIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TrainedInRepository extends JpaRepository<TrainedIn, Long> {

    List<TrainedIn> findByPhysician_Id(Long physicianId);

    List<TrainedIn> findByProcedure_Code(Integer procedureCode); // ✅ Matches Procedure.code

    List<TrainedIn> findByPhysician_IdAndCertificationExpiryBefore(Long physicianId, LocalDate date);

    Optional<TrainedIn> findByPhysician_IdAndProcedure_Code(Long physicianId, Integer procedureCode); // ✅ Matches Procedure.code
}