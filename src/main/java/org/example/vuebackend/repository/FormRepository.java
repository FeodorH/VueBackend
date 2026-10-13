package org.example.vuebackend.repository;

import org.example.vuebackend.model.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<FormEntity, Long> {
    boolean existsByEmail(String email);
}
