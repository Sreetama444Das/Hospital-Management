package com.sprint.hospital_management;

import com.sprint.hospital_management.entity.Department;
import com.sprint.hospital_management.service.DepartmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DepartmentServiceTest {

    private DepartmentService departmentService;

    @BeforeEach
    public void setup() {
        departmentService = mock(DepartmentService.class);
    }

    @Test
    public void testGetAllDepartments() {
        Department d1 = new Department();
        d1.setDeptId(1);

        Department d2 = new Department();
        d2.setDeptId(2);

        when(departmentService.getAllDepartments()).thenReturn(Arrays.asList(d1, d2));

        List<Department> result = departmentService.getAllDepartments();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetDepartmentsByHeadId() {
        Department d1 = new Department();
        d1.setHeadId(1001);

        Department d2 = new Department();
        d2.setHeadId(1001);

        when(departmentService.getDepartmentsByHeadId(1001)).thenReturn(Arrays.asList(d1, d2));

        List<Department> result = departmentService.getDepartmentsByHeadId(1001);
        assertEquals(2, result.size());
    }

    @Test
    public void testIsPhysicianHeadTrue() {
        when(departmentService.isPhysicianHead(1001)).thenReturn(true);

        boolean result = departmentService.isPhysicianHead(1001);
        assertTrue(result);
    }

    @Test
    public void testIsPhysicianHeadFalse() {
        when(departmentService.isPhysicianHead(9999)).thenReturn(false);

        boolean result = departmentService.isPhysicianHead(9999);
        assertFalse(result);
    }
}