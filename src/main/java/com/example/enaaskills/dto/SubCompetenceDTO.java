package com.example.enaaskills.dto;

public class SubCompetenceDTO {
    private Long id;
    private String name;
    private String description;
    private boolean validated;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isValidated() { return validated; }
    public void setValidated(boolean validated) { this.validated = validated; }
} 