package com.tobeto.workshop3.PersonelService;

import com.tobeto.workshop3.bean.Personel;
import com.tobeto.workshop3.dao.PersonelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelService {

    @Autowired
    private  PersonelDao personelDao;
    public void createPersonel(Personel personel){
        personelDao.SavePersonel(personel);

    }
    public Optional<Personel> getPersonel(String id){
        return personelDao.getPersonel(id);
    }
    public void deletePersonel(String id){
        personelDao.DeletePersonel(id);
    }

    public void updatePersonel(String id ,Personel personel){
        personelDao.updatePersonel(id ,personel);
    }
    public List<Personel> getTumPersonel(){
        return personelDao.getPersonels();
    }
}
