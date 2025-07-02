package com.example.enaaskills.service;

import com.example.enaaskills.entity.SubCompetence;
import com.example.enaaskills.repository.SubCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCompetenceService {
    @Autowired
    private SubCompetenceRepository subCompetenceRepository;

    public SubCompetence saveSubCompetence(SubCompetence subCompetence) {
        return subCompetenceRepository.save(subCompetence);
    }

    public List<SubCompetence> getAllSubCompetences() {
        return subCompetenceRepository.findAll();
    }

    public Optional<SubCompetence> getSubCompetenceById(Long id) {
        return subCompetenceRepository.findById(id);
    }

    public void deleteSubCompetence(Long id) {
        subCompetenceRepository.deleteById(id);
    }

    public SubCompetence updateValidationStatus(Long id, boolean validated) {
        Optional<SubCompetence> optional = subCompetenceRepository.findById(id);
        if (optional.isPresent()) {
            SubCompetence sub = optional.get();
            sub.setValidated(validated);
            return subCompetenceRepository.save(sub);
        }
        return null;
    }
} 