package com.tobeto.workshop3.controller;

import com.tobeto.workshop3.PersonelService.PersonelService;
import com.tobeto.workshop3.bean.Personel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonelController {
@Autowired
    private PersonelService personelService;
@PostMapping()
    public String createPersonel(@RequestBody Personel personel){
              personelService.createPersonel(personel);
              JSONObject sonuc =new JSONObject();
         sonuc.put("sonuc","Personel olusturuldu.");
              return sonuc.toString();
    }
    @GetMapping
     public List<Personel> getTumPersoneller(){
        return personelService.getTumPersonel();
     }

}
