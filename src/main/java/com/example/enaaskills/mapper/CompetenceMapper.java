package com.example.enaaskills.mapper;

import com.example.enaaskills.dto.CompetenceDTO;
import com.example.enaaskills.dto.SubCompetenceDTO;
import com.example.enaaskills.entity.Competence;
import com.example.enaaskills.entity.SubCompetence;
import com.example.enaaskills.mapper.SubCompetenceMapper;
import java.util.List;
import java.util.stream.Collectors;

public class CompetenceMapper {
    public static CompetenceDTO toDTO(Competence competence) {
        CompetenceDTO dto = new CompetenceDTO();
        dto.setId(competence.getId());
        dto.setName(competence.getName());
        dto.setDescription(competence.getDescription());
        if (competence.getSubCompetences() != null) {
            List<SubCompetenceDTO> subDTOs = competence.getSubCompetences().stream()
                .map(SubCompetenceMapper::toDTO)
                .collect(Collectors.toList());
            dto.setSubCompetences(subDTOs);
        }
        return dto;
    }

    public static Competence toEntity(CompetenceDTO dto) {
        Competence competence = new Competence();
        competence.setId(dto.getId());
        competence.setName(dto.getName());
        competence.setDescription(dto.getDescription());
        if (dto.getSubCompetences() != null) {
            List<SubCompetence> subs = dto.getSubCompetences().stream()
                .map(SubCompetenceMapper::toEntity)
                .collect(Collectors.toList());
            competence.setSubCompetences(subs);
        }
        return competence;
    }
} 