package com.tobeto.workshop6.controller;

import com.tobeto.workshop6.dto.adres.AdresYaratRequestDTO;
import com.tobeto.workshop6.dto.adres.AdresYaratResponseDTO;
import com.tobeto.workshop6.dto.personel.PersonelYaratRequestDTO;
import com.tobeto.workshop6.dto.personel.PersonelYaratResponseDTO;
import com.tobeto.workshop6.entity.Adres;
import com.tobeto.workshop6.entity.Personel;
import com.tobeto.workshop6.service.AdresService;
import com.tobeto.workshop6.service.PersonelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/adres")
public class AdresController {
    @Autowired
    private AdresService adresService;
    @Autowired
    @Qualifier("requestMapper")
    private ModelMapper requestMapper;
    @Autowired
    @Qualifier("responseMapper")
    private ModelMapper responseMapper;
    @PostMapping
    public AdresYaratResponseDTO adresEkle(@RequestBody AdresYaratRequestDTO dto){
        Adres adres =requestMapper.map(dto, Adres.class);
        Personel personel =new Personel();
        personel.setId(UUID.fromString(dto.getPersonelId()));
        adres.setPersonel(personel);

        adres=adresService.addAddressToPersonel(adres);
        return responseMapper.map(adres,AdresYaratResponseDTO.class);


    }
}
