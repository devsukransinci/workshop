package com.tobeto.workshop6.repository;

import com.tobeto.workshop6.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface KullaniciRepository extends JpaRepository<Kullanici, UUID> {
    Optional<Kullanici> findByEmail(String email);
}
