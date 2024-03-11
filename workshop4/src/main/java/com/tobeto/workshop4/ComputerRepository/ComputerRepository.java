package com.tobeto.workshop4.ComputerRepository;

import com.tobeto.workshop4.entity.Computer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ComputerRepository {
    private List<Computer> computers=new ArrayList<>();

    public List<Computer> getComputers(){
        return computers;
    }
    public Optional<Computer> getComputer(String marka , String model){
        return computers.stream().filter(c -> c.getMarka().equals(marka)&& c.getModel().equals(model))
                .findFirst();
    }
    public void deleteComputer(String marka, String model){
        Optional<Computer> oComputer =getComputer(marka,model);
        if (oComputer.isPresent()) {
            computers.remove(oComputer.get());
        }
    }
  public void saveComputer(Computer computer){
        computers.add(computer);
  }

  public void updateComputer(String marka,String model,int ram){
      deleteComputer(marka,model);
      saveComputer(new Computer(marka,model,ram));
  }

}
