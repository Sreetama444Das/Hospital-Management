package com.sprint.hospital_management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "trained_in")
public class TrainedIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "physician_id", referencedColumnName = "id")
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "procedure_id", referencedColumnName = "code") // ✅ Matches Procedure.code
    private Procedure procedure;

    @Column(name = "certification_date")
    private LocalDate certificationDate;

    @Column(name = "certification_expiry")
    private LocalDate certificationExpiry;

    public TrainedIn() {}

    public TrainedIn(Physician physician, Procedure procedure, LocalDate certificationDate, LocalDate certificationExpiry) {
        this.physician = physician;
        this.procedure = procedure;
        this.certificationDate = certificationDate;
        this.certificationExpiry = certificationExpiry;
    }

    public Long getId() {
        return id;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public LocalDate getCertificationDate() {
        return certificationDate;
    }

    public void setCertificationDate(LocalDate certificationDate) {
        this.certificationDate = certificationDate;
    }

    public LocalDate getCertificationExpiry() {
        return certificationExpiry;
    }

    public void setCertificationExpiry(LocalDate certificationExpiry) {
        this.certificationExpiry = certificationExpiry;
    }
}