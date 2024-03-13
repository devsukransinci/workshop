package com.tobeto.workshop6.controller;

import com.tobeto.workshop6.dto.personel.PersonelYaratRequestDTO;
import com.tobeto.workshop6.dto.personel.PersonelYaratResponseDTO;
import com.tobeto.workshop6.entity.Personel;
import com.tobeto.workshop6.service.PersonelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personel")
public class PersonelController {
    @Autowired
    private PersonelService personelService;
    @Autowired
    @Qualifier("requestMapper")
    private ModelMapper requestMapper;
    @Autowired
    @Qualifier("responseMapper")
    private ModelMapper responseMapper;
    @PostMapping
    public PersonelYaratResponseDTO personelYarat(@RequestBody PersonelYaratRequestDTO dto){
        Personel personel =requestMapper.map(dto,Personel.class);
        personel=personelService.addPersonel(personel);
        return responseMapper.map(personel,PersonelYaratResponseDTO.class);


    }
}
