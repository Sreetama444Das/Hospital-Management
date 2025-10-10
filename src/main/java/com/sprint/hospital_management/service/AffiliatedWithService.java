package com.sprint.hospital_management.service;

public interface AffiliatedWithService {
    boolean updatePrimaryAffiliation(Integer physicianId, boolean primaryAffiliation);
}