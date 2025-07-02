package com.example.enaaskills.service;

import com.example.enaaskills.entity.Apprenant;
import com.example.enaaskills.repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprenantService {
    @Autowired
    private ApprenantRepository apprenantRepository;

    public Apprenant saveApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    public List<Apprenant> getAllApprenants() {
        return apprenantRepository.findAll();
    }

    public Optional<Apprenant> getApprenantById(Long id) {
        return apprenantRepository.findById(id);
    }

    public void deleteApprenant(Long id) {
        apprenantRepository.deleteById(id);
    }
} 