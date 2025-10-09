package com.sprint.hospital_management.repository;

import com.sprint.hospital_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByHeadId(Integer headId);
    boolean existsByHeadId(Integer headId);
}