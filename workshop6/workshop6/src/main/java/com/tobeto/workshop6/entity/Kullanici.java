package com.tobeto.workshop6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Kullanici  extends EntityBase {
    @Column(unique = true)
    private String email;

    private String sifre;
}
