package com.sprint.hospital_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Nurse {

    @Id
    private String empId;

    private String name;
    private String position;
    private boolean registered;
    private String ssn;

    // Getter and Setter for empId
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for position
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Getter and Setter for registered
    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    // Getter and Setter for ssn
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}