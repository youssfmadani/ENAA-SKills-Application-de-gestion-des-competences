package com.example.enaaskills.controller;

import com.example.enaaskills.entity.Apprenant;
import com.example.enaaskills.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {
    @Autowired
    private ApprenantService apprenantService;

    @PostMapping
    public Apprenant create(@RequestBody Apprenant apprenant) {
        return apprenantService.saveApprenant(apprenant);
    }

    @GetMapping
    public List<Apprenant> getAll() {
        return apprenantService.getAllApprenants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getById(@PathVariable Long id) {
        Optional<Apprenant> apprenant = apprenantService.getApprenantById(id);
        return apprenant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        apprenantService.deleteApprenant(id);
    }
} 