package com.sprint.hospital_management;

import com.sprint.hospital_management.entity.Procedure;
import com.sprint.hospital_management.service.ProcedureService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProcedureServiceTest {

    private ProcedureService procedureService;

    @BeforeEach
    public void setup() {
        procedureService = mock(ProcedureService.class);
    }

    @Test
    public void testAddProcedure() {
        Procedure procedure = new Procedure();
        procedure.setName("MRI Scan");

        when(procedureService.addProcedure(procedure)).thenReturn(procedure);

        Procedure result = procedureService.addProcedure(procedure);
        assertNotNull(result);
        assertEquals("MRI Scan", result.getName());
    }

    @Test
    public void testGetAllProcedures() {
        Procedure p1 = new Procedure();
        p1.setCode(101);

        Procedure p2 = new Procedure();
        p2.setCode(102);

        when(procedureService.getAllProcedures()).thenReturn(Arrays.asList(p1, p2));

        List<Procedure> result = procedureService.getAllProcedures();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetProcedureByCode() {
        Procedure procedure = new Procedure();
        procedure.setCode(101);
        procedure.setName("CT Scan");

        when(procedureService.getProcedureByCode(101)).thenReturn(Optional.of(procedure));

        Optional<Procedure> result = procedureService.getProcedureByCode(101);
        assertTrue(result.isPresent());
        assertEquals("CT Scan", result.get().getName());
    }

    @Test
    public void testDeleteProcedure() {
        doNothing().when(procedureService).deleteProcedure(101);

        procedureService.deleteProcedure(101);
        verify(procedureService, times(1)).deleteProcedure(101);
    }
}