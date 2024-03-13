package com.tobeto.workshop5.controller;

import com.tobeto.workshop5.dto.YonetmenDto;
import com.tobeto.workshop5.entity.Yonetmen;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/yonetmen")
public class YonetmenController {@Autowired
private YonetmenService yonetmenService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @Transactional
    public List<YonetmenDto> getTumYonetmenler() {
        List<Yonetmen> dbYonetmenler = yonetmenService.getTumYonetmenler();
        return dbYonetmenler.stream().map(y -> {
            YonetmenDto dto = mapper.map(y, YonetmenDto.class);
            dto.setAd(y.getAdi());
            return dto;
        }).toList();


    }

    @GetMapping("/film")
    public List<YonetmenDto> getMethodName(@RequestParam String filmAdi) {
        List<Yonetmen> yonetmenler = yonetmenService.getYonetmenler(filmAdi);
        return yonetmenler.stream().map(y -> {
            YonetmenDto dto = mapper.map(y, YonetmenDto.class);
            dto.setAd(y.getAdi());
            return dto;
        }).toList();
    }

}
