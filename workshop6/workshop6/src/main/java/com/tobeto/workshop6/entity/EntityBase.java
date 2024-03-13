package com.tobeto.workshop6.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@MappedSuperclass
@Data
public class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime yaratmaTarihi;
    private LocalDateTime guncellemeTarihi;
    @PrePersist
    public void prePersist(){
        yaratmaTarihi =LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        guncellemeTarihi =LocalDateTime.now();
    }
}
