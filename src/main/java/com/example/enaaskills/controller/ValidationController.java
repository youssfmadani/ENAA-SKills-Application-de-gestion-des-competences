package com.example.enaaskills.controller;

import com.example.enaaskills.dto.ValidationDTO;
import com.example.enaaskills.entity.Validation;
import com.example.enaaskills.mapper.ValidationMapper;
import com.example.enaaskills.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/validations")
public class ValidationController {
    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity<ValidationDTO> create(@RequestBody ValidationDTO validationDTO) {
        Validation validation = ValidationMapper.toEntity(validationDTO);
        Validation saved = validationService.saveValidation(validation);
        return ResponseEntity.ok(ValidationMapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<ValidationDTO>> getAll() {
        List<ValidationDTO> dtos = validationService.getAllValidations().stream()
                .map(ValidationMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidationDTO> getById(@PathVariable Long id) {
        Optional<Validation> validation = validationService.getValidationById(id);
        return validation.map(v -> ResponseEntity.ok(ValidationMapper.toDTO(v)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        validationService.deleteValidation(id);
        return ResponseEntity.noContent().build();
    }
} 