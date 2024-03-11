package com.tobeto.workshop3.dao;

import com.tobeto.workshop3.bean.Personel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonelDao {
    private List<Personel> personels=new ArrayList<Personel>();
    public List<Personel> getPersonels(){
        return personels;
    }
    public Optional <Personel> getPersonel(String id){
        return  personels.stream().filter(personel -> personel.getId().equals(id)).findFirst();

    }
    public void  DeletePersonel(String id){
        Optional <Personel>optionalPersonel =getPersonel(id);
        if (optionalPersonel.isEmpty()) {
            personels.remove(optionalPersonel.get());
        }
    }
    public void SavePersonel(Personel personel){
        personels.add(personel);
    }
    public void  updatePersonel (String id ,Personel personel){
        Optional<Personel> optionalPersonel =getPersonel(id);
        if (optionalPersonel.isPresent()){
            Personel dbPersonel = optionalPersonel.get();
            dbPersonel.setAdi(personel.getAdi());
            dbPersonel.setSoyadi(personel.getSoyadi());
            dbPersonel.setDogumTarihi(personel.getDogumTarihi());
        }
    }
}
