package com.example.enaaskills.dto;

import java.util.List;
import com.example.enaaskills.dto.SubCompetenceDTO;

public class CompetenceDTO {
    private Long id;
    private String name;
    private String description;
    private List<SubCompetenceDTO> subCompetences;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<SubCompetenceDTO> getSubCompetences() { return subCompetences; }
    public void setSubCompetences(List<SubCompetenceDTO> subCompetences) { this.subCompetences = subCompetences; }
} 