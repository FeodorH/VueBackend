package org.example.vuebackend.model;

import java.time.LocalDateTime;
import java.util.List;

public record FormResponse(
    Long id,
    String name,
    String email,
    String phone,
    String dateOfBirthday,
    String gender,
    List<String> languages,
    String bio,
    LocalDateTime createdAt
    ){}
