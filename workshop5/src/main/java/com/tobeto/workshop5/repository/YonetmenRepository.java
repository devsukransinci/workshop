package com.tobeto.workshop5.repository;

import com.tobeto.workshop5.entity.Yonetmen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YonetmenRepository extends JpaRepository<Yonetmen, Integer> {
    public List<Yonetmen> findByFilmlerAdi(String filmAdi);

}
