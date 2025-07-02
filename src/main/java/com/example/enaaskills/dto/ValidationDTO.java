package com.example.enaaskills.dto;

public class ValidationDTO {
    private Long id;
    private Long apprenantId;
    private Long subCompetenceId;
    private boolean validated;
    private String apprenantName;
    private String subCompetenceName;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getApprenantId() { return apprenantId; }
    public void setApprenantId(Long apprenantId) { this.apprenantId = apprenantId; }
    public Long getSubCompetenceId() { return subCompetenceId; }
    public void setSubCompetenceId(Long subCompetenceId) { this.subCompetenceId = subCompetenceId; }
    public boolean isValidated() { return validated; }
    public void setValidated(boolean validated) { this.validated = validated; }
    public String getApprenantName() { return apprenantName; }
    public void setApprenantName(String apprenantName) { this.apprenantName = apprenantName; }
    public String getSubCompetenceName() { return subCompetenceName; }
    public void setSubCompetenceName(String subCompetenceName) { this.subCompetenceName = subCompetenceName; }
} 