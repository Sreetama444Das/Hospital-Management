package com.sprint.hospital_management.controller;

import com.sprint.hospital_management.entity.Department;
import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.repository.DepartmentRepository;
import com.sprint.hospital_management.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PhysicianRepository physicianRepository;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{deptId}")
    public Department getDepartmentById(@PathVariable Integer deptId) {
        return departmentRepository.findById(deptId).orElse(null);
    }

    @GetMapping("/byhead/{headId}")
    public List<Department> getDepartmentsByHeadId(@PathVariable Integer headId) {
        return departmentRepository.findByHeadId(headId);
    }

    @GetMapping("/check/{physicianId}")
    public boolean isPhysicianHead(@PathVariable Integer physicianId) {
        return departmentRepository.existsByHeadId(physicianId);
    }

    @PutMapping("/update/headid/{deptId}")
    public Department updateHeadId(@PathVariable Integer deptId, @RequestParam Integer newHeadId) {
        Department dept = departmentRepository.findById(deptId).orElse(null);
        if (dept != null) {
            dept.setHeadId(newHeadId);
            return departmentRepository.save(dept);
        }
        return null;
    }

    @PutMapping("/update/deptname/{deptId}")
    public Department updateDeptName(@PathVariable Integer deptId, @RequestParam String newName) {
        Department dept = departmentRepository.findById(deptId).orElse(null);
        if (dept != null) {
            dept.setDeptName(newName);
            return departmentRepository.save(dept);
        }
        return null;
    }

//    @GetMapping("/head/{deptId}")
//    public Physician getHeadOfDepartment(@PathVariable Integer deptId) {
//        Department dept = departmentRepository.findById(deptId).orElse(null);
//        if (dept != null) {
//            return physicianRepository.findById(dept.getHeadId()).orElse(null);
//        }
//        return null;
//    }

    @GetMapping("/headcertification/{deptId}")
    public String getHeadCertification(@PathVariable Integer deptId) {
        return "Certification details for head of department " + deptId;
    }
}