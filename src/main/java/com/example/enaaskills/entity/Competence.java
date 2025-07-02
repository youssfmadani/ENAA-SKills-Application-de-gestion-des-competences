package com.example.enaaskills.entity;

import jakarta.persistence.*;
import java.util.List;
import com.example.enaaskills.entity.SubCompetence;

@Entity
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubCompetence> subCompetences;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<SubCompetence> getSubCompetences() { return subCompetences; }
    public void setSubCompetences(List<SubCompetence> subCompetences) { this.subCompetences = subCompetences; }
} 