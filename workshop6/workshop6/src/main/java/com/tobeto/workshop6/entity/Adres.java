package com.tobeto.workshop6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Adres extends EntityBase{
    private String il;
    private String ilce;
    private String adres;
    @ManyToOne
    private Personel personel;
}
