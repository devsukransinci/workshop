package com.tobeto.workshop6.service;

import com.tobeto.workshop6.entity.Adres;
import com.tobeto.workshop6.repository.AdresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresService {
    @Autowired
    private AdresRepository adresRepository;

    @Transactional
    public Adres addAddressToPersonel(Adres adres) {
        return adresRepository.save(adres);
    }
}
