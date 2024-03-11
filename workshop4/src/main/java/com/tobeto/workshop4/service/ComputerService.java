package com.tobeto.workshop4.service;

import com.tobeto.workshop4.ComputerRepository.ComputerRepository;
import com.tobeto.workshop4.entity.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;
    public List<Computer> getComputers(){
    return computerRepository.getComputers();
    }

    public Optional<Computer> getComputer(String marka, String model) {
        return computerRepository.getComputer(marka,model);

    }

    public void deleteComputer(String marka, String model) {
         computerRepository.deleteComputer(marka,model);
    }

    public void saveComputer(String marka, String model, int ram) {
    computerRepository.saveComputer(new Computer(marka,model,ram));

    }

    public void updateComputer(String marka, String model, int ram) {
        computerRepository.updateComputer(marka, model, ram);

    }
}