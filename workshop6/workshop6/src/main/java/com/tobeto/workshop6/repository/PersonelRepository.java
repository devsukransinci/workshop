package com.tobeto.workshop6.repository;

import com.tobeto.workshop6.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonelRepository extends JpaRepository<Personel, UUID> {

}
