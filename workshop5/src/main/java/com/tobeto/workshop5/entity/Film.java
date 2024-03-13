package com.tobeto.workshop5.entity;

import jakarta.persistence.*;

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String adi;
    @ManyToOne(fetch = FetchType.EAGER)
    private Yonetmen yonetmen;
}
