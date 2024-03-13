package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Anne {
	private String name;
    private int age;
    private Cocuk cocuk1;
    private Cocuk cocuk2;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cocuk getCocuk1() {
        return cocuk1;
    }

    public void setCocuk1(Cocuk cocuk1) {
        this.cocuk1 = cocuk1;
    }

    public Cocuk getCocuk2() {
        return cocuk2;
    }

    public void setCocuk2(Cocuk cocuk2) {
        this.cocuk2 = cocuk2;
    }
}


