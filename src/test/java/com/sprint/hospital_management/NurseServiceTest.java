package com.sprint.hospital_management;

import com.sprint.hospital_management.entity.Nurse;
import com.sprint.hospital_management.service.NurseService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NurseServiceTest {

    private NurseService nurseService;

    @BeforeEach
    public void setup() {
        nurseService = mock(NurseService.class);
    }

    @Test
    public void testAddNurse() {
        Nurse nurse = new Nurse();
        nurse.setName("Nurse Joy");

        when(nurseService.addNurse(nurse)).thenReturn(nurse);

        Nurse result = nurseService.addNurse(nurse);
        assertNotNull(result);
        assertEquals("Nurse Joy", result.getName());
    }

    @Test
    public void testGetAllNurses() {
        Nurse n1 = new Nurse();
        n1.setEmpId("EMP2001");

        Nurse n2 = new Nurse();
        n2.setEmpId("EMP2002");

        when(nurseService.getAllNurses()).thenReturn(Arrays.asList(n1, n2));

        List<Nurse> result = nurseService.getAllNurses();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetNurseByEmpId() {
        Nurse nurse = new Nurse();
        nurse.setEmpId("EMP2001");
        nurse.setName("Nurse Joy");

        when(nurseService.getNurseByEmpId("EMP2001")).thenReturn(nurse);

        Nurse result = nurseService.getNurseByEmpId("EMP2001");
        assertNotNull(result);
        assertEquals("Nurse Joy", result.getName());
    }

    @Test
    public void testGetPositionByEmpId() {
        Nurse nurse = new Nurse();
        nurse.setEmpId("EMP2001");
        nurse.setPosition("Senior Nurse");

        when(nurseService.getPositionByEmpId("EMP2001")).thenReturn("Senior Nurse");

        String position = nurseService.getPositionByEmpId("EMP2001");
        assertEquals("Senior Nurse", position);
    }

    @Test
    public void testIsRegistered() {
        when(nurseService.isRegistered("EMP2001")).thenReturn(true);

        boolean registered = nurseService.isRegistered("EMP2001");
        assertTrue(registered);
    }

    @Test
    public void testUpdateRegistered() {
        Nurse updated = new Nurse();
        updated.setEmpId("EMP2001");
        updated.setRegistered(false);

        when(nurseService.updateRegistered("EMP2001", false)).thenReturn(updated);

        Nurse result = nurseService.updateRegistered("EMP2001", false);
        assertFalse(result.isRegistered());
    }

    @Test
    public void testUpdateSSN() {
        Nurse updated = new Nurse();
        updated.setEmpId("EMP2001");
        updated.setSsn("123456789");

        when(nurseService.updateSSN("EMP2001", "123456789")).thenReturn(updated);

        Nurse result = nurseService.updateSSN("EMP2001", "123456789");
        assertEquals("123456789", result.getSsn());
    }
}