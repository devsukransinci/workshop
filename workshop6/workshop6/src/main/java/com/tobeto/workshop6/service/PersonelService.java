package com.tobeto.workshop6.service;

import com.tobeto.workshop6.entity.Personel;
import com.tobeto.workshop6.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonelService {
    @Autowired
    private PersonelRepository personelRepository;

    @Transactional
    public Personel addPersonel(Personel personel){
       return personelRepository.save(personel);
    }
}
