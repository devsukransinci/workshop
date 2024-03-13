package com.tobeto.workshop6.repository;

import com.tobeto.workshop6.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdresRepository extends JpaRepository<Adres, UUID> {

}
