package com.sprint.hospital_management.service;

import com.sprint.hospital_management.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Integer deptId);
    List<Department> getDepartmentsByHeadId(Integer headId);
    boolean isPhysicianHead(Integer physicianId);
    Department updateHeadId(Integer deptId, Integer newHeadId);
    Department updateDeptName(Integer deptId, String newName);
}