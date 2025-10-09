package com.sprint.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sprint.hospital_management.entity.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer>{

}
