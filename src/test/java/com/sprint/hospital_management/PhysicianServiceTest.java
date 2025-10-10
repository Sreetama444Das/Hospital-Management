package com.sprint.hospital_management;

import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.service.PhysicianService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PhysicianServiceTest {

    private PhysicianService physicianService;

    @BeforeEach
    public void setup() {
        physicianService = mock(PhysicianService.class);
    }

    @Test
    public void testGetByName() {
        Physician physician = new Physician();
        physician.setName("Dr. Mehta");

        when(physicianService.getByName("Dr. Mehta")).thenReturn(physician);

        Physician result = physicianService.getByName("Dr. Mehta");
        assertNotNull(result);
        assertEquals("Dr. Mehta", result.getName());
    }

    @Test
    public void testGetByPosition() {
        Physician p1 = new Physician();
        p1.setPosition("Cardiologist");

        Physician p2 = new Physician();
        p2.setPosition("Cardiologist");

        when(physicianService.getByPosition("Cardiologist")).thenReturn(Arrays.asList(p1, p2));

        List<Physician> result = physicianService.getByPosition("Cardiologist");
        assertEquals(2, result.size());
    }

    @Test
    public void testUpdatePosition() {
        Physician updated = new Physician();
        updated.setEmpId("EMP1001");
        updated.setPosition("Neurologist");

        when(physicianService.updatePosition("EMP1001", "Neurologist")).thenReturn(updated);

        Physician result = physicianService.updatePosition("EMP1001", "Neurologist");
        assertEquals("Neurologist", result.getPosition());
    }

    @Test
    public void testUpdateName() {
        Physician updated = new Physician();
        updated.setEmpId("EMP1001");
        updated.setName("Dr. Nair");

        when(physicianService.updateName("EMP1001", "Dr. Nair")).thenReturn(updated);

        Physician result = physicianService.updateName("EMP1001", "Dr. Nair");
        assertEquals("Dr. Nair", result.getName());
    }

    @Test
    public void testUpdateSSN() {
        Physician updated = new Physician();
        updated.setEmpId("EMP1001");
        updated.setSsn("987654321");

        when(physicianService.updateSSN("EMP1001", "987654321")).thenReturn(updated);

        Physician result = physicianService.updateSSN("EMP1001", "987654321");
        assertEquals("987654321", result.getSsn());
    }
}

