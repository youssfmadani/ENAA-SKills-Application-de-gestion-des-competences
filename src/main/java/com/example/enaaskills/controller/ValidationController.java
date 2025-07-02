package com.example.enaaskills.controller;

import com.example.enaaskills.entity.Validation;
import com.example.enaaskills.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/validations")
public class ValidationController {
    @Autowired
    private ValidationService validationService;

    @PostMapping
    public Validation create(@RequestBody Validation validation) {
        return validationService.saveValidation(validation);
    }

    @GetMapping
    public List<Validation> getAll() {
        return validationService.getAllValidations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Validation> getById(@PathVariable Long id) {
        Optional<Validation> validation = validationService.getValidationById(id);
        return validation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        validationService.deleteValidation(id);
    }
} 