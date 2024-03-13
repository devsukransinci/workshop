package com.tobeto.workshop6.test;

import com.tobeto.workshop6.entity.Personel;
import com.tobeto.workshop6.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class Test implements CommandLineRunner {
    @Autowired
    private PersonelRepository personelRepository;
    @Override
    public void run(String... args) throws Exception {
        Personel p=new Personel();
      p=  personelRepository.save(p);
      p.setAdi("Aslı");
      p=personelRepository.save(p);

    }
}
