package com.tobeto.workshop5.service;

import com.tobeto.workshop5.entity.Yonetmen;
import com.tobeto.workshop5.repository.YonetmenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YonetmenService {
    @Autowired
    private YonetmenRepository yonetmenRepository;

    public List<Yonetmen> getTumYonetmenler() {
        return yonetmenRepository.findAll();
    }

    public List<Yonetmen> getYonetmenler(String filmAdi) {
        return yonetmenRepository.findByFilmlerAdi(filmAdi);
    }
}
