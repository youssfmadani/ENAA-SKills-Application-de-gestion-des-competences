package com.example.enaaskills.controller;

import com.example.enaaskills.dto.CompetenceDTO;
import com.example.enaaskills.entity.Competence;
import com.example.enaaskills.mapper.CompetenceMapper;
import com.example.enaaskills.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    @PostMapping
    public ResponseEntity<CompetenceDTO> create(@RequestBody CompetenceDTO competenceDTO) {
        Competence competence = CompetenceMapper.toEntity(competenceDTO);
        Competence saved = competenceService.saveCompetence(competence);
        return ResponseEntity.ok(CompetenceMapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<CompetenceDTO>> getAll() {
        List<CompetenceDTO> dtos = competenceService.getAllCompetences().stream()
                .map(CompetenceMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenceDTO> getById(@PathVariable Long id) {
        Optional<Competence> competence = competenceService.getCompetenceById(id);
        return competence.map(c -> ResponseEntity.ok(CompetenceMapper.toDTO(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
        return ResponseEntity.noContent().build();
    }
} 