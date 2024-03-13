package com.tobeto.workshop6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Personel extends EntityBase{
    private String adi;
    private String soyadi;
    @Column(unique = true)
    private String email;

    @ManyToOne
    private Bolum bolum;

    @OneToMany(mappedBy = "personel")
    private List<Adres> adresler;
}
