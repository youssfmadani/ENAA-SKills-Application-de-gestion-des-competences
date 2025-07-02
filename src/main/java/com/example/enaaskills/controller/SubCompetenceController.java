package com.example.enaaskills.controller;

import com.example.enaaskills.dto.SubCompetenceDTO;
import com.example.enaaskills.entity.SubCompetence;
import com.example.enaaskills.mapper.SubCompetenceMapper;
import com.example.enaaskills.service.SubCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sub-competences")
public class SubCompetenceController {
    @Autowired
    private SubCompetenceService subCompetenceService;

    @PostMapping
    public ResponseEntity<SubCompetenceDTO> create(@RequestBody SubCompetenceDTO subCompetenceDTO) {
        SubCompetence sub = SubCompetenceMapper.toEntity(subCompetenceDTO);
        SubCompetence saved = subCompetenceService.saveSubCompetence(sub);
        return ResponseEntity.ok(SubCompetenceMapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<SubCompetenceDTO>> getAll() {
        List<SubCompetenceDTO> dtos = subCompetenceService.getAllSubCompetences().stream()
                .map(SubCompetenceMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCompetenceDTO> getById(@PathVariable Long id) {
        Optional<SubCompetence> sub = subCompetenceService.getSubCompetenceById(id);
        return sub.map(s -> ResponseEntity.ok(SubCompetenceMapper.toDTO(s)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/validate")
    public ResponseEntity<SubCompetenceDTO> updateValidation(@PathVariable Long id, @RequestParam boolean validated) {
        SubCompetence updated = subCompetenceService.updateValidationStatus(id, validated);
        if (updated != null) return ResponseEntity.ok(SubCompetenceMapper.toDTO(updated));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subCompetenceService.deleteSubCompetence(id);
        return ResponseEntity.noContent().build();
    }
} 