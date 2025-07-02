package com.example.enaaskills.controller;

import com.example.enaaskills.entity.Competence;
import com.example.enaaskills.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    @PostMapping
    public Competence create(@RequestBody Competence competence) {
        return competenceService.saveCompetence(competence);
    }

    @GetMapping
    public List<Competence> getAll() {
        return competenceService.getAllCompetences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competence> getById(@PathVariable Long id) {
        Optional<Competence> competence = competenceService.getCompetenceById(id);
        return competence.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
    }
} 