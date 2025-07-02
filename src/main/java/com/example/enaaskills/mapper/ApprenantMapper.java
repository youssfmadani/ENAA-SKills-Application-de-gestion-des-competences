package com.example.enaaskills.mapper;

import com.example.enaaskills.dto.ApprenantDTO;
import com.example.enaaskills.entity.Apprenant;

public class ApprenantMapper {
    public static ApprenantDTO toDTO(Apprenant apprenant) {
        ApprenantDTO dto = new ApprenantDTO();
        dto.setId(apprenant.getId());
        dto.setName(apprenant.getName());
        return dto;
    }

    public static Apprenant toEntity(ApprenantDTO dto) {
        Apprenant apprenant = new Apprenant();
        apprenant.setId(dto.getId());
        apprenant.setName(dto.getName());
        return apprenant;
    }
} 