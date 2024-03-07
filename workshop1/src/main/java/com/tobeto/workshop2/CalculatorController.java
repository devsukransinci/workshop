package com.tobeto.workshop2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/toplama")
    public double add(@RequestParam double sayi1, @RequestParam double sayi2) {
        return sayi1 + sayi1;
    }

    @GetMapping("/cıkarma")
    public double subtract(@RequestParam double sayi1, @RequestParam double sayi2) {
        return sayi1 - sayi2;
    }

    @GetMapping("/carpma")
    public double multiply(@RequestParam double sayi1, @RequestParam double sayi2) {
        return sayi1 * sayi2;
    }

    @GetMapping("/bölme")
    public String divide(@RequestParam double sayi1, @RequestParam double sayi2) {
        if (sayi2 == 0) {
            return "Error: Division by zero";
        }
        return Double.toString(sayi1 / sayi2);
    }

}
