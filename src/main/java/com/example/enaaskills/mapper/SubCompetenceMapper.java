package com.example.enaaskills.mapper;

import com.example.enaaskills.dto.SubCompetenceDTO;
import com.example.enaaskills.entity.SubCompetence;

public class SubCompetenceMapper {
    public static SubCompetenceDTO toDTO(SubCompetence sub) {
        SubCompetenceDTO dto = new SubCompetenceDTO();
        dto.setId(sub.getId());
        dto.setName(sub.getName());
        dto.setDescription(sub.getDescription());
        dto.setValidated(sub.isValidated());
        return dto;
    }

    public static SubCompetence toEntity(SubCompetenceDTO dto) {
        SubCompetence sub = new SubCompetence();
        sub.setId(dto.getId());
        sub.setName(dto.getName());
        sub.setDescription(dto.getDescription());
        sub.setValidated(dto.isValidated());
        return sub;
    }
} 