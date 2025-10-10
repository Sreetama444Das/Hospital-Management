package com.sprint.hospital_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AffiliatedWith {

    @Id
    private String physicianId;

    private boolean primaryAffiliation;

    // Getters and Setters
    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public boolean isPrimaryAffiliation() {
        return primaryAffiliation;
    }

    public void setPrimaryAffiliation(boolean primaryAffiliation) {
        this.primaryAffiliation = primaryAffiliation;
    }
}