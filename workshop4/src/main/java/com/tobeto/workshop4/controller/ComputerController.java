package com.tobeto.workshop4.controller;

import com.tobeto.workshop4.dto.ComputerDto;
import com.tobeto.workshop4.entity.Computer;
import com.tobeto.workshop4.service.ComputerService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/bilgisayar")
public class ComputerController {
    @Autowired
    private  ComputerService computerService;
    @Autowired
    private  ModelMapper mapper;

    @GetMapping
    public List<ComputerDto> getComputers() {
       return computerService.getComputers().
        stream().map(computer -> mapper.map(computer,ComputerDto.class)).toList();
    }

    @GetMapping("/{marka}/{model}")
    public Optional<Computer> getComputer(@PathVariable String marka,@PathVariable String model) {
        return computerService.getComputer(marka,model);

    }
    @DeleteMapping("/{marka}/{model}")
    public String deleteComputer(String marka, String model) {
        computerService.deleteComputer(marka,model);
        JSONObject sonuc=new JSONObject();
        sonuc.put("mesaj","computer deleted");
        return sonuc.toString();
    }
    @PostMapping
    public String saveComputer(@RequestBody Computer computer) {
        computerService.saveComputer(computer.getMarka(),computer.getModel() ,computer.getRam());
        JSONObject sonuc=new JSONObject();
        sonuc.put("mesaj","computer created");
        return sonuc.toString();

    }
    @PutMapping("/{marka}/{model}")
    public String updateComputer(String marka, String model, int ram) {
        computerService.updateComputer(marka, model, ram);
        JSONObject sonuc=new JSONObject();
        sonuc.put("mesaj","computer updated");
        return sonuc.toString();

    }


}
