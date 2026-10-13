package org.example.vuebackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "form_entity",
    uniqueConstraints = @UniqueConstraint(
            name = "uk_form_email",
            columnNames = "email"
    )
)
public class FormEntity {

    public FormEntity(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    private String phone;
    private String email;
    private String dateOfBirthday;
    private String gender;

    @Column(length = 2000)
    private String bio;

    @ElementCollection
    @CollectionTable(name = "article_languages", joinColumns = @JoinColumn(name = "article_id"))
    @Column(name = "language")
    private List<String> languages;

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public String getGender() {
        return gender;
    }

    public String getBio() {
        return bio;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private LocalDateTime createdAt = LocalDateTime.now();
}