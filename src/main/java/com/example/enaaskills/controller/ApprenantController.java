package com.example.enaaskills.controller;

import com.example.enaaskills.dto.ApprenantDTO;
import com.example.enaaskills.entity.Apprenant;
import com.example.enaaskills.mapper.ApprenantMapper;
import com.example.enaaskills.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {
    @Autowired
    private ApprenantService apprenantService;

    @PostMapping
    public ResponseEntity<ApprenantDTO> create(@RequestBody ApprenantDTO apprenantDTO) {
        Apprenant apprenant = ApprenantMapper.toEntity(apprenantDTO);
        Apprenant saved = apprenantService.saveApprenant(apprenant);
        return ResponseEntity.ok(ApprenantMapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<ApprenantDTO>> getAll() {
        List<ApprenantDTO> dtos = apprenantService.getAllApprenants().stream()
                .map(ApprenantMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApprenantDTO> getById(@PathVariable Long id) {
        Optional<Apprenant> apprenant = apprenantService.getApprenantById(id);
        return apprenant.map(a -> ResponseEntity.ok(ApprenantMapper.toDTO(a)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        apprenantService.deleteApprenant(id);
        return ResponseEntity.noContent().build();
    }
} 