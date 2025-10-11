package com.sprint.hospital_management;

import com.sprint.hospital_management.entity.Physician;
import com.sprint.hospital_management.entity.Procedure;
import com.sprint.hospital_management.entity.TrainedIn;
import com.sprint.hospital_management.repository.TrainedInRepository;
import com.sprint.hospital_management.service.TrainedInService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TrainedInServiceTest {

    @Mock
    private TrainedInRepository trainedInRepository;

    @InjectMocks
    private TrainedInService trainedInService;

    private Physician physician;
    private Procedure procedure;
    private TrainedIn trainedIn;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        physician = new Physician();
        physician.setId(101L);

        procedure = new Procedure();
        procedure.setCode(1);

        trainedIn = new TrainedIn(
            physician,
            procedure,
            LocalDate.of(2026, 10, 1),
            LocalDate.of(2028, 10, 1)
        );
    }

    @Test
    public void testSaveCertification() {
        when(trainedInRepository.save(trainedIn)).thenReturn(trainedIn);

        TrainedIn result = trainedInService.saveCertification(trainedIn);
        assertNotNull(result);
        assertEquals(physician, result.getPhysician());
        assertEquals(procedure, result.getProcedure());
    }

    @Test
    public void testGetAllCertifications() {
        when(trainedInRepository.findAll()).thenReturn(Arrays.asList(trainedIn));

        List<TrainedIn> result = trainedInService.getAllCertifications();
        assertEquals(1, result.size());
        assertEquals(physician.getId(), result.get(0).getPhysician().getId());
    }

    @Test
    public void testGetProceduresByPhysician() {
        when(trainedInRepository.findByPhysician_Id(101L)).thenReturn(Arrays.asList(trainedIn));

        List<TrainedIn> result = trainedInService.getProceduresByPhysician(101L);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getProcedure().getCode());
    }

    @Test
    public void testGetPhysiciansByProcedure() {
        when(trainedInRepository.findByProcedure_Code(1)).thenReturn(Arrays.asList(trainedIn));

        List<TrainedIn> result = trainedInService.getPhysiciansByProcedure(1);
        assertEquals(1, result.size());
        assertEquals(101L, result.get(0).getPhysician().getId());
    }

    @Test
    public void testGetExpiringCertifications() {
        LocalDate oneMonthFromNow = LocalDate.now().plusMonths(1);
        when(trainedInRepository.findByPhysician_IdAndCertificationExpiryBefore(101L, oneMonthFromNow))
                .thenReturn(Arrays.asList(trainedIn));

        List<TrainedIn> result = trainedInService.getExpiringCertifications(101L);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testUpdateCertificationExpirySuccess() {
        LocalDate newExpiry = LocalDate.of(2029, 1, 1);
        when(trainedInRepository.findByPhysician_IdAndProcedure_Code(101L, 1))
                .thenReturn(Optional.of(trainedIn));
        when(trainedInRepository.save(any(TrainedIn.class))).thenReturn(trainedIn);

        boolean result = trainedInService.updateCertificationExpiry(101L, 1, newExpiry);
        assertTrue(result);
        assertEquals(newExpiry, trainedIn.getCertificationExpiry());
    }

    @Test
    public void testUpdateCertificationExpiryNotFound() {
        when(trainedInRepository.findByPhysician_IdAndProcedure_Code(999L, 999))
                .thenReturn(Optional.empty());

        boolean result = trainedInService.updateCertificationExpiry(999L, 999, LocalDate.of(2029, 1, 1));
        assertFalse(result);
    }
}