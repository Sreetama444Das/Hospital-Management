package com.sprint.hospital_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "physician")
public class Physician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "position", nullable = false, length = 50)
    private String position;

    @Column(name = "ssn", nullable = false, unique = true)
    private Integer ssn;

    // Constructors
    public Physician() {}

    public Physician(String name, String position, Integer ssn) {
        this.name = name;
        this.position = position;
        this.ssn = ssn;
    }

    // Getters and Setters
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }
}