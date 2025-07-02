package com.example.enaaskills.controller;

import com.example.enaaskills.entity.SubCompetence;
import com.example.enaaskills.service.SubCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sub-competences")
public class SubCompetenceController {
    @Autowired
    private SubCompetenceService subCompetenceService;

    @PostMapping
    public SubCompetence create(@RequestBody SubCompetence subCompetence) {
        return subCompetenceService.saveSubCompetence(subCompetence);
    }

    @GetMapping
    public List<SubCompetence> getAll() {
        return subCompetenceService.getAllSubCompetences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCompetence> getById(@PathVariable Long id) {
        Optional<SubCompetence> sub = subCompetenceService.getSubCompetenceById(id);
        return sub.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/validate")
    public ResponseEntity<SubCompetence> updateValidation(@PathVariable Long id, @RequestParam boolean validated) {
        SubCompetence updated = subCompetenceService.updateValidationStatus(id, validated);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subCompetenceService.deleteSubCompetence(id);
    }
} 