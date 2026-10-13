package org.example.vuebackend.mapper;

import org.example.vuebackend.model.FormEntity;
import org.example.vuebackend.model.FormRequest;
import org.example.vuebackend.model.FormResponse;
import org.springframework.stereotype.Component;

@Component
public class FormMapper {

    public static FormEntity toEntity(FormRequest request) {
        FormEntity entity = new FormEntity();
        entity.setFullname(request.fullname());
        entity.setPhone(request.phone());
        entity.setEmail(request.email());
        entity.setDateOfBirthday(request.dateOfBirthday());
        entity.setGender(request.gender());
        entity.setLanguages(request.languages());
        entity.setBio(request.bio());
        return entity;
    }

    public static FormResponse toResponse(FormEntity entity) {
        return new FormResponse(
                entity.getId(),
                entity.getFullname(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getDateOfBirthday(),
                entity.getGender(),
                entity.getLanguages(),
                entity.getBio(),
                entity.getCreatedAt()
        );
    }
}