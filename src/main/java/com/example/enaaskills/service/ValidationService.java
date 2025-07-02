package com.example.enaaskills.service;

import com.example.enaaskills.entity.Validation;
import com.example.enaaskills.repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidationService {
    @Autowired
    private ValidationRepository validationRepository;

    public Validation saveValidation(Validation validation) {
        return validationRepository.save(validation);
    }

    public List<Validation> getAllValidations() {
        return validationRepository.findAll();
    }

    public Optional<Validation> getValidationById(Long id) {
        return validationRepository.findById(id);
    }

    public void deleteValidation(Long id) {
        validationRepository.deleteById(id);
    }
} 