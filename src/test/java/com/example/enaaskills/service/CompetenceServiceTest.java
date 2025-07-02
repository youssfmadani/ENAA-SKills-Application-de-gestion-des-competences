package com.example.enaaskills.service;

import com.example.enaaskills.entity.Competence;
import com.example.enaaskills.entity.SubCompetence;
import com.example.enaaskills.repository.CompetenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompetenceServiceTest {
    @Mock
    private CompetenceRepository competenceRepository;

    @InjectMocks
    private CompetenceService competenceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCompetence() {
        Competence competence = new Competence();
        when(competenceRepository.save(competence)).thenReturn(competence);
        assertEquals(competence, competenceService.saveCompetence(competence));
    }

    @Test
    void testGetCompetenceById() {
        Competence competence = new Competence();
        competence.setId(1L);
        when(competenceRepository.findById(1L)).thenReturn(Optional.of(competence));
        Optional<Competence> found = competenceService.getCompetenceById(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }

    @Test
    void testIsCompetenceAcquired_AllValidated() {
        SubCompetence sub1 = new SubCompetence(); sub1.setValidated(true);
        SubCompetence sub2 = new SubCompetence(); sub2.setValidated(true);
        Competence competence = new Competence();
        competence.setSubCompetences(Arrays.asList(sub1, sub2));
        assertTrue(competenceService.isCompetenceAcquired(competence));
    }

    @Test
    void testIsCompetenceAcquired_NotAllValidated() {
        SubCompetence sub1 = new SubCompetence(); sub1.setValidated(true);
        SubCompetence sub2 = new SubCompetence(); sub2.setValidated(false);
        Competence competence = new Competence();
        competence.setSubCompetences(Arrays.asList(sub1, sub2));
        assertFalse(competenceService.isCompetenceAcquired(competence));
    }

    @Test
    void testIsCompetenceAcquired_EmptyList() {
        Competence competence = new Competence();
        competence.setSubCompetences(Collections.emptyList());
        assertFalse(competenceService.isCompetenceAcquired(competence));
    }
} 