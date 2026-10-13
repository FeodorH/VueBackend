package org.example.vuebackend.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record FormRequest(
    @NotBlank String fullname,
    @NotBlank
    String phone,
    @Email
    String email,
    String dateOfBirthday,
    String gender,
    List<String> languages,
    String bio,
    Boolean agreement){}