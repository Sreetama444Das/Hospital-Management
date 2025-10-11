package com.sprint.hospital_management;

import com.sprint.hospital_management.service.AffiliatedWithService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AffiliatedWithServiceTest {

    private AffiliatedWithService affiliatedWithService;

    @BeforeEach
    public void setup() {
        affiliatedWithService = mock(AffiliatedWithService.class);
    }

    @Test
    public void testUpdatePrimaryAffiliationTrue() {
        when(affiliatedWithService.updatePrimaryAffiliation(1001, true)).thenReturn(true);

        boolean result = affiliatedWithService.updatePrimaryAffiliation(1001, true);
        assertTrue(result);
    }

    @Test
    public void testUpdatePrimaryAffiliationFalse() {
        when(affiliatedWithService.updatePrimaryAffiliation(1001, false)).thenReturn(true);

        boolean result = affiliatedWithService.updatePrimaryAffiliation(1001, false);
        assertTrue(result);
    }

    @Test
    public void testUpdatePrimaryAffiliationInvalidId() {
        when(affiliatedWithService.updatePrimaryAffiliation(9999, true)).thenReturn(false);

        boolean result = affiliatedWithService.updatePrimaryAffiliation(9999, true);
        assertFalse(result);
    }
}