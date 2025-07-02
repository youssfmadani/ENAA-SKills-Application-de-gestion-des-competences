package com.example.enaaskills.mapper;

import com.example.enaaskills.dto.ValidationDTO;
import com.example.enaaskills.entity.Validation;
import com.example.enaaskills.entity.Apprenant;
import com.example.enaaskills.entity.SubCompetence;

public class ValidationMapper {
    public static ValidationDTO toDTO(Validation validation) {
        ValidationDTO dto = new ValidationDTO();
        dto.setId(validation.getId());
        if (validation.getApprenant() != null) {
            dto.setApprenantId(validation.getApprenant().getId());
            dto.setApprenantName(validation.getApprenant().getName());
        }
        if (validation.getSubCompetence() != null) {
            dto.setSubCompetenceId(validation.getSubCompetence().getId());
            dto.setSubCompetenceName(validation.getSubCompetence().getName());
        }
        dto.setValidated(validation.isValidated());
        return dto;
    }

    public static Validation toEntity(ValidationDTO dto) {
        Validation validation = new Validation();
        validation.setId(dto.getId());
        if (dto.getApprenantId() != null || dto.getApprenantName() != null) {
            Apprenant apprenant = new Apprenant();
            apprenant.setId(dto.getApprenantId());
            apprenant.setName(dto.getApprenantName());
            validation.setApprenant(apprenant);
        }
        if (dto.getSubCompetenceId() != null || dto.getSubCompetenceName() != null) {
            SubCompetence sub = new SubCompetence();
            sub.setId(dto.getSubCompetenceId());
            sub.setName(dto.getSubCompetenceName());
            validation.setSubCompetence(sub);
        }
        validation.setValidated(dto.isValidated());
        return validation;
    }
} 