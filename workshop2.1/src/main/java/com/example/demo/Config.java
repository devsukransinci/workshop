package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
    public Anne anne() {
		Anne anne = new Anne();
		anne.setName("Makbule");
		anne.setAge(38);

        Cocuk cocuk1 = new Cocuk();
        cocuk1.setName("Kamile");
        cocuk1.setAge(13);
        Kitap kitap1 = new Kitap();
        kitap1.setName("Yuvamız");
        cocuk1.setKitap(kitap1);
        anne.setCocuk1(cocuk1);

        Cocuk cocuk2 = new Cocuk();
        cocuk2.setName("Murat");
        cocuk2.setAge(15);
        Kitap kitap2 = new Kitap();
        kitap2.setName("Kuslar");
        cocuk2.setKitap(kitap2);
        anne.setCocuk2(cocuk2);

        return anne;
    }
}