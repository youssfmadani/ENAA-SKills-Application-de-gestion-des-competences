package com.example.enaaskills.service;

import com.example.enaaskills.entity.Competence;
import com.example.enaaskills.entity.SubCompetence;
import com.example.enaaskills.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository competenceRepository;

    public Competence saveCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public Optional<Competence> getCompetenceById(Long id) {
        return competenceRepository.findById(id);
    }

    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }

    public boolean isCompetenceAcquired(Competence competence) {
        List<SubCompetence> subCompetences = competence.getSubCompetences();
        if (subCompetences == null || subCompetences.isEmpty()) return false;
        return subCompetences.stream().allMatch(SubCompetence::isValidated);
    }
} 