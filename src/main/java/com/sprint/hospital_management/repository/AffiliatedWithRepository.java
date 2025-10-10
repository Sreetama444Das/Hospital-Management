package com.sprint.hospital_management.repository;

import com.sprint.hospital_management.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliatedWithRepository extends JpaRepository<Physician, Integer> {
}
