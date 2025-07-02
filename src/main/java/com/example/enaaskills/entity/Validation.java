package com.example.enaaskills.entity;

import jakarta.persistence.*;

@Entity
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    @ManyToOne
    @JoinColumn(name = "sub_competence_id")
    private SubCompetence subCompetence;

    private boolean validated;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Apprenant getApprenant() { return apprenant; }
    public void setApprenant(Apprenant apprenant) { this.apprenant = apprenant; }
    public SubCompetence getSubCompetence() { return subCompetence; }
    public void setSubCompetence(SubCompetence subCompetence) { this.subCompetence = subCompetence; }
    public boolean isValidated() { return validated; }
    public void setValidated(boolean validated) { this.validated = validated; }
} 